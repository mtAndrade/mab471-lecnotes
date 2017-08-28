import java.io.Reader
import java.util.HashSet

class Falha : RuntimeException()

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

abstract class Parser(val ent: List<Token>) {
    var pos = 0
    var pfalha = -1
    val tesp: MutableSet<String> = HashSet()

    constructor(ent: Reader) : this(tokens(ent))

    fun skip() {
        if (ent[pos].tipo != 0) pos++
    }

    fun match(tipo: Int): Tree {
        val tok = ent[pos]
        if (tok.tipo == tipo) {
            skip()
            return Tree(tok.lexeme)
        } else {
            if (pos == pfalha) {
                tesp.add(Token.tokenName(tipo))
            } else if (pos > pfalha) {
                pfalha = pos
                tesp.clear()
                tesp.add(Token.tokenName(tipo))
            }
            throw Falha()
        }
    }

    fun match(tipo: Char): Tree {
        return match(tipo.toInt())
    }

    abstract fun parse(): Tree

    companion object {
        internal fun tokens(ent: Reader): List<Token> {
            val scan = TINYScanner(ent)
            val out = ArrayList<Token>()
            var tok: Token
            do {
                tok = scan.token()
                out.add(tok)
            } while (tok.tipo != 0)
            return out
        }
    }

}
