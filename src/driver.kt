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
    fun test1() {
        parse("fat.tiny")
    }

    @Test
    fun test2() {
        parse("prog1.tiny")
    }

    @Test
    fun test3() {
        parse("prog2.tiny")
    }

    @Test
    fun test4() {
        parse("parimpar.tiny")
    }
}
