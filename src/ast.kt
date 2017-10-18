
interface Exp
interface Cmd

fun <T> duplicadas(l: List<T>): Set<T> {
    val s = mutableSetOf<T>()
    val dups = mutableSetOf<T>()
    for(item in l) {
        if(s.contains(item)) dups.add(item);
        else s.add(item);
    }
    return dups;
}

data class Tiny(val procs: List<Proc>, val corpo: Bloco) {
    fun escopo(): List<String> {
        val erros = mutableListOf<String>()
        // Primeira passada
        val dvars = duplicadas(corpo.vars)
        for(v in dvars) {
            erros.add("variável global $v declarada mais de uma vez")
        }
        val vars =
                (corpo.vars.map { v -> Pair(v, corpo) }).toMap()
        val dprocs = duplicadas(procs.map { p -> p.nome })
        for(proc in dprocs) {
            erros.add("procedimento $proc declarado mais de uma vez")
        }
        val procs =
                (procs.map { p -> Pair(p.nome, p) }).toMap()
        // Segunda passada
        for(proc in this.procs)
            escopo(proc.corpo, procs, vars, erros)
        for(cmd in corpo.cmds)
            escopo(cmd, procs, vars, erros)
        return erros
    }
}

data class Bloco(val vars: List<String>,
                 val cmds: MutableList<Cmd>, val lin: Int) {
    fun add(cmd: Cmd) {
        cmds.add(cmd)
    }
}

data class Proc(val nome: String, val corpo: Bloco, val lin: Int)

data class Chamada(val nome: String, val lin: Int): Cmd {
    var proc: Proc? = null
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

fun escopo(no: Any, procs: Map<String, Proc>,
           vars: Map<String, Bloco>, erros: MutableList<String>): Map<String, Bloco> {
    when(no) {
        is Var -> {
            if(vars.containsKey(no.nome)) {
                no.escopo = vars.get(no.nome)
            } else {
                erros.add("variável ${no.nome} não definida na linha ${no.lin}")
            }
        }
        is Soma -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Sub -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Mult -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Div -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Menor -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Igual -> {
            escopo(no.e1, procs, vars, erros)
            escopo(no.e2, procs, vars, erros)
        }
        is Num -> {}
        is If -> {
            escopo(no.cond, procs, vars, erros)
            escopo(no.th, procs, vars, erros)
            escopo(no.els, procs, vars, erros)
        }
        is Atrib -> {
            if(vars.containsKey(no.lval)) {
                no.escopo = vars.get(no.lval)
            } else {
                erros.add("variável ${no.lval} não definida na linha ${no.lin}")
            }
            escopo(no.rval, procs, vars, erros)
        }
        is Read -> {
            if (vars.containsKey(no.lval)) {
                no.escopo = vars.get(no.lval)
            } else {
                erros.add("variável ${no.lval} não definida na linha ${no.lin}")
            }
        }
        is Chamada -> {
            if (procs.containsKey(no.nome)) {
                no.proc = procs.get(no.nome)
            } else {
                erros.add("chamada a procedimento ${no.nome} não definido na linha ${no.lin}")
            }
        }
        is Write -> escopo(no.exp, procs, vars, erros)
        is Repeat -> {
            val tabcorpo = escopo(no.corpo, procs, vars, erros)
            escopo(no.cond, procs, tabcorpo, erros)
        }
        is Bloco -> {
            val vset = mutableSetOf<String>()
            for(v in no.vars) {
                if(vset.contains(v)) {
                    erros.add("variável $v duplicada na linha ${no.lin}")
                } else vset.add(v)
            }
            val tabbloco =
                    vars.plus(vset.map { v -> Pair(v, no) })
            for(cmd in no.cmds) {
                escopo(cmd, procs, tabbloco, erros)
            }
            return tabbloco
        }
    }
    return vars
}

