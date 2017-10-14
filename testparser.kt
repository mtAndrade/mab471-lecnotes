import org.testng.annotations.Test

object ParserTest {
    @Test
    fun test1() {
        val f = java.io.FileReader("factorial.java")
        var parser = Parser(f)
        parser.parse()
        val saida = parser.saida?.toString()
        val sr = java.io.StringReader(saida)
        parser = Parser(sr)
        parser.parse()
        val saida2 = parser.saida.toString()
        println(saida == saida2)
    }

    @Test
    fun test2() {
        val f = java.io.FileReader("binarysearch.java")
        var parser = Parser(f)
        parser.parse()
        val saida = parser.saida.toString()
        val sr = java.io.StringReader(saida)
        parser = Parser(sr)
        parser.parse()
        val saida2 = parser.saida.toString()
        println(saida == saida2)
    }

    @Test
    fun test3() {
        val f = java.io.FileReader("bubblesort.java")
        var parser = Parser(f)
        parser.parse()
        val saida = parser.saida.toString()
        val sr = java.io.StringReader(saida)
        parser = Parser(sr)
        parser.parse()
        val saida2 = parser.saida.toString()
        println(saida == saida2)
    }

    @Test
    fun test4() {
        val f = java.io.FileReader("treevisitor.java")
        var parser = Parser(f)
        parser.parse()
        val saida = parser.saida.toString()
        val sr = java.io.StringReader(saida)
        parser = Parser(sr)
        parser.parse()
        val saida2 = parser.saida.toString()
        println(saida == saida2)
    }
}