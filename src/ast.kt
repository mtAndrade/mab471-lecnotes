
interface Exp {
    fun escopo(ctx: Map<String, Bloco>,
               erros: MutableList<String>) {
        when(this) {
            is Var -> if(ctx.containsKey(nome)) {
                escopo = ctx.get(nome)
            } else {
                erros.add("variável $nome não definida na linha $lin")
            }
            is Soma -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Sub -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Mult -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Div -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Menor -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Igual -> {
                e1.escopo(ctx, erros)
                e2.escopo(ctx, erros)
            }
            is Num -> {}
        }
    }
}

interface Cmd {
    fun escopo(ctx: Map<String, Bloco>,
               erros: MutableList<String>) {
        when(this) {
            is If -> {
                cond.escopo(ctx, erros)
                th.escopo(ctx, erros)
                els.escopo(ctx, erros)
            }
            is Atrib -> {
                if(ctx.containsKey(lval)) {
                    escopo = ctx.get(lval)
                } else {
                    erros.add("variável $lval não definida na linha $lin")
                }
                rval.escopo(ctx, erros)
            }
            is Read ->
                if(ctx.containsKey(lval)) {
                        escopo = ctx.get(lval)
                } else {
                    erros.add("variável $lval não definida na linha $lin")
                }
            is Write -> exp.escopo(ctx, erros)
            is Repeat -> {
                val ctxcorpo = corpo.escopo(ctx, erros)
                cond.escopo(ctxcorpo, erros)
            }
        }
    }
}

data class Tiny(val corpo: Bloco) {
    fun escopo(): List<String> {
        val erros = mutableListOf<String>()
        val ctx = emptyMap<String, Bloco>()
        corpo.escopo(ctx, erros)
        return erros
    }
}

data class Bloco(val vars: List<String>,
                 val cmds: MutableList<Cmd>, val lin: Int) {
    fun add(cmd: Cmd) {
        cmds.add(cmd)
    }

    fun escopo(ctx: Map<String, Bloco>,
               erros: MutableList<String>): Map<String, Bloco> {
        val vset = mutableSetOf<String>()
        for(v in vars) {
            if(vset.contains(v)) {
                erros.add("variável $v duplicada na linha $lin")
            } else vset.add(v)
        }
        val ctxbloco =
                ctx.plus(vset.map { v -> Pair(v, this) })
        for(cmd in cmds) {
            cmd.escopo(ctxbloco, erros)
        }
        return ctxbloco
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
