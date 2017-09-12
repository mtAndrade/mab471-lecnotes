import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val g = Grammar()
        g.rules("S", "CMDS")
        g.rules("CMDS", "CMD CMDR")
        g.rules("CMDR", "; CMD CMDR")
        g.rules("CMDR", "")
        g.rules("CMD", "if EXP then CMDS ELSEP end")
        g.rules("ELSEP", "else CMDS")
        g.rules("ELSEP", "")
        g.rules("CMD", "repeat CMDS until EXP")
        g.rules("CMD", "write EXP")
        g.rules("CMD", "read id")
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
        val out = g.parse(TINYScanner(FileReader(File(fname))))
        out.printDot(fname.substring(0, fname.lastIndexOf('.')) + ".dot")
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }
}
