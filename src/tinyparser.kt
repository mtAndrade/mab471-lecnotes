class TINYParser(ent: String):
        Parser(ent.toList()) {

    val kws = setOf("if", "read", "write",
            "repeat", "until", "end",
            "then", "else")

    override fun SP() {
        while(true) {
            val atual = pos
            try {
                match {
                    c -> c.isWhitespace()
                }
            } catch(_: Falha) {
                pos = atual
                break
            }
        }
    }

    fun ID(): Tree {
        SP()
        var atual = pos
        try {
            kws.forEach { nome ->
                nome.forEach { c -> match(c) }
                val atual = pos
                try {
                    match { c ->
                        c.isJavaIdentifierPart()
                    }
                    throw FalhaFalha()
                } catch (_: Falha) {
                    pos = atual
                } catch (_: FalhaFalha) {
                    throw Falha()
                }
            }
            throw FalhaFalha()
        } catch(_: Falha) {
            pos = atual
        } catch(_: FalhaFalha) {
            throw Falha()
        }
        atual = pos
        try {
            match { c-> c.isJavaIdentifierStart() }
            while(true) {
                val atual = pos
                try {
                    match {
                        c ->
                        c.isJavaIdentifierPart()
                    }
                } catch(_: Falha) {
                    pos = atual
                    break
                }
            }
            return Tree(ent.subList(atual, pos).joinToString(""))
        } catch(_: Falha) {
            pos = atual
            if (pos == pfalha) {
                tesp.add("id")
            } else if (pos > pfalha) {
                pfalha = pos
                tesp.clear()
                tesp.add("id")
            }
            throw Falha()
        }
    }

    fun NUM(): Tree {
        SP()
        val atual = pos
        try {
            match { c-> c.isDigit() }
            while(true) {
                val atual = pos
                try {
                    match {
                        c ->
                        c.isDigit()
                    }
                } catch(_: Falha) {
                    pos = atual
                    break
                }
            }
            return Tree(ent.subList(atual, pos).joinToString(""))
        } catch(_: Falha) {
            pos = atual
            if (pos == pfalha) {
                tesp.add("num")
            } else if (pos > pfalha) {
                pfalha = pos
                tesp.clear()
                tesp.add("num")
            }
            throw Falha()
        }
    }

    // S     -> CMDS
    fun S(): Tree {
        val arvore = Tree("S")
        arvore.child(CMDS())
        SP()
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
                rascunho.child(op(";"))
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
            rascunho.child(kw("if"))
            rascunho.child(EXP())
            rascunho.child(kw("then"))
            rascunho.child(CMDS())
            val atual = pos
            try {
                // else CMDS
                val rascunho_ = Tree("")
                rascunho_.child(kw("else"))
                rascunho_.child(CMDS())
                rascunho.children.addAll(rascunho_.children)
            } catch(_: Falha) {
                pos = atual
            }
            rascunho.child(kw("end"))
            arvore.children.addAll(rascunho.children)
        } catch(_: Falha) {
            pos = atual
            val atual = pos
            try {
                // repeat CMDS until EXP
                val rascunho = Tree("")
                rascunho.child(kw("repeat"))
                rascunho.child(CMDS())
                rascunho.child(kw("until"))
                rascunho.child(EXP())
                arvore.children.addAll(rascunho.children)
            } catch(_: Falha) {
                pos = atual
                val atual = pos
                try {
                    // id := EXP
                    val rascunho = Tree("")
                    rascunho.child(ID())
                    rascunho.child(op(":="))
                    rascunho.child(EXP())
                    arvore.children.addAll(rascunho.children)
                } catch(_: Falha) {
                    pos = atual
                    val atual = pos
                    try {
                        // read ID
                        val rascunho = Tree("")
                        rascunho.child(kw("read"))
                        rascunho.child(ID())
                        arvore.children.addAll(
                                rascunho.children)
                    } catch(_: Falha) {
                        // write EXP
                        pos = atual
                        arvore.child(kw("write"))
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
                    rascunho_.child(op("<"))
                    rascunho_.child(SEXP())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                    // = SEXP
                    pos = atual
                    rascunho.child(op("="))
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
                    rascunho_.child(op("+"))
                    rascunho_.child(TERMO())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                    // - TERMO
                    pos = atual
                    rascunho.child(op("-"))
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
                    rascunho_.child(op("*"))
                    rascunho_.child(FATOR())
                    rascunho.children.addAll(rascunho_.children)
                } catch(_: Falha) {
                    // / FATOR
                    pos = atual
                    rascunho.child(op("/"))
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
            rascunho.child(op("("))
            rascunho.child(EXP())
            rascunho.child(op(")"))
            arvore.children.addAll(rascunho.children)
        } catch(_: Falha) {
            pos = atual
            val atual = pos
            try {
                val rascunho = Tree("")
                rascunho.child(NUM())
                arvore.children.addAll(rascunho.children)
            } catch (_: Falha) {
                pos = atual
                arvore.child(ID())
            }
        }
        return arvore
    }

    override fun parse(): Tree {
        return S()
    }

}

