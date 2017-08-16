package cmdsimp

data class Token(val tipo: Int, val lexeme: String, val lin: Int) {
    companion object {
        const val EOF = 0
        const val NUM = 1
        const val ID = 2
        const val PRINT = 3
    }
}

