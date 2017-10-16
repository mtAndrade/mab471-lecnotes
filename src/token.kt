
data class Token(val tipo: Int, val lexeme: String, val lin: Int)
        : TINYTokens {
    companion object {
        const val EOF = 0

        internal var names = arrayOf("eof", ":=", "else",
                "end", "id", "if", "num", "read", "repeat",
                "then", "until", "write")

        fun tokenName(tipo: Int): String {
            return if (tipo < names.size) names[tipo] else "" + tipo.toChar()
        }
    }
}

