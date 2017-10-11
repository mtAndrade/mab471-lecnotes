import java.io.BufferedWriter
import java.io.FileWriter

data class Tree(val t: String) {
    val term = t.replace("\"".toRegex(), "\\\\\"")
    val children = ArrayList<Tree>()

    constructor (t: String, vararg cs: Tree): this(t) {
        for (c in cs)
            children.add(c)
    }

    fun child(term: String) {
        children.add(Tree(term))
    }

    fun child(tree: Tree) {
        children.add(tree)
    }

    fun child(vararg tree: Tree) {
        for (t in tree)
            children.add(t)
    }

    fun print(buf: StringBuffer, level: Int) {
        for (i in 0..level - 1)
            buf.append(" ")
        buf.append(term)
        if (children.isEmpty())
            buf.append("\n")
        else
            buf.append("--v\n")
        for (child in children) {
            child.print(buf, level + term.length + 2)
        }
    }

    fun print(): String {
        val buf = StringBuffer()
        print(buf, 0)
        return buf.toString()
    }

    fun printDot(buf: BufferedWriter, count: Int): Int {
        var count = count
        val me = count
        buf.write(me.toString())
        buf.write(" [label=\"")
        buf.write(term)
        buf.write("\",shape=box];")
        for (child in children) {
            count++
            buf.write(me.toString())
            buf.write("->")
            buf.write(count.toString())
            buf.write(";\n")
            count = child.printDot(buf, count)
        }
        return count
    }

    fun printDot(fileName: String) {
        val buf = BufferedWriter(FileWriter(fileName))
        buf.write("digraph tree {\n")
        printDot(buf, 0)
        buf.write("}")
        buf.close()
    }

}