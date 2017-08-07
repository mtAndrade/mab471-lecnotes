package lex

import java.util.regex.Pattern

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

data class Token(val type: Int, val lexeme: String, val lin: Int) {
    companion object {
        val EOF = 0
    }
}

data class Rule(val regex: String, val type: Int)

class ScannerRE(val regexSpace: String, val rules: List<Rule>, var input: String) {
    var lin = 1

    fun nextToken(): Token {
        do {
            val result = RE.findAtStart(regexSpace, input)
            if (result[0].isEmpty()) break
            else lin += result[0].count({ c -> c == '\n' })
            input = result[1]
        } while (true)
        if (input == "")
            return Token(Token.EOF, "", lin)
        var maxMatch = ""
        var nextInput = input
        var type = -1
        for ((regex, ty) in rules) {
            val result = RE.findAtStart(regex, input)
            val match = result[0]
            if (match.length > maxMatch.length) {
                maxMatch = match
                type = ty
                nextInput = result[1]
            }
        }
        if (maxMatch.isNotEmpty()) {
            input = nextInput
            return Token(type, maxMatch, lin)
        } else {
            throw RuntimeException("lexical error at line $lin, : ${input[0]}")
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
