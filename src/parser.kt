import java.io.Reader
import java.util.HashSet

data class Token(val tipo: Int, val lexeme: String, val lin: Int) {
    companion object {
        const val EOF = 0
        const val NUM = 1
        const val ID = 2
        const val WRITE = 3
        const val READ = 4
        const val IF = 5
        const val THEN = 6
        const val ELSE = 7
        const val END = 8
        const val REPEAT = 9
        const val UNTIL = 10
        const val ATRIB = 11

        internal var names = arrayOf("eof", "num", "id", "write", "read", "if", "then", "else", "end", "repeat", "until", ":=")

        fun tokenName(tipo: Int): String {
            return if (tipo < names.size) names[tipo] else "" + tipo.toChar()
        }
    }
}

class TINYParser(val scan: TINYScanner) {
    var la: Token = scan.token()

    fun skip() {
        la = scan.token()
    }

    fun match(tipo: Int): Tree {
        if (la.tipo == tipo) {
            val lexeme = la.lexeme
            skip()
            return Tree(lexeme)
        } else {
            throw RuntimeException("erro de sintaxe na linha " +
              la.lin + ", esperado " + Token.tokenName(tipo) +
            " e encontrado " + la.lexeme)
        }
    }

    fun match(tipo: Char): Tree {
        return match(tipo.toInt())
    }

    fun parse(): Tree {
        val res = S()
        if(la.tipo != Token.EOF)
            throw RuntimeException("esperado final da entrada na linha " + la.lin + ", mas encontrado " + la.lexeme)
        else
            return res
    }

    fun S(): Tree {
        val res = Tree("S")
        res.child(CMDS())
        return res
    }

    fun CMDS(): Tree {
        val res = Tree("CMDS")
        res.child(CMD())
        while(la.tipo == ';'.toInt()) {
            res.child(match(';'))
            res.child(CMD())
        }
        return res
    }

    fun CMD(): Tree {
        val res = Tree("CMD")
        when(la.tipo) {
            Token.IF -> {
                res.child(match(Token.IF))
                res.child(EXP())
                res.child(match(Token.THEN))
                res.child(CMDS())
                if(la.tipo == Token.ELSE) {
                    res.child(match(Token.ELSE))
                    res.child(CMDS())
                }
                res.child(match(Token.END))
            }
            Token.REPEAT -> {
                res.child(match(Token.REPEAT))
                res.child(CMDS())
                res.child(match(Token.UNTIL))
                res.child(EXP())
            }
            Token.ID -> {
                res.child(match(Token.ID))
                res.child(match(Token.ATRIB))
                res.child(EXP())
            }
            Token.READ -> {
                res.child(match(Token.READ))
                res.child(match(Token.ID))
            }
            Token.WRITE -> {
                res.child(match(Token.WRITE))
                res.child(EXP())
            }
            else -> throw RuntimeException(
                    "erro de sintaxe na linha " +
                            la.lin +
                            ", esperado comando mas encontrado "
                            + la.lexeme)
        }
        return res
    }

    fun EXP(): Tree {
        val res = Tree("EXP")
        res.child(SEXP())
        while(la.tipo == '<'.toInt() || la.tipo == '='.toInt()) {
            when(la.tipo) {
                '<'.toInt() -> {
                    res.child(match('<'))
                    res.child(SEXP())
                }
                '='.toInt() -> {
                    res.child(match('='))
                    res.child(SEXP())
                }
            }
        }
        return res
    }

    fun SEXP(): Tree {
        val res = Tree("SEXP")
        res.child(TERMO())
        while(la.tipo == '+'.toInt() || la.tipo == '-'.toInt()) {
            when(la.tipo) {
                '+'.toInt() -> {
                    res.child(match('+'))
                    res.child(TERMO())
                }
                '-'.toInt() -> {
                    res.child(match('-'))
                    res.child(TERMO())
                }
            }
        }
        return res
    }

    fun TERMO(): Tree {
        val res = Tree("TERMO")
        res.child(FATOR())
        while(la.tipo == '*'.toInt() || la.tipo == '/'.toInt()) {
            when(la.tipo) {
                '*'.toInt() -> {
                    res.child(match('*'))
                    res.child(FATOR())
                }
                '/'.toInt() -> {
                    res.child(match('/'))
                    res.child(FATOR())
                }
            }
        }
        return res
    }

    fun FATOR(): Tree {
        val res = Tree("FATOR")
        when(la.tipo) {
            '('.toInt() -> {
                res.child(match('('))
                res.child(EXP())
                res.child(match(')'))
            }
            Token.ID -> res.child(match(Token.ID))
            Token.NUM -> res.child(match(Token.NUM))
            else -> throw RuntimeException(
                    "erro de sintaxe na linha" +
                            la.lin +
                            ", esperado expressão mas achado " +
                            la.lexeme)
        }
        return res
    }
}
