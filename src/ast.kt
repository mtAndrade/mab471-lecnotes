
interface Exp
interface Cmd

data class Tiny(val corpo: List<Cmd>)

data class If(val cond: Exp, val th: List<Cmd>, val els: List<Cmd>, val lin: Int) : Cmd

data class Repeat(val corpo: List<Cmd>, val cond: Exp,
                  val lin: Int): Cmd

data class Atrib(val rval: String, val lval: Exp,
        val lin: Int): Cmd

data class Read(val lval: String, val lin: Int): Cmd

data class Write(val exp: Exp, val lin: Int): Cmd

data class Menor(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Igual(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Soma(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Sub(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Mult(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Div(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Num(val num: String, val lin: Int): Exp

data class Var(val nome: String, val lin: Int): Exp
