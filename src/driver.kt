import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val parser = TINYParser(FileReader(File(fname)))
        val out = parser.parse()
        out.printDot(fname.substring(0, fname.lastIndexOf('.')) + ".dot")
        if (parser.ent[parser.pos].tipo !== Token.EOF) {
            System.err.println("erro de sintaxe na linha " +
                    parser.ent[parser.pfalha].lin + ": encontrado " +
                    parser.ent[parser.pfalha].lexeme + ", mas esperado " +
                    parser.tesp.joinToString(", "))
        }
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }
}
