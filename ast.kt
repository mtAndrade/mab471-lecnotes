
interface Exp
interface Cmd

data class Prog(val main: String, val args: String, val cmd: Cmd,
                val classes: List<Classe>) {
    override fun toString(): String {
        var res = "class " + main + " {\n  public static void main(String[] " + args +
                ") {\n" + cmd + "\n  }\n}\n"
        for (classe in classes)
            res += classe.toString() + "\n"
        return res
    }
}

data class Soma(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 + $e2)"
    }
}

data class Sub(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 - $e2)"
    }
}

data class Div(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 / $e2)"
    }
}

data class Mult(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 * $e2)"
    }
}

data class Menor(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 < $e2)"
    }
}

data class Igual(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 == $e2)"
    }
}

data class Dif(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 != $e2)"
    }
}

data class ELog(val e1: Exp, val e2: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "($e1 && $e2)"
    }
}

data class Neg(val e: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "(-$e)"
    }
}

data class Nao(val e: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "(!$e)"
    }
}

data class Id(val nome: String, val lin: Int) : Exp {
    override fun toString(): String {
        return nome
    }
}

data class Indexa(val vet: Exp, val ind: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return vet.toString() + "[" + ind + "]"
    }

}

data class If(val cond: Exp, val cthen: Cmd, val celse: Cmd?, val lin: Int) : Cmd {
    override fun toString(): String {
        return "if(" + cond + ") " + cthen +
                if (celse == null) "" else " else " + celse
    }
}

data class Length(val exp: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return exp.toString() + ".length"
    }
}

data class Classe(val nome: String, val pai: String = "Object", val campos: List<Var>,
                  val metodos: List<Metodo>, val lin: Int = 0) {
    override fun toString(): String {
        var res = "class $nome extends $pai{\n"
        for (campo in campos) {
            res += campo.toString() + ";\n"
        }
        for (metodo in metodos) {
            res += metodo.toString() + "\n"
        }
        res += "}"
        return res
    }
}

data class Var(val tipo: String, val nome: String, val lin: Int) {
    override fun toString(): String {
        return tipo + " " + nome
    }
}

data class Vetor(val tam: Exp, val lin: Int) : Exp {
    override fun toString(): String {
        return "new int[$tam]"
    }
}

data class While(val cond: Exp, val corpo: Cmd, val lin: Int) : Cmd {
    override fun toString(): String {
        return "while($cond) $corpo"
    }
}

data class Atrib(val nome: String, val exp: Exp, val lin: Int) : Cmd {
    override fun toString(): String {
        return "$nome = $exp;"
    }
}

data class AtribVetor(val nome: String, val ind: Exp, val rval: Exp, val lin: Int) : Cmd {
    override fun toString(): String {
        return "$nome[$ind] = $rval;"
    }
}

data class Bloco(val cmds: List<Cmd>) : Cmd {
    override fun toString(): String {
        var res = "{\n "
        for (cmd in cmds) {
            res += cmd.toString() + "\n"
        }
        res += "}"
        return res
    }
}

data class Campo(val obj: Exp, val nome: String, val lin: Int) : Exp {
    override fun toString(): String {
        return obj.toString() + "." + nome
    }
}

data class Chamada(val obj: Exp, val nome: String, val args: List<Exp>,
                   val lin: Int) : Exp {
    override fun toString(): String {
        var res = obj.toString() + "." + nome + "("
        if (!args.isEmpty())
            res += args[0]
        for (i in 1 until args.size)
            res += ", " + args[i]
        res += ")"
        return res
    }
}

data class Metodo(val tret: String, val nome: String, val params: List<Var>,
                  val vars: List<Var>, val cmds: List<Cmd>, val ret: Exp, val lin: Int) {
    override fun toString(): String {
        var res = "public $tret $nome("
        if (!params.isEmpty())
            res += params[0]
        for (i in 1 until params.size)
            res += ", " + params[i]
        res += ") {\n"
        for (`var` in vars)
            res += `var`.toString() + ";\n"
        for (cmd in cmds)
            res += cmd.toString() + "\n"
        res += "return $ret;\n}"
        return res
    }
}

data class Println(val exp: Exp, val lin: Int) : Cmd {
    override fun toString(): String {
        return "System.out.println($exp);"
    }
}

data class New(val classe: String, val lin: Int) : Exp {
    override fun toString(): String {
        return "new $classe()"
    }
}

class Num(val value: String) : Exp {
    override fun toString(): String {
        return value
    }
}

object False : Exp {
    override fun toString(): String {
        return "false"
    }
}

object Null : Exp {
    override fun toString(): String {
        return "null"
    }
}

object This : Exp {
    override fun toString(): String {
        return "this"
    }
}

object True : Exp {
    override fun toString(): String {
        return "true"
    }
}


