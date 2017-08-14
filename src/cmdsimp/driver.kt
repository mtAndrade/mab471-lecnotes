package cmdsimp

import java.io.File
import java.io.FileReader

fun runf(f: String) {
    val scan = Scanner(FileReader(File(f)))
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