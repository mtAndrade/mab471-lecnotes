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

