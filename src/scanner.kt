import java.io.Reader
import java.io.StringReader
import java.util.regex.Pattern

data class Token(val tipo: Int, val lexeme: String, val lin: Int) {
    companion object {
        val EOF = 0
        val NUM = 1
        val ID = 2
        val PRINT = 3
        val SP = 4
    }
}

object RE {
    fun findAll(regex: String, haystack: String): List<String> {
        val m = Pattern.compile(regex).matcher(haystack)
        val l = ArrayList<String>()
        while (m.find()) {
            l.add(m.group())
        }
        return l
    }

    fun findAtStart(regex: String, input: String): Array<String> {
        val m = Pattern.compile("^" + regex).matcher(input)
        if (m.find()) {
            return arrayOf(m.group(), input.substring(m.end()))
        } else {
            return arrayOf("", input)
        }
    }
}

class Scanner(val nStates: Int) {
    var lin: Int = 1
    var lookAhead: Int = 0
    internal var input: Reader = StringReader("");

    val states = mutableListOf<State>(State(0));
    val init = states[0];

    init {
        for (i in 1..(nStates - 1)) {
            states.add(State(i))
        }
    }

    inner class State(var num: Int) {
        var accept: Boolean = false
        var type: Int = 0
        val rules: MutableMap<String, State> = HashMap()

        fun type(type: Int) {
            this.accept = true
            this.type = type
        }

        fun rule(regex: String, to: State) {
            rules[regex] = to
        }

        fun next(c: Int): State? {
            if (c != -1) {
                for ((key, value) in rules) {
                    if (Pattern.matches(key,
                            c.toChar().toString())) {
                        return value
                    }
                }
            } else {
                if (rules.containsKey("<<EOF>>"))
                    return rules["<<EOF>>"]
            }
            if (accept) {
                return null
            } else {
                throw RuntimeException("estado: $num, caractere inválido: '${c}'")
            }

        }

    }

    fun rule(state: Int, regex: String, to: Int) {
        states[state].rule(regex, states[to])
    }

    fun type(state: Int, type: Int) {
        states[state].type(type)
    }

    fun type(state: Int, type: Char) {
        type(state, type.toInt())
    }

    fun setInput(input: String) {
        this.input = StringReader(input)
        lookAhead = this.input.read()
        if(lookAhead.toChar() == '\n') lin++
    }

    fun setInput(input: Reader) {
        this.input = input
        lookAhead = this.input.read()
        if(lookAhead.toChar() == '\n') lin++
    }

    fun nextToken(): Token {
        val lexeme = StringBuffer()
        var current: State? = init
        var type = init.type
        do {
            current = current?.next(lookAhead) // transição
            if (current !== null) {
                type = current.type
                if (current.type != 0) {
                    lexeme.append(lookAhead.toChar())
                }
                lookAhead = input.read()
            }
        } while (current !== null)
        return Token(type, lexeme.toString(), lin)
    }

    fun token() : Token {
        val tok = nextToken()
        if(tok.tipo == Token.SP) return token()
        else return tok
    }

    fun allTokens(): List<Token> {
        val tokens = ArrayList<Token>()
        var tok = nextToken()
        while (tok.tipo != Token.EOF) {
            tokens.add(tok)
            tok = nextToken()
        }
        return tokens
    }

}
