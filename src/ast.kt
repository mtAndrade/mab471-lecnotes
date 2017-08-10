import java.math.BigInteger
import java.io.FileWriter
import java.util.HashMap

data class Print(val exp: Exp, val lin: Int) : Cmd
data class Atrib(val id: String, val exp: Exp, val lin: Int) : Cmd

interface Cmd {
    fun codigo(vars: MutableList<String>, out: StringBuffer) {
        when (this) {
            is Print -> {
                out.appendln("getstatic java/lang/System/out Ljava/io/PrintStream;")
                exp.codigo(vars, out)
                out.appendln("invokevirtual java/io/PrintStream/println(I)V")
            }
            is Atrib -> {
                exp.codigo(vars, out)
                if (!vars.contains(id)) {
                    vars.add(id)
                }
                out.appendln("istore ${vars.indexOf(id)}")
            }
        }
    }
    fun run(vars: MutableMap<String, BigInteger>) {
        when (this) {
            is Print -> println(exp.eval(vars))
            is Atrib -> vars.put(id, exp.eval(vars))
        }
    }
}

data class Num(val v: String, var lin: Int) : Exp
data class Id(val id: String, val lin: Int) : Exp
data class Soma(val exp1: Exp, val exp2: Exp, val lin: Int) : Exp
data class Sub(val exp1: Exp, val exp2: Exp, val lin: Int) : Exp

interface Exp {
    fun codigo(vars: List<String>, out: StringBuffer) {
        when (this) {
            is Num -> out.appendln("ldc $v")
            is Id -> {
                if (!vars.contains(id)) {
                    throw RuntimeException("variável não declarada na linha $lin: $id")
                }
                out.appendln("iload ${vars.indexOf(id)}")
            }
            is Soma -> {
                exp1.codigo(vars, out)
                exp2.codigo(vars, out)
                out.appendln("iadd")
            }
            is Sub -> {
                exp1.codigo(vars, out)
                exp2.codigo(vars, out)
                out.appendln("isub")
            }
        }
    }
    fun eval(vars: Map<String, BigInteger>): BigInteger =
        when (this) {
            is Num -> BigInteger(v)
            is Soma -> exp1.eval(vars) + exp2.eval(vars)
            is Sub -> exp1.eval(vars) - exp2.eval(vars)
            is Id -> vars.getOrElse(id, { throw RuntimeException("variável não declarada na linha $lin: $id") })
            else -> throw RuntimeException("não conheço esse nó: $this")
        }
}

data class Prog(val cmds: List<Cmd>) {
    fun run() {
        val vars = HashMap<String, BigInteger>()
        for (cmd in cmds) {
            cmd.run(vars)
        }
    }

    fun codigo(pname: String) {
        val out = StringBuffer()
        out.append("""
          |.class public $pname
          |.super java/lang/Object
          |.method public static main([Ljava/lang/String;)V
          |.limit stack 100
          |.limit locals 100
          |
        """.trimMargin())
        val vars = ArrayList<String>()
        for (cmd in cmds) {
            cmd.codigo(vars, out)
        }
        out.append("""
          |return
          |.end method
        """.trimMargin())
        val fout = FileWriter(pname + ".jasmin")
        fout.write(out.toString())
        fout.close()
    }
}
