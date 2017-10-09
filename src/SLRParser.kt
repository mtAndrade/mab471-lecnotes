import java.io.IOException
import java.util.HashMap
import kotlin.collections.Map.Entry
import java.util.Stack

class SLRParser {
    var g: Grammar
    var aut: LRDFA
    lateinit var scan: TINYScanner
    lateinit var la: Token
    lateinit var stackTree: Stack<Tree>
    lateinit var stackState: Stack<Int>
    var accept: Boolean = false
    var precedence = HashMap<String, Int>()

    lateinit var ACTION: HashMap<String, Array<Action?>>
    lateinit var GOTO: HashMap<String, Array<Int?>>

    interface Action {
        fun run(parser: SLRParser)
    }

    inner class Shift(var state: Int, var term: String) : Action {

        override fun run(parser: SLRParser) {
            parser.shift(state)
        }

        override fun toString(): String {
            return "S" + state
        }
    }

    open inner class Reduce(var rule: Rule) : Action {

        override fun run(parser: SLRParser) {
            parser.reduce(rule)
        }

        override fun toString(): String {
            return "R" + g.rules.indexOf(rule)
        }
    }

    inner class Accept(rule: Rule) : Reduce(rule) {

        override fun run(parser: SLRParser) {
            super.run(parser)
            parser.accept()
        }

        override fun toString(): String {
            return "A"
        }
    }

    inner class Error : Action {
        override fun run(parser: SLRParser) {
            parser.error()
        }

        override fun toString(): String {
            return ""
        }
    }

    constructor(g: Grammar) {
        g.computeSets()
        this.g = g
        aut = LRDFA(g)
        fill()
    }

    constructor(g: Grammar, vararg prec: String) {
        var l = 0
        for (level in prec) {
            val ops = level.split("[ ]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (op in ops)
                precedence.put(op, l)
            l++
        }
        g.computeSets()
        this.g = g
        aut = LRDFA(g)
        fill()
    }

    fun fill() {
        ACTION = HashMap()
        for (term in g.terminals)
            ACTION.put(term, arrayOfNulls<Action>(aut.states.size))
        ACTION.put("<<EOF>>", arrayOfNulls<Action>(aut.states.size))
        GOTO = HashMap()
        for (term in g.variables)
            GOTO.put(term, arrayOfNulls<Int>(aut.states.size))
        for (i in 0..aut.states.size - 1) {
            val s = aut.states[i]
            for ((term, value) in s.trans) {
                if (g.variables.contains(term)) {
                    GOTO[term]?.set(i, aut.states.indexOf(value))
                } else {
                    ACTION[term]?.set(i, Shift(aut.states.indexOf(value), term))
                }
            }
            for (item in s.items) {
                if (item.dot == item.rule.body.size) {
                    for (term in g.FOLLOW[item.rule.head]!!) {
                        val a = ACTION[term]?.get(i)
                        if (a == null) {
                            // Assumindo que FOLLOW(S) = { EOF }
                            if (item.rule.equals(g.rules[0]))
                                ACTION[term]?.set(i, Accept(item.rule))
                            else
                                ACTION[term]?.set(i, Reduce(item.rule))
                        } else { // conflitos
                            if (a is Shift) {
                                val precRight = precedence[a.term]
                                var precLeft: Int? = null
                                for (j in item.rule.body.size - 1 downTo 0) {
                                    if (g.terminals.contains(item.rule.body[j]) && precedence.containsKey(item.rule.body[j])) {
                                        precLeft = precedence[item.rule.body[j]]
                                        break
                                    }
                                }
                                if (precRight != null && precLeft != null) {
                                    if (precRight <= precLeft)
                                        ACTION[term]?.set(i, Reduce(item.rule))
                                } else
                                    println("conflito: " + a + " (" + a.term + "), reduce " + item.rule)
                            } else {
                                println("conflito: " + a + ", reduce " + item.rule)
                            }
                        }
                    }
                }
            }
        }
        for (term in ACTION.keys) {
            for (i in 0..aut.states.size - 1)
                if (ACTION[term]?.get(i) == null)
                    ACTION[term]?.set(i, Error())
        }
    }

    fun setInput(scan: TINYScanner) {
        this.scan = scan
        try {
            this.la = scan.token()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        this.accept = false
        this.stackTree = Stack()
        stackTree.push(Tree("<<EOF>>"))
        this.stackState = Stack()
        stackState.push(0)
        println(configuration())
    }

    fun configuration(): String {
        val config = StringBuffer()
        for (i in stackTree.indices) {
            config.append(stackTree[i].term)
            config.append(",")
            config.append(if (i < stackState.size) stackState[i] else "NULL")
            config.append(" ")
        }
        config.append("|")
        config.append(la().lexeme)
        return config.toString()
    }

    fun shift(state: Int) {
        stackTree.push(Tree(la().lexeme))
        try {
            la = scan.token()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        stackState.push(state)
        println(configuration())
    }

    fun reduce(r: Rule) {
        val node = Tree(r.head)
        for (i in r.body.size - 1 downTo 0) {
            stackState.pop()
            val child = stackTree.pop()
            node.children.add(0, child)
        }
        stackTree.push(node)
        stackState.push(GOTO[node.term]?.get(stackState.peek()))
        println(configuration())
    }

    fun la(): Token {
        return this.la
    }

    fun error() {
        throw RuntimeException("erro de sintaxe: " + la())
    }

    fun accept() {
        accept = true
    }

    fun parse(): Tree {
        while (!accept) {
            ACTION[Token.tokenName(la().tipo)]?.get(stackState.peek())?.run(this)
        }
        return stackTree.pop()
    }

    fun printTable() {
        println()
        println(">>>>> ACTION:")
        for (term in ACTION.keys) {
            print("\t" + term)
        }
        println()
        for (i in 0..aut.states.size - 1) {
            print(i)
            for (term in ACTION.keys) {
                print("\t" + (ACTION[term]?.get(i)))
            }
            println()
        }
        println()
        println(">>>>> GOTO:")
        for (term in GOTO.keys) {
            print("\t" + term)
        }
        println()
        for (i in 0..aut.states.size - 1) {
            print(i)
            for (term in GOTO.keys) {
                print("\t" + if (GOTO[term]?.get(i) == null) "" else GOTO[term]?.get(i))
            }
            println()
        }
        println()
    }
}
