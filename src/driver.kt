import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val parser = TINYParser(FileReader(File(fname)).readText())
        try {
            val out = parser.parse()
            out.printDot(fname.substring(0, fname.lastIndexOf('.')) + ".dot")
            if (parser.pos < parser.ent.size) {
                System.err.println("erro de sintaxe na posição " +
                        parser.pos + ": encontrado " +
                        parser.token(parser.pos) + ", mas esperado " +
                        parser.tesp.joinToString(", "))
            }
        } catch(_: Falha) {
            System.err.println("erro de sintaxe na posição " +
                    parser.pos + ": encontrado " +
                    parser.token(parser.pos) + ", mas esperado " +
                    parser.tesp.joinToString(", "))
        }
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }
}
