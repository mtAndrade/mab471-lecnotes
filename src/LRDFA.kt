import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.util.ArrayList
import java.util.HashMap
import kotlin.collections.Map.Entry
import java.util.Stack

class LRDFA {
    lateinit var init: State
    var states = ArrayList<State>()

    inner class Item(var rule: Rule, var dot: Int) {

        override fun toString(): String {
            val buf = StringBuffer()
            buf.append(rule.head + "->")
            if (dot == 0) buf.append(" .")
            for (i in 0..rule.body.size - 1) {
                buf.append(" ")
                buf.append(rule.body[i])
                if (dot == i + 1)
                    buf.append(" .")
            }
            return buf.toString()
        }

        override fun hashCode(): Int {
            return Integer.rotateLeft(rule.hashCode(), dot)
        }

        override fun equals(o: Any?): Boolean {
            if (o is Item) {
                val i = o as Item?
                return i!!.dot == dot && i.rule.equals(rule)
            }
            return false
        }
    }

    inner class State {
        var items = ArrayList<Item>()
        var trans = HashMap<String, State>()
        var id = nextState++

        constructor(g: Grammar, rule: Int, dot: Int) {
            item(g, rule, dot)
        }

        constructor(rule: Rule, dot: Int) {
            item(rule, dot)
        }

        constructor(item: Item) {
            item(item)
        }

        fun item(g: Grammar, rule: Int, dot: Int) {
            item(Item(g.rules[rule], dot))
        }

        fun item(rule: Rule, dot: Int) {
            item(Item(rule, dot))
        }

        fun item(item: Item) {
            items.add(item)
        }

        fun trans(term: String, s: State) {
            trans.put(term, s)
        }

        fun label(): String {
            val buf = StringBuffer()
            buf.append(id)
            buf.append(" [label=\"" + states.indexOf(this) +
                    "\\n")
            for (item in items) {
                buf.append(item.toString())
                buf.append("\\n")
            }
            buf.append("\",shape=box];\n")
            return buf.toString()
        }

        fun transitions(): String {
            val buf = StringBuffer()
            for ((key, value) in trans) {
                buf.append(" ")
                buf.append(id)
                buf.append(" -> ")
                buf.append(value.id)
                buf.append(" [label=\"")
                buf.append(key)
                buf.append("\"]\n")
            }
            return buf.toString()
        }

        fun eclosure(g: Grammar) {
            val worklist = Stack<Item>()
            worklist.addAll(items)
            while (!worklist.empty()) {
                val i = worklist.pop()
                if (i.dot < i.rule.body.size) {
                    val term = i.rule.body[i.dot]
                    if (g.variables.contains(term)) {
                        for (r in g.rules) {
                            if (r.head.equals(term)) {
                                val next = Item(r, 0)
                                if (!items.contains(next)) {
                                    items.add(next)
                                    worklist.push(next)
                                }
                            }
                        }
                    }
                }
            }
        }

        override fun hashCode(): Int {
            return items.hashCode()
        }

        override fun equals(o: Any?): Boolean {
            if (o is State) {
                val s = o as State?
                return s!!.items == items
            }
            return false
        }

        override fun toString(): String {
            return items.toString()
        }
    }

    fun fromItem(r: Grammar, dot: Int): State? {
        for (s in states) {
            for (i in s.items) {
                if (i.rule.equals(r) && i.dot == dot)
                    return s
            }
        }
        return null
    }

    fun fill(g: Grammar) {
        init = State(g, 0, 0)
        for (i in 1..g.rules.size - 1) {
            val r = g.rules[i]
            if (r.head.equals(g.rules[0].head)) {
                init.item(r, 0)
            }
        }
        init.eclosure(g)
        states.add(init)
        val worklist = Stack<State>()
        worklist.push(init)
        while (!worklist.empty()) {
            val cur = worklist.pop()
            val trans = HashMap<String, State>()
            for (i in cur.items) {
                if (i.dot < i.rule.body.size) {
                    val term = i.rule.body[i.dot]
                    if (trans.containsKey(term)) {
                        trans[term]?.item(i.rule, i.dot + 1)
                    } else {
                        trans.put(term, State(i.rule, i.dot + 1))
                    }
                }
            }
            for (pair in trans.entries) {
                var next = pair.value
                next.eclosure(g)
                if (!states.contains(next)) {
                    states.add(next)
                    worklist.push(next)
                } else {
                    next = states[states.indexOf(next)]
                }
                cur.trans(pair.key, next)
            }
        }
    }

    constructor() {}

    constructor(g: Grammar) {
        fill(g)
    }

    @Throws(IOException::class)
    fun printDot(fileName: String) {
        val buf = BufferedWriter(FileWriter(fileName))
        buf.write("digraph DFA {\n")
        for (s in states) {
            buf.write(s.label())
        }
        for (s in states) {
            buf.write(s.transitions())
        }
        buf.write("}\n")
        buf.close()
    }

    companion object {

        private var nextState = 0
    }

}
