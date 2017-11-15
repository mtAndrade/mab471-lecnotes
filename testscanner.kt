import org.testng.annotations.Test

object ScannerTest {

    @Test
    fun test1() {
        val f = java.io.FileReader("factorial.java")
        val scanM   = ScannerMascarenhas(f)
        val scan    = Scanner(f)
        for (tok in scan.tokens())
            System.out.println(tok)
    }

    @Test
    fun test2() {
        val f = java.io.FileReader("binarysearch.java")
        val scan = ScannerMascarenhas(f)
        for (tok in scan.tokens())
            System.out.println(tok)
    }

    @Test
    fun test3() {
        val f = java.io.FileReader("bubblesort.java")
        val scan = ScannerMascarenhas(f)
        for (tok in scan.tokens())
            System.out.println(tok)
    }

    @Test
    fun test4() {
        val f = java.io.FileReader("treevisitor.java")
        val scan = ScannerMascarenhas(f)
        for (tok in scan.tokens())
            System.out.println(tok)
    }
}
fun main(args: Array<String>) {
    ScannerTest.test1();
}