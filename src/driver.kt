import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val g = Grammar()
        g.rules("S", "CMDS")
        g.rules("CMDS", "CMDS ; CMD")
        g.rules("CMDS", "CMD")
        g.rules("CMD", "if EXP then CMDS end")
        g.rules("CMD", "if EXP then CMDS else CMDS end")
        g.rules("CMD", "repeat CMDS until EXP")
        g.rules("CMD", "write EXP")
        g.rules("CMD", "read id")
        g.rules("CMD", "id := EXP")
        g.rules("EXP", "EXP < EXP")
        g.rules("EXP", "EXP = EXP")
        g.rules("EXP", "EXP + EXP")
        g.rules("EXP", "EXP - EXP")
        g.rules("EXP", "EXP * EXP")
        g.rules("EXP", "EXP / EXP")
        g.rules("EXP", "( EXP )")
        g.rules("EXP", "num")
        g.rules("EXP", "id")
        g.computeSets()
        val parser = SLRParser(g, "< =", "+ -", "* /")
        parser.printTable()
        parser.setInput(TINYScanner(FileReader(File(fname))))
        parser.aut.printDot("tiny.dot")
        val out = parser.parse()
        out.printDot(fname.substring(0, fname.lastIndexOf('.')) + ".dot")
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }

    @Test
    fun testAmb() {
        val g = Grammar()
        g.rules("S", "E")
        g.rules("E", "E + E")
        g.rules("E", "E * E")
        g.rules("E", "- E")
        g.rules("E", "num")
        g.computeSets()
        val parser = SLRParser(g, "+", "*", "-")
        parser.aut.printDot("amb.dot")
    }
}
