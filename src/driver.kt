import org.testng.annotations.Test
import java.io.File
import java.io.FileReader

object Driver {
    fun parse(fname: String) {
        val parser = TINYParser(TINYScanner(FileReader(File(fname))))
        parser.parse()
        println(parser.out)
        println(parser.out.escopo())
    }

    @Test
    fun testfat() {
        parse("fat.tiny")
    }

    @Test
    fun testprog1() {
        parse("prog1.tiny")
    }

    @Test
    fun testprog2() {
        parse("prog2.tiny")
    }
}
