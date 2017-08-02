import java.io.IOException
import java.io.Reader

data class Token(val tipo: Int, val lexeme: String, val lin: Int) {
    companion object {
        val EOF = 0
        val NUM = 1
        val ID = 2
        val PRINT = 3
    }
}

// Le a entrada caractere a caractere
// e retorna o próximo token
class Scanner(val inp: Reader) {
    var la: Int = -1
    var linha: Int = 1

    init {
        proximo()
    }

    fun proximo() {
        try {
            la = inp.read()
            if (la.toChar() == '\n') {
                linha++
            }
        } catch (e: IOException) {
            throw RuntimeException("erro na leitura na linha $linha")
        }

    }

    fun token(): Token {
        while (la.toChar().isWhitespace()) {
            proximo()
        }
        if (la == -1) {
            return Token(Token.EOF, "<<EOF>>", linha)
        }
        if (la.toChar().isDigit()) {
            var num = ""
            while (la.toChar().isDigit()) {
                num += la.toChar()
                proximo()
            }
            return Token(Token.NUM, num, linha)
        } else if (la.toChar().isJavaIdentifierStart()) {
            var id = ""
            while (la.toChar().isJavaIdentifierPart()) {
                id += la.toChar()
                proximo()
            }
            if (id == "print") {
                return Token(Token.PRINT, id, linha)
            }
            else {
                return Token(Token.ID, id, linha)
            }
        } else {
            val tok = Token(la, la.toChar().toString(), linha)
            proximo()
            return tok
        }
    }
}
