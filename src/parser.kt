import java.io.Reader
import java.util.HashSet

class Falha : RuntimeException()
class FalhaFalha : RuntimeException()

abstract class Parser(val ent: List<Char>) {
    var pos = 0
    var pfalha = -1
    val tesp: MutableSet<String> = HashSet()

    fun match(c: Char) {
        if(pos == ent.size)
            throw Falha()
        else if(ent[pos] != c) {
            throw Falha()
        } else {
            pos++
        }
    }

    fun match(p: (Char) -> Boolean) {
        if(pos == ent.size)
            throw Falha()
        else if(!p(ent[pos])) {
            throw Falha()
        } else {
            pos++
        }
    }

    fun op(lit: String): Tree {
        SP()
        val atual = pos
        try {
            lit.forEach { c -> match(c) }
            return Tree(lit)
        } catch(_: Falha) {
            pos = atual
            if (pos == pfalha) {
                tesp.add(lit)
            } else if (pos > pfalha) {
                pfalha = pos
                tesp.clear()
                tesp.add(lit)
            }
            throw Falha()
        }
    }

    fun kw(nome: String): Tree {
        SP()
        val atual = pos
        try {
            nome.forEach { c -> match(c) }
            val atual = pos
            try {
                match { c ->
                    c.isJavaIdentifierPart() }
                throw FalhaFalha()
            } catch(_: Falha) {
                pos = atual
            } catch(_: FalhaFalha) {
                throw Falha()
            }
            return Tree(nome)
        } catch(_: Falha) {
            pos = atual
            if (pos == pfalha) {
                tesp.add(nome)
            } else if (pos > pfalha) {
                pfalha = pos
                tesp.clear()
                tesp.add(nome)
            }
            throw Falha()
        }
    }

    fun token(pos: Int): String {
        val rest = ent.subList(pos, ent.size).joinToString("")
        return rest.substring(0, rest.indexOfFirst {
            c -> c.isWhitespace()
        })
    }

    abstract fun SP()
    abstract fun parse(): Tree
}
