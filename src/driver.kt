import java.io.File
import java.io.FileReader

fun runf(f: String) {
    val ent = FileReader(File(f)).readLines().reduce({ s1, s2 -> s1 + s2 })
    val scan = Scanner("[ \n\r\t]+",
            listOf(
                Rule("[0-9]+", Token.NUM),
                Rule("[pP][rR][iI][nN][tT][lL][nN]", Token.PRINT),
                Rule("[+]", '+'.toInt()),
                Rule("[-]", '-'.toInt()),
                Rule("[(]", '('.toInt()),
                Rule("[)]", ')'.toInt()),
                Rule("=", '='.toInt()),
                Rule(";", ';'.toInt()),
                Rule("[a-zA-Z_][a-zA-Z0-9_]*", Token.ID)
            ), ent)
    val parser = Parser(scan)
    val prog = parser.prog()
    println(prog.toString())
    val fname = File(f).name
    prog.run()
    prog.codigo(fname.substring(0, fname.lastIndexOf('.')))
}

fun main(args: Array<String>) {
    runf("prog2.prg")
}