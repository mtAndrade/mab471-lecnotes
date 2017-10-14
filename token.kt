
data class Token(val tipo: Int, val texto: String, val lin: Int, val col: Int)
        : Tokens {
    companion object {
        const val EOF = 0
    }
}

