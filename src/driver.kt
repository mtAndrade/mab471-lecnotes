import java.io.File
import java.io.FileReader
import java.io.StringReader

fun run1() {
    val ent = StringReader("""
      x = 2;
      y = 3;
      print x + (y-2);
    """)
    val scan = Scanner(ent)
    var tok = scan.token()
    println(tok)
    tok = scan.token()
    println(tok)
    tok = scan.token()
    tok = scan.token()
    tok = scan.token()
    println(tok)
}

fun run2() {
    val ent = StringReader("""
      x = 10;
      y = 3;
      print x + (y-2) - 5;
    """)
    val scan = Scanner(ent)
    val parser = Parser(scan)
    val prog = parser.prog()
    //println(prog);
    //prog.codigo("simples");
    prog.run()
}

fun runf(f: String) {
    val f = File(f)
    val fr = FileReader(f)
    val scan = Scanner(fr)
    val parser = Parser(scan)
    val prog = parser.prog()
    println(prog.toString())
    val fname = f.name
    prog.run()
    prog.codigo(fname.substring(0, fname.lastIndexOf('.')))
}

fun main(args: Array<String>) {
    runf("prog2.prg")
}