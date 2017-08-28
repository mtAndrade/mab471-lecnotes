import org.testng.annotations.Test

@Test
fun test1() {
    val g = G(mapOf(
            Pair("E", Ou(E(E(NT("T"), T("+")),
                    NT("E")), NT("T"))),
            Pair("T", Ou(T("id"), T("num")))),
            "E")
    println(match(g, NT("E"), listOf("num", "+",
            "num", "+", "num")))
}

@Test
fun test2() {
    val t1 = ExpParser(listOf("num", "+",
            "num", "+", "num")).parse()
    t1.printDot("exp1.dot")
    val t2 = ExpParserNR(listOf("num", "+",
            "num", "+", "num")).parse()
    t2.printDot("exp2.dot")
}
