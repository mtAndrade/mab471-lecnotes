class Parser(val scan: Scanner) {
    var la: Token = scan.token()

    fun le(tipo: Int): Token {
        if (la.tipo == tipo) {
            val tok = la
            la = scan.token()
            return tok
        } else {
            throw RuntimeException("esperado ${tipo.toChar()}, mas token inválido na linha ${la.lin}: $la")
        }
    }

    fun le(tipo: Char) = le(tipo.toInt())

    fun prog(): Prog {
        val cmds = mutableListOf<Cmd>()
        while (la.tipo != Token.EOF) {
            cmds.add(cmd())
            le(';')
        }
        return Prog(cmds)
    }

    fun cmd(): Cmd {
        when (la.tipo) {
            Token.ID -> { // atribuição
                val (_, lexeme, lin) = le(Token.ID)
                le('=')
                val exp = exp()
                return Atrib(lexeme, exp, lin)
            }
            Token.PRINT -> {
                val (_, _, lin) = le(Token.PRINT)
                val exp = exp()
                return Print(exp, lin)
            }
            else -> throw RuntimeException("comando inválido na linha ${la.lin}, token: $la")
        }
    }

    fun exp(): Exp {
        var exp1 = aexp()
        while (la.tipo == '+'.toInt() || la.tipo == '-'.toInt()) {
            if (la.tipo == '+'.toInt()) {
                val (_, _, lin) = le('+')
                exp1 = Soma(exp1, aexp(), lin)
            } else {
                val (_, _, lin) = le('-')
                exp1 = Sub(exp1, aexp(), lin)
            }
        }
        return exp1
    }

    fun aexp(): Exp {
        when (la.tipo) {
            Token.ID -> {
                val (_, lexeme, lin) = le(Token.ID)
                return Id(lexeme, lin)
            }
            Token.NUM -> {
                val (_, lexeme, lin) = le(Token.NUM)
                return Num(lexeme, lin)
            }
            '('.toInt() -> {
                le('(')
                val exp = exp()
                le(')')
                return exp
            }
            else -> throw RuntimeException("expressão inválida na linha ${la.lin}, token: $la")
        }
    }
}
