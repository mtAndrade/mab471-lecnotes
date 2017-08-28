import java.io.Reader

class TINYParser(ent: Reader): Parser(ent) {

    // S     -> CMDS
    fun S(): Tree {
        val arvore = Tree("S")
        arvore.child(CMDS())
        return arvore
    }


    // CMDS  -> CMD (; CMD)*
    fun CMDS(): Tree {
        val arvore = Tree("CMDS")
        arvore.child(CMD())
        while(true) {
            val atual = pos
            try {
                val rascunho = Tree("")
                rascunho.child(match(';'))
                rascunho.child(CMD())
                arvore.children.addAll(rascunho.children)
            } catch(f: Falha) {
                pos = atual
                break
            }
        }
        return arvore
    }

    /*
    CMD   -> if EXP then CMDS (else CMDS)? end
       | repeat CMDS until EXP
       | id := EXP
       | read id
       | write EXP
    */
    fun CMD(): Tree {
        val arvore = Tree("CMD")
        val atual = pos
        try {
            // if EXP then CMDS (else CMDS)? end
            val rascunho = Tree("")
            rascunho.child(match(Token.IF))
            rascunho.child(EXP())
            rascunho.child(match(Token.THEN))
            rascunho.child(CMDS())
            val atual = pos
            try {
                // else CMDS
                val rascunho_ = Tree("")
                rascunho_.child(match(Token.ELSE))
                rascunho_.child(CMDS())
                rascunho.children.addAll(rascunho_.children)
            } catch(_: Falha) {
                pos = atual
            }
            rascunho.child(match(Token.END))
            arvore.children.addAll(rascunho.children)
        } catch(_: Falha) {
            pos = atual
            val atual = pos
            try {
                // repeat CMDS until EXP
                val rascunho = Tree("")
                rascunho.child(match(Token.REPEAT))
                rascunho.child(CMDS())
                rascunho.child(match(Token.UNTIL))
                rascunho.child(EXP())
                arvore.children.addAll(rascunho.children)
            } catch(_: Falha) {
                pos = atual
                val atual = pos
                try {
                    // id := EXP
                    val rascunho = Tree("")
                    rascunho.child(match(Token.ID))
                    rascunho.child(match(Token.ATRIB))
                    rascunho.child(EXP())
                    arvore.children.addAll(rascunho.children)
                } catch(_: Falha) {
                    pos = atual
                    val atual = pos
                    try {
                        // read ID
                        val rascunho = Tree("")
                        rascunho.child(match(Token.READ))
                        rascunho.child(match(Token.ID))
                        arvore.children.addAll(
                                rascunho.children)
                    } catch(_: Falha) {
                        // write EXP
                        pos = atual
                        arvore.child(match(Token.WRITE))
                        arvore.child(EXP())
                    }
                }
            }
        }
        return arvore
    }

    // EXP   -> SEXP (< SEXP | = SEXP)*
    fun EXP(): Tree {
        val arvore = Tree("EXP")
        arvore.child(SEXP())
        while(true) {
            val atual = pos
            try {
                val rascunho = Tree("")
                val atual = pos
                try {
                    // < SEXP
                    val rascunho_ = Tree("")
                    rascunho_.child(match('<'))
                    rascunho_.child(SEXP())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                   // = SEXP
                    pos = atual
                    rascunho.child(match('='))
                    rascunho.child(SEXP())
                }
                arvore.children.addAll(rascunho.children)
            } catch(_: Falha) {
                pos = atual
                break
            }
        }
        return arvore
    }

    //SEXP  -> TERMO (+ TERMO | - TERMO)*
    fun SEXP(): Tree {
        val arvore = Tree("SEXP")
        arvore.child(TERMO())
        while(true) {
            val atual = pos
            try {
                val rascunho = Tree("")
                val atual = pos
                try {
                    // + TERMO
                    val rascunho_ = Tree("")
                    rascunho_.child(match('+'))
                    rascunho_.child(TERMO())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                    // - TERMO
                    pos = atual
                    rascunho.child(match('-'))
                    rascunho.child(TERMO())
                }
                arvore.children.addAll(rascunho.children)
            } catch(_: Falha) {
                pos = atual
                break
            }
        }
        return arvore
    }

    // TERMO -> FATOR (* FATOR | / FATOR)*
    fun TERMO(): Tree {
        val arvore = Tree("TERMO")
        arvore.child(FATOR())
        while(true) {
            val atual = pos
            try {
                val rascunho = Tree("")
                val atual = pos
                try {
                    // * FATOR
                    val rascunho_ = Tree("")
                    rascunho_.child(match('*'))
                    rascunho_.child(FATOR())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                    // / FATOR
                    pos = atual
                    rascunho.child(match('/'))
                    rascunho.child(FATOR())
                }
                arvore.children.addAll(rascunho.children)
            } catch(_: Falha) {
                pos = atual
                break
            }
        }
        return arvore
    }

    // FATOR -> "(" EXP ")" | num | id
    fun FATOR(): Tree {
        val arvore = Tree("FATOR")
        val atual = pos
        try {
            val rascunho = Tree("")
            rascunho.child(match('('))
            rascunho.child(EXP())
            rascunho.child(match(')'))
            arvore.children.addAll(rascunho.children)
        } catch(_: Falha) {
            pos = atual
            val atual = pos
            try {
                val rascunho = Tree("")
                rascunho.child(match(Token.NUM))
                arvore.children.addAll(rascunho.children)
            } catch (_: Falha) {
                pos = atual
                arvore.child(match(Token.ID))
            }
        }
        return arvore
    }

    override fun parse(): Tree {
        return S()
    }

}
