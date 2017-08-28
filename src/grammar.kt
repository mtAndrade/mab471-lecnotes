
interface PE {}

class Falha(): RuntimeException("falha no parse")

data class T(val tipo: String): PE
data class NT(val nome: String): PE
data class E(val p1: PE, val p2: PE): PE
data class Ou(val p1: PE, val p2: PE): PE

data class G(val p: Map<String, PE>,
             val S: String)

fun match(g: G, p: PE, inp: List<String>):
        List<String> {
    when(p) {
        is T -> {
            if(inp.isEmpty())
                throw Falha()
            else if(inp.first() != p.tipo)
                throw Falha()
            else
                return inp.drop(1)
        }
        is NT -> {
            return match(g, g.p[p.nome]!!, inp)
        }
        is E -> {
            val resto = match(g, p.p1, inp)
            return match(g, p.p2, resto)
        }
        is Ou -> {
            try {
                return match(g, p.p1, inp)
            } catch(f: Falha) {
                return match(g, p.p2, inp)
            }
        }
    }
    throw Falha()
}

abstract class Parser(val inp: List<String>) {
  var pos = 0

  fun match(tipo: String): Tree {
      if(pos == inp.size)
          throw Falha()
      else if(tipo != inp[pos])
          throw Falha()
      else {
          pos++
          return Tree(tipo)
      }
  }

  abstract fun parse(): Tree
}

class ExpParser: Parser {
    constructor (i: List<String>): super(i)

    // E -> T + E | T
    fun E(): Tree {
        val arvore = Tree("E")
        val atual = pos
        try {
            val rascunho = Tree("")
            rascunho.child(T())
            rascunho.child(match("+"))
            rascunho.child(E())
            arvore.children.addAll(rascunho.children)
        } catch(f: Falha) {
            pos = atual
            arvore.child(T())
        }
        return arvore
    }

    // T -> id | num
    fun T(): Tree {
        val arvore = Tree("T")
        val atual = pos
        try {
            val rascunho = Tree("")
            rascunho.child(match("id"))
            arvore.children.addAll(rascunho.children)
        } catch(f: Falha) {
            pos = atual
            arvore.child(match("num"))
        }
        return arvore
    }

    override fun parse(): Tree {
        return E()
    }
}

class ExpParserNR: Parser {
    constructor (i: List<String>): super(i)

    // E -> T {+ T}
    fun E(): Tree {
        val arvore = Tree("E")
        arvore.child(T())
        while(true) {
            val atual = pos
            try {
                val rascunho = Tree("")
                rascunho.child(match("+"))
                rascunho.child(T())
                arvore.children.addAll(rascunho.children)
            } catch(f: Falha) {
                pos = atual
                break
            }
        }
        return arvore
    }

    // T -> id | num
    fun T(): Tree {
        val arvore = Tree("T")
        val atual = pos
        try {
            val rascunho = Tree("")
            rascunho.child(match("id"))
            arvore.children.addAll(rascunho.children)
        } catch(f: Falha) {
            pos = atual
            arvore.child(match("num"))
        }
        return arvore
    }

    override fun parse(): Tree {
        return E()
    }
}