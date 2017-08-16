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
    }
}