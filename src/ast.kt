
interface Exp
interface Cmd

data class Tiny(val corpo: Bloco) {
    fun escopo(): List<String> {
        val erros = mutableListOf<String>()
        val ctx = emptyMap<String, Bloco>()
        escopo(corpo, ctx, erros)
        return erros
    }
}

data class Bloco(val vars: List<String>,
                 val cmds: MutableList<Cmd>, val lin: Int) {
    fun add(cmd: Cmd) {
        cmds.add(cmd)
    }
}

data class If(val cond: Exp, val th: Bloco, val els: Bloco, val lin: Int) : Cmd

data class Repeat(val corpo: Bloco, val cond: Exp,
                  val lin: Int): Cmd

data class Atrib(val lval: String, val rval: Exp,
        val lin: Int): Cmd {
    var escopo: Bloco? = null
}

data class Read(val lval: String, val lin: Int): Cmd {
    var escopo: Bloco? = null
}

data class Write(val exp: Exp, val lin: Int): Cmd

data class Menor(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Igual(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Soma(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Sub(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Mult(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Div(val e1: Exp, val e2: Exp, val lin: Int): Exp

data class Num(val num: String, val lin: Int): Exp

data class Var(val nome: String, val lin: Int): Exp {
    var escopo: Bloco? = null
}

fun escopo(no: Any, tabsimb: Map<String, Bloco>,
           erros: MutableList<String>): Map<String, Bloco> {
    when(no) {
        is Var -> {
            if(tabsimb.containsKey(no.nome)) {
                no.escopo = tabsimb.get(no.nome)
            } else {
                erros.add("variável ${no.nome} não definida na linha ${no.lin}")
            }
        }
        is Soma -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Sub -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Mult -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Div -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Menor -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Igual -> {
            escopo(no.e1, tabsimb, erros)
            escopo(no.e2, tabsimb, erros)
        }
        is Num -> {}
        is If -> {
            escopo(no.cond, tabsimb, erros)
            escopo(no.th, tabsimb, erros)
            escopo(no.els, tabsimb, erros)
        }
        is Atrib -> {
            if(tabsimb.containsKey(no.lval)) {
                no.escopo = tabsimb.get(no.lval)
            } else {
                erros.add("variável ${no.lval} não definida na linha ${no.lin}")
            }
            escopo(no.rval, tabsimb, erros)
        }
        is Read ->
            if(tabsimb.containsKey(no.lval)) {
                no.escopo = tabsimb.get(no.lval)
            } else {
                erros.add("variável ${no.lval} não definida na linha ${no.lin}")
            }
        is Write -> escopo(no.exp, tabsimb, erros)
        is Repeat -> {
            val tabcorpo = escopo(no.corpo, tabsimb, erros)
            escopo(no.cond, tabcorpo, erros)
        }
        is Bloco -> {
            val vset = mutableSetOf<String>()
            for(v in no.vars) {
                if(vset.contains(v)) {
                    erros.add("variável $v duplicada na linha ${no.lin}")
                } else vset.add(v)
            }
            val tabbloco =
                    tabsimb.plus(vset.map { v -> Pair(v, no) })
            for(cmd in no.cmds) {
                escopo(cmd, tabbloco, erros)
            }
            return tabbloco
        }
    }
    return tabsimb
}

