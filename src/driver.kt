import java.io.File
import java.io.FileReader

fun runf(f: String) {
    val scan = Scanner(16);
    scan.rule(0, "[ \n\r\t]", 1)
    scan.type(1, Token.SP)
    scan.rule(0, "<<EOF>>", 2)
    scan.type(2, Token.EOF)
    scan.rule(0, "[0-9]", 3);
    scan.rule(3, "[0-9]", 3);
    scan.type(3, Token.NUM);
    scan.rule(0, "=", 4); scan.type(4, '='.toInt())
    scan.rule(0, "[(]", 5); scan.type(5, '('.toInt())
    scan.rule(0, "[)]", 6); scan.type(6, ')'.toInt())
    scan.rule(0, ";", 7); scan.type(7, ';'.toInt())
    scan.rule(0, "[+]", 8); scan.type(8, '+'.toInt())
    scan.rule(0, "[-]", 9); scan.type(9, '-'.toInt())
    scan.rule(0, "p", 10); scan.type(10, Token.ID)
    scan.rule(10, "r", 11); scan.type(11, Token.ID)
    scan.rule(11, "i", 12); scan.type(12, Token.ID)
    scan.rule(12, "n", 13); scan.type(13, Token.ID)
    scan.rule(13, "t", 14); scan.type(14, Token.PRINT)
    scan.rule(14, "[a-zA-Z0-9_]", 15); scan.type(15, Token.ID)
    scan.rule(15, "[a-zA-Z0-9_]", 15)
    scan.rule(0, "[a-oq-zA-Z_]", 15)
    scan.rule(10, "[a-qs-zA-Z0-9_]", 15)
    scan.rule(11, "[a-hj-zA-Z0-9_]", 15)
    scan.rule(12, "[a-mo-zA-Z0-9_]", 15)
    scan.rule(13, "[a-su-zA-Z0-9_]", 15)
    scan.setInput(FileReader(File(f)))
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