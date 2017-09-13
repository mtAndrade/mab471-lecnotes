package parse

import java.util.ArrayList
import java.util.Stack

class ShiftReduce(var g: Grammar) {
    var pos: Int = 0
    var input: Array<out String> = arrayOf<String>()
    var stack = Stack<Tree>()

    var reductions = mutableListOf<Int>()

    fun input(vararg input: String) {
        this.input = input
        this.pos = 0
        this.stack = Stack()
        this.reductions = ArrayList()
        println(configuration())
    }

    fun input(input: String) {
        input(*input.split("[ ]+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
    }

    fun configuration(): String {
        val config = StringBuffer()
        for (item in stack) {
            config.append(item.term)
            config.append(" ")
        }
        config.append("|")
        for (i in pos..input.size - 1) {
            config.append(" ")
            config.append(input[i])
        }
        return config.toString()
    }

    fun shift(): ShiftReduce {
        stack.push(Tree(input[pos++])) // shift
        println(configuration())
        return this
    }

    fun shift(n: Int): ShiftReduce {
        for (i in 0..n - 1)
            shift()
        return this
    }

    fun reduce(rule: Int): ShiftReduce {
        val r = g.rules[rule]
        val node = Tree(r.head) // nó lado esquerdo
        for (i in r.body.size - 1 downTo 0) {
            val child = stack.pop() // desempilha lado direito
            if (child.term != r.body[i])
                throw RuntimeException("redução inválida")
            node.children.add(0, child) // constrói árvore
        }
        stack.push(node) // empilha lado esquerdo
        reductions.add(0, rule)
        println(configuration())
        return this
    }

    fun accept(): Tree {
        return if (pos == input.size && stack.size == 1 && stack[0].term == g.rules[0].head) {
            stack.pop()
        } else
            throw RuntimeException("erro de sintaxe")
    }

    fun derivation(): String {
        val rls = IntArray(reductions.size)
        for (i in rls.indices)
            rls[i] = reductions[i]
        return g.rightDerivation(g.rules[0].head, *rls)
    }
}
