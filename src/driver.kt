import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val parser =
                TINYParser(TINYScanner(FileReader(File(fname))))
        val out = parser.parse()
        out.printDot(fname.substring(0, fname.lastIndexOf('.')) + ".dot")
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }
}
