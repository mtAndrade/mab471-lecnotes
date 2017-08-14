package cmdsimp

data class Token(val tipo: Int, val lexeme: String, val lin: Int) {
    companion object {
        val EOF = 0
        val NUM = 1
        val ID = 2
        val PRINT = 3
    }
}

