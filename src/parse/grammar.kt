package parse

import java.util.Stack

data class Rule(val head: String, val b: String) {
    val body = b.split(Regex("[ ]+")).filter { s -> !s.isBlank() }
    val firstPlus = mutableSetOf<String>()

    fun canDerive(term: String): Boolean {
        return head == term
    }

    fun print(): String {
        val buf = StringBuffer()
        buf.append(head)
        buf.append(" -> ")
        buf.append(b)
        if (!firstPlus.isEmpty()) {
            buf.append("  ")
            buf.append(firstPlus.toString())
        }
        return buf.toString()
    }
}

class Grammar {
    val rules = mutableListOf<Rule>()
    val variables = mutableSetOf<String>()
    val terminals = mutableSetOf<String>()
    val lexicon = mutableSetOf<String>()

    val FIRST = mutableMapOf<String, MutableSet<String>>()
    val FOLLOW = mutableMapOf<String, MutableSet<String>>()
    val nullable = mutableSetOf<String>()
    var ll1: Boolean = false
    val ll1table = mutableMapOf<String, MutableMap<String,Rule>>()

    fun rules(head: String, body: String) {
        lexicon.add(head)
        variables.add(head)
        terminals.remove(head)
        val r = Rule(head, body)
        for (term in r.body) {
            lexicon.add(term)
            if (!variables.contains(term))
                terminals.add(term)
        }
        rules.add(r)
    }

    override fun toString(): String {
        val buf = StringBuffer()
        for (i in rules.indices) {
            buf.append(i.toString() + ": ")
            buf.append(rules[i].print())
            buf.append("\n")
        }
        return buf.toString()
    }

    fun leftDerive1(form: String, rl: Int): String {
        val parts = form.split(Regex("[ ]+"))
        when {
            parts.all { it.isBlank() } -> return ""
            rules[rl].canDerive(parts.first()) ->
                return (rules[rl].body + parts.drop(1)).joinToString(" ")
            else -> return parts.first() + " " +
                    leftDerive1(parts.drop(1).joinToString(" "), rl)
        }
    }

    fun rightDerive1(form: String, rl: Int): String {
        val parts = form.split(Regex("[ ]+"))
        when {
            parts.all { it.isBlank() } -> return ""
            rules[rl].canDerive(parts.last()) ->
                return (parts.dropLast(1)).joinToString(" ") + rules[rl].body
            else -> return rightDerive1(parts.drop(1).joinToString(" "), rl) +
                    " " + parts.last()
        }
    }

    fun leftDerive(form: String, vararg rls: Int): String {
        var form = form
        for (rl in rls) {
            form = leftDerive1(form, rl)
        }
        return form
    }

    fun rightDerive(form: String, vararg rls: Int): String {
        var form = form
        for (rl in rls) {
            form = rightDerive1(form, rl)
        }
        return form
    }

    fun derive(form: String, vararg rls: Int): String {
        return leftDerive(form, *rls)
    }

    fun leftDerivation(start: String, vararg rls: Int): String {
        val buf = StringBuffer()
        buf.append(start)
        var form = start
        for (rl in rls) {
            buf.append(" -$rl-> ")
            form = leftDerive1(form, rl)
            buf.append(form)
            buf.append("\n")
        }
        return buf.toString()
    }

    fun derivation(start: String, vararg rls: Int): String {
        return leftDerivation(start, *rls)
    }

    fun rightDerivation(start: String, vararg rls: Int): String {
        val buf = StringBuffer()
        buf.append(start)
        var form = start
        for (rl in rls) {
            buf.append(" -$rl-> ")
            form = rightDerive1(form, rl)
            buf.append(form)
            buf.append("\n")
        }
        return buf.toString()
    }

    fun treeDerive1(t: Tree, rl: Int): Boolean {
        val r = rules[rl]
        if (t.children.isEmpty()) {
            if (r.canDerive(t.term)) {
                for (bterm in r.body) {
                    t.child(bterm)
                }
                return true
            } else
                return false
        } else {
            var found = false
            for (child in t.children) {
                if (treeDerive1(child, rl)) {
                    found = true
                    break
                }
            }
            return found
        }
    }

    fun treeDerive(start: String, vararg rls: Int): Tree {
        val t = Tree(start)
        for (rl in rls) {
            treeDerive1(t, rl)
        }
        return t
    }

    fun isNullable(terms: List<String>): Boolean {
        return terms.isEmpty() || (nullable.contains(terms.first()) &&
                isNullable(terms.drop(1)))
    }

    fun isNullable(terms: List<String>, i: Int, j: Int): Boolean {
        return i > j || (nullable.contains(terms[i]) &&
                isNullable(terms, i+1, j))
    }

    fun computeSets() {
        for (term in lexicon) {
            FIRST[term] = mutableSetOf<String>()
        }
        for (term in variables) {
            FOLLOW[term] = mutableSetOf<String>()
        }
        for (term in terminals) {
            FIRST[term] = mutableSetOf(term)
        }
        FOLLOW[rules[0].head] = mutableSetOf("<<EOF>>")
        var changed: Boolean = false
        do {
            changed = false
            for (r in rules) {
                if (isNullable(r.body)) changed = nullable.add(r.head) || changed
                for (i in r.body.indices) {
                    if (isNullable(r.body, 0, i - 1)) {
                        changed =
                                FIRST[r.head]!!.addAll(FIRST[r.body[i]]!!) ||
                                        changed
                    }
                    if (variables.contains(r.body[i]) &&
                            isNullable(r.body, i + 1, r.body.size - 1)) {
                        changed =
                                FOLLOW[r.body[i]]!!.addAll(FOLLOW[r.head]!!) ||
                                changed
                    }
                    if (variables.contains(r.body[i])) {
                        for (j in i + 1..r.body.size - 1) {
                            if (i + 1 == j || isNullable(r.body, i + 1, j - 1)) {
                                changed =
                                        FOLLOW[r.body[i]]!!.addAll(
                                                FIRST[r.body[j]]!!) ||
                                                changed
                            }
                        }
                    }
                }
            }
        } while (changed)
        ll1 = true
        for (v in variables) {
            val terms = mutableSetOf<String>()
            for (r in rules) {
                if (r.head == v) {
                    r.firstPlus.addAll(firstPlus(r.head, r.body))
                    for (t in r.firstPlus) {
                        if (!terms.add(t))
                            ll1 = false
                    }
                }
            }
        }
        if(ll1) {
            for(v in variables) {
                val linha = mutableMapOf<String, Rule>()
                ll1table[v] = linha
                for(t in terminals) {
                    for(r in rules) {
                        if(r.head == v && r.firstPlus.contains(t))
                            linha[t] = r
                    }
                }
                for(r in rules) {
                    if(r.head == v &&
                            r.firstPlus.contains("<<EOF>>"))
                        linha["<<EOF>>"] = r
                }
            }
        }
    }

    fun firstPlus(head: String, terms: List<String>): Set<String> {
        val res = mutableSetOf<String>()
        for (term in terms) {
            res.addAll(FIRST[term]!!)
            if (!(nullable.contains(term)))
                break
        }
        if (isNullable(terms))
            res.addAll(FOLLOW[head]!!)
        return res
    }

    fun first(last: Set<String>, terms: List<String>): Set<String> {
        val res = mutableSetOf<String>()
        for (term in terms) {
            res.addAll(FIRST[term]!!)
            if (!nullable.contains(term))
                break
        }
        if (isNullable(terms))
            res.addAll(last)
        return res
    }

    fun parse(input: String): Tree {
        return this.parse(input.split("[ ]+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
    }

    fun parse(input: Array<String>): Tree {
        val tree = Tree(rules[0].head)
        val nextFocus = Stack<Tree>()
        nextFocus.add(Tree("<<EOF>>"))
        nextFocus.add(tree)
        var pos = 0 // lookahead
        while (!nextFocus.isEmpty() || pos < input.size) {
            val focus = nextFocus.pop()
            if (variables.contains(focus.term)) { // foco é NT
                val linha = ll1table[focus.term]!!
                val lookAhead =
                        if (pos < input.size) input[pos]
                        else "<<EOF>>"
                val r = linha.getOrElse(lookAhead, {
                    throw RuntimeException("erro de sintaxe em " + pos)
                })
                for (term in r.body) {
                  focus.child(term)
                }
                nextFocus.addAll(focus.children.reversed())
            } else { // foco é terminal
                val lookAhead = if (pos < input.size) input[pos] else "<<EOF>>"
                if (focus.term == lookAhead) {
                    pos++
                } else {
                    throw RuntimeException("erro de sintaxe em " + pos +
                            ", input: " + input[pos] + ", foco: " +
                            focus.term)
                }
            }
        }
        return tree
    }

    companion object {
        fun join(arr: Array<String>, sep: String): String {
            val buf = StringBuffer()
            for (s in arr) {
                buf.append(sep)
                buf.append(s)
            }
            return buf.toString()
        }
    }
}
