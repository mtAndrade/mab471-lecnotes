package lex

import java.io.Reader
import java.io.StringReader
import java.util.regex.Pattern

class ScannerDFA(val nStates: Int) {
    var lin: Int = 1
    var lookAhead: Int = 0
    var input: Reader = StringReader("");

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
                throw RuntimeException("estado: $num, caractere inválido: ${c.toChar()}")
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

    fun allTokens(): List<Token> {
        val tokens = ArrayList<Token>()
        var tok = nextToken()
        while (tok.type != Token.EOF) {
            tokens.add(tok)
            tok = nextToken()
        }
        return tokens
    }

}

class ScannerCalc(val input: Reader) {
    var lin: Int = 1
    var lookAhead: Int = 0

    init {
        nextChar()
    }

    fun nextChar() {
        lookAhead = input.read()
        if(lookAhead.toChar() == '\n') lin++
    }

    fun error(state: Int) {
        throw RuntimeException("estado: $state , caractere inválido: ${lookAhead.toChar()}")
    }

    fun nextToken(): Token {
        var state = 0
        val token = StringBuffer()
        while (true) {
            val c = lookAhead.toChar()
            when (state) {
                0 -> {
                    if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                        state = 0
                    } else if (c in '0'..'9') {
                        token.append(c)
                        state = 1
                    } else if (c == '(') {
                        token.append(c)
                        state = 2
                    } else if (c == ')') {
                        token.append(c)
                        state = 3
                    } else if (c == '+') {
                        token.append(c)
                        state = 4
                    } else if (c == '-') {
                        token.append(c)
                        state = 5
                    } else if (c == '*') {
                        token.append(c)
                        state = 6
                    } else if (c == '/') {
                        token.append(c)
                        state = 7
                    } else if (!c.isDefined()) {
                        token.append("<<EOF>>")
                        state = 8
                    } else {
                        error(state)
                    }
                }
                1 -> {
                    if (c in '0'..'9') {
                        token.append(c)
                        state = 1
                    } else return Token(1, token.toString(), lin)
                }
                2 -> return Token('('.toInt(), token.toString(), lin)
                3 -> return Token(')'.toInt(), token.toString(), lin)
                4 -> return Token('+'.toInt(), token.toString(), lin)
                5 -> return Token('-'.toInt(), token.toString(), lin)
                6 -> return Token('*'.toInt(), token.toString(), lin)
                7 -> return Token('/'.toInt(), token.toString(), lin)
                8 -> return Token(Token.EOF, token.toString(), lin)
            }
            nextChar()
        }
    }

    fun allTokens(): List<Token> {
        val tokens = ArrayList<Token>()
        var tok = nextToken()
        while (tok.type != Token.EOF) {
            tokens.add(tok)
            tok = nextToken()
        }
        return tokens
    }

}
