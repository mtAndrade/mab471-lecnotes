import org.testng.annotations.Test

object scrapbook {
    @Test
    fun test1() {
        val g = parse.Grammar()
        g.rules("PROG", "CMD ; PROG") // 0
        g.rules("PROG", "") // 1
        g.rules("CMD", "id = EXP") // 2
        g.rules("CMD", "print EXP") // 3
        g.rules("EXP", "id") // 4
        g.rules("EXP", "num") // 5
        g.rules("EXP", "( EXP + EXP )") // 6
        g.computeSets()
        println(g)
        println(g.ll1)
        g.treeDerive("PROG", 0, 2, 6, 4, 5, 0, 3, 5, 1).printDot("cmdsimp1.dot")
    }

    @Test
    fun test2() {
        val g = parse.Grammar();
        g.rules("sentença", "sujeito verbo"); // 0
        g.rules("sentença", "sujeito verbo objeto"); // 1
        g.rules("sujeito", "substantivo"); // 2
        g.rules("sujeito", "artigo substantivo"); // 3
        g.rules("artigo", "artigo_def"); // 4
        g.rules("artigo", "artigo_indef"); // 5
        g.rules("objeto", "artigo substantivo"); // 6
        print(g.derive("sujeito verbo objeto", 6))
    }

    @Test
    fun test3() {
        val g = parse.Grammar()
        g.rules("S", "E");    // 0
        g.rules("E", "E + E") // 1
        g.rules("E", "E * E") // 2
        g.rules("E", "( E )") // 3
        g.rules("E", "num")   // 4
        print(g.derivation("S", 0, 1, 1, 2, 4, 4, 4, 3, 1, 4, 4))
        g.treeDerive("S", 0, 1, 1, 2, 4, 4, 4, 3, 1, 4, 4).printDot("exp_na_aula_1.dot")
        print(g.derivation("S", 0, 2, 4, 1, 1, 4, 4, 3, 1, 4, 4))
        g.treeDerive("S", 0, 2, 4, 1, 1, 4, 4, 3, 1, 4, 4).printDot("exp_na_aula_1.dot")
        g.computeSets()
        println(g)
        println(g.ll1)
    }

    @Test
    fun test4() {
        val g = parse.Grammar()
        g.rules("S", "C");    // 0
        g.rules("C", "if exp then C") // 1
        g.rules("C", "if exp then C else C") // 2
        g.rules("C", "outros") // 3
        println(g.leftDerive("S", 0, 1, 2, 3, 3))
        g.treeDerive("S", 0, 1, 2, 3, 3).printDot("dangif_aula_1.dot")
        println(g.leftDerive("S", 0, 2, 1, 3, 3))
        g.treeDerive("S", 0, 2, 1, 3, 3).printDot("dangif_aula_2.dot")
    }

    @Test
    fun test5() {
        val g = parse.Grammar()
        g.rules("S", "E");    // 0
        g.rules("E", "E + T") // 1
        g.rules("E", "T")     // 2
        g.rules("T", "T * F") // 3
        g.rules("T", "F")     // 4
        g.rules("F", "( E )") // 5
        g.rules("F", "num")   // 6
        println(g.leftDerive("S", 0, 1, 2, 4, 6,
                3, 4, 6, 6))
        g.treeDerive("S", 0, 1, 2, 4, 6,
                3, 4, 6, 6).printDot("expnaoamb_1.dot")
        println(g.leftDerive("S", 0, 1, 1, 2, 4, 6, 4, 6, 4, 6))
        g.treeDerive("S", 0, 1, 1, 2, 4, 6, 4, 6, 4, 6).printDot("expnaoamb_2.dot")
    }

    @Test
    fun test6() {
        val g = parse.Grammar()
        g.rules("S", "E");    // 0
        g.rules("E", "T + E") // 1
        g.rules("E", "T")     // 2
        g.rules("T", "T * F") // 3
        g.rules("T", "F")     // 4
        g.rules("F", "( E )") // 5
        g.rules("F", "num")   // 6
        println(g.leftDerive("S", 0, 1, 4, 6, 2,
                3, 4, 6, 6))
        g.treeDerive("S", 0, 1, 4, 6, 2,
                3, 4, 6, 6).printDot("expnaoamb_3.dot")
        println(g.leftDerive("S", 0, 1, 4, 6, 1, 4, 6, 2, 4, 6))
        g.treeDerive("S", 0, 1, 4, 6, 1, 4, 6, 2, 4, 6).printDot("expnaoamb_4.dot")
    }

    @Test
    fun test7() {
        val g = parse.Grammar()
        g.rules("S", "C");    // 0
        g.rules("C", "if exp then C") // 1
        g.rules("C", "if exp then CE else C") // 2
        g.rules("C", "outros") // 3
        g.rules("CE", "if exp then CE else CE") // 4
        g.rules("CE", "outros") // 5
        println(g.leftDerive("S", 0, 1, 2, 5, 3))
        g.treeDerive("S", 0, 1, 2, 5, 3).printDot("dangif_aula_semamb.dot")
    }

    @Test
    fun tinytest() {
        val g = parse.Grammar()
        g.rules("S", "CMDS")
        g.rules("CMDS", "CMD CMDR")
        g.rules("CMDR", "; CMD CMDR")
        g.rules("CMDR", "")
        g.rules("CMD", "if EXP then CMDS ELSEP end")
        g.rules("ELSEP", "else CMDS")
        g.rules("ELSEP", "")
        g.rules("CMD", "repeat CMDS until EXP")
        g.rules("CMD", "write EXP")
        g.rules("CMD", "read ID")
        g.rules("CMD", "id := EXP")
        g.rules("EXP", "SEXP EXPR")
        g.rules("EXPR", "< SEXP EXPR")
        g.rules("EXPR", "= SEXP EXPR")
        g.rules("EXPR", "")
        g.rules("SEXP", "TERMO SEXPR")
        g.rules("SEXPR", "+ TERMO SEXPR")
        g.rules("SEXPR", "- TERMO SEXPR")
        g.rules("SEXPR", "")
        g.rules("TERMO", "FATOR TERMOR")
        g.rules("TERMOR", "* FATOR TERMOR")
        g.rules("TERMOR", "/ FATOR TERMOR")
        g.rules("TERMOR", "")
        g.rules("FATOR", "( EXP )")
        g.rules("FATOR", "num")
        g.rules("FATOR", "id")
        g.computeSets()
        println(g)
        println(g.ll1)
    }

}
