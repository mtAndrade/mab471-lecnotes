// Output created by jacc on Mon Oct 16 10:46:51 BRST 2017


import java.util.List;
import java.util.ArrayList;

class TINYParser implements TINYTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private Object[] yysv;
    private Object yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new Object[yyss];
        yytok = (tipo
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    switch (yytok) {
                        case ID:
                            yyn = 4;
                            continue;
                        case IF:
                            yyn = 5;
                            continue;
                        case READ:
                            yyn = 6;
                            continue;
                        case REPEAT:
                            yyn = 7;
                            continue;
                        case WRITE:
                            yyn = 8;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 43:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 84;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 44:
                    switch (yytok) {
                        case ';':
                            yyn = 9;
                            continue;
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    switch (yytok) {
                        case END:
                        case ENDINPUT:
                        case UNTIL:
                        case ';':
                        case ELSE:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    switch (yytok) {
                        case ATRIB:
                            yyn = 10;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    switch (yytok) {
                        case ID:
                            yyn = 15;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    switch (yytok) {
                        case ID:
                            yyn = 4;
                            continue;
                        case IF:
                            yyn = 5;
                            continue;
                        case READ:
                            yyn = 6;
                            continue;
                        case REPEAT:
                            yyn = 7;
                            continue;
                        case WRITE:
                            yyn = 8;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case ID:
                            yyn = 4;
                            continue;
                        case IF:
                            yyn = 5;
                            continue;
                        case READ:
                            yyn = 6;
                            continue;
                        case REPEAT:
                            yyn = 7;
                            continue;
                        case WRITE:
                            yyn = 8;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    yyn = yys11();
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    yyn = yys12();
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    yyn = yys13();
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    switch (yytok) {
                        case END:
                        case ENDINPUT:
                        case UNTIL:
                        case ';':
                        case ELSE:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case ';':
                            yyn = 9;
                            continue;
                        case UNTIL:
                            yyn = 28;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 59:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    switch (yytok) {
                        case END:
                        case ENDINPUT:
                        case UNTIL:
                        case ';':
                        case ELSE:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    switch (yytok) {
                        case ID:
                            yyn = 4;
                            continue;
                        case IF:
                            yyn = 5;
                            continue;
                        case READ:
                            yyn = 6;
                            continue;
                        case REPEAT:
                            yyn = 7;
                            continue;
                        case WRITE:
                            yyn = 8;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case ID:
                            yyn = 12;
                            continue;
                        case NUM:
                            yyn = 13;
                            continue;
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case ';':
                            yyn = 9;
                            continue;
                        case ELSE:
                            yyn = 38;
                            continue;
                        case END:
                            yyn = 39;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    switch (yytok) {
                        case ID:
                            yyn = 4;
                            continue;
                        case IF:
                            yyn = 5;
                            continue;
                        case READ:
                            yyn = 6;
                            continue;
                        case REPEAT:
                            yyn = 7;
                            continue;
                        case WRITE:
                            yyn = 8;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case END:
                        case ENDINPUT:
                        case UNTIL:
                        case ';':
                        case ELSE:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case ';':
                            yyn = 9;
                            continue;
                        case END:
                            yyn = 41;
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case END:
                        case ENDINPUT:
                        case UNTIL:
                        case ';':
                        case ELSE:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 87;
                    continue;

                case 84:
                    return true;
                case 85:
                    yyerror("stack overflow");
                case 86:
                    return false;
                case 87:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        Object[] newyysv = new Object[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys11() {
        switch (yytok) {
            case THEN:
                return 20;
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case '<':
                return 25;
            case '=':
                return 26;
        }
        return 87;
    }

    private int yys12() {
        switch (yytok) {
            case '(':
            case REPEAT:
            case WRITE:
            case READ:
            case NUM:
            case error:
            case ATRIB:
            case IF:
            case ID:
                return 87;
        }
        return yyr18();
    }

    private int yys13() {
        switch (yytok) {
            case '(':
            case REPEAT:
            case WRITE:
            case READ:
            case NUM:
            case error:
            case ATRIB:
            case IF:
            case ID:
                return 87;
        }
        return yyr17();
    }

    private int yys17() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case '<':
                return 25;
            case '=':
                return 26;
            case END:
            case ENDINPUT:
            case UNTIL:
            case ';':
            case ELSE:
                return yyr7();
        }
        return 87;
    }

    private int yys19() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case '<':
                return 25;
            case '=':
                return 26;
            case END:
            case ENDINPUT:
            case UNTIL:
            case ';':
            case ELSE:
                return yyr9();
        }
        return 87;
    }

    private int yys27() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case '<':
                return 25;
            case '=':
                return 26;
            case ')':
                return 36;
        }
        return 87;
    }

    private int yys30() {
        switch (yytok) {
            case '(':
            case REPEAT:
            case WRITE:
            case READ:
            case NUM:
            case error:
            case ATRIB:
            case IF:
            case ID:
                return 87;
        }
        return yyr15();
    }

    private int yys31() {
        switch (yytok) {
            case ID:
            case '(':
            case error:
            case REPEAT:
            case NUM:
            case READ:
            case ATRIB:
            case WRITE:
            case IF:
                return 87;
            case '*':
                return 21;
            case '/':
                return 24;
        }
        return yyr12();
    }

    private int yys32() {
        switch (yytok) {
            case ID:
            case '(':
            case error:
            case REPEAT:
            case NUM:
            case READ:
            case ATRIB:
            case WRITE:
            case IF:
                return 87;
            case '*':
                return 21;
            case '/':
                return 24;
        }
        return yyr13();
    }

    private int yys33() {
        switch (yytok) {
            case '(':
            case REPEAT:
            case WRITE:
            case READ:
            case NUM:
            case error:
            case ATRIB:
            case IF:
            case ID:
                return 87;
        }
        return yyr14();
    }

    private int yys34() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case ')':
            case END:
            case ENDINPUT:
            case '<':
            case UNTIL:
            case ';':
            case '=':
            case THEN:
            case ELSE:
                return yyr10();
        }
        return 87;
    }

    private int yys35() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case ')':
            case END:
            case ENDINPUT:
            case '<':
            case UNTIL:
            case ';':
            case '=':
            case THEN:
            case ELSE:
                return yyr11();
        }
        return 87;
    }

    private int yys36() {
        switch (yytok) {
            case '(':
            case REPEAT:
            case WRITE:
            case READ:
            case NUM:
            case error:
            case ATRIB:
            case IF:
            case ID:
                return 87;
        }
        return yyr16();
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case '/':
                return 24;
            case '<':
                return 25;
            case '=':
                return 26;
            case END:
            case ENDINPUT:
            case UNTIL:
            case ';':
            case ELSE:
                return yyr6();
        }
        return 87;
    }

    private int yyr1() { // s : cmds
        { out = new Tiny(((List)yysv[yysp-1])); yyrv = out; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // cmds : cmds ';' cmd
        { ((List)yysv[yysp-3]).add(((Cmd)yysv[yysp-1])); yyrv = ((List)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return yypcmds();
    }

    private int yyr3() { // cmds : cmd
        { List<Cmd> l = new ArrayList<Cmd>(); l.add(((Cmd)yysv[yysp-1])); yyrv = l; }
        yysv[yysp-=1] = yyrv;
        return yypcmds();
    }

    private int yypcmds() {
        switch (yyst[yysp-1]) {
            case 20: return 29;
            case 7: return 16;
            case 0: return 2;
            default: return 40;
        }
    }

    private int yyr10() { // exp : exp '<' exp
        { yyrv = new Menor(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr11() { // exp : exp '=' exp
        { yyrv = new Igual(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr12() { // exp : exp '+' exp
        { yyrv = new Soma(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr13() { // exp : exp '-' exp
        { yyrv = new Sub(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr14() { // exp : exp '/' exp
        { yyrv = new Div(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr15() { // exp : exp '*' exp
        { yyrv = new Mult(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr16() { // exp : '(' exp ')'
        { yyrv = ((Exp)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr17() { // exp : NUM
        { yyrv = new Num(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yyr18() { // exp : ID
        { yyrv = new Var(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yypexp() {
        switch (yyst[yysp-1]) {
            case 26: return 35;
            case 25: return 34;
            case 24: return 33;
            case 23: return 32;
            case 22: return 31;
            case 21: return 30;
            case 14: return 27;
            case 10: return 19;
            case 8: return 17;
            case 5: return 11;
            default: return 37;
        }
    }

    private int yyr4() { // cmd : IF exp THEN cmds END
        { yyrv = new If(((Exp)yysv[yysp-4]), ((List)yysv[yysp-2]), new ArrayList<Cmd>(), ((Token)yysv[yysp-5]).getLin()); }
        yysv[yysp-=5] = yyrv;
        return yypcmd();
    }

    private int yyr5() { // cmd : IF exp THEN cmds ELSE cmds END
        { yyrv = new If(((Exp)yysv[yysp-6]), ((List)yysv[yysp-4]), ((List)yysv[yysp-2]), ((Token)yysv[yysp-7]).getLin()); }
        yysv[yysp-=7] = yyrv;
        return yypcmd();
    }

    private int yyr6() { // cmd : REPEAT cmds UNTIL exp
        { yyrv = new Repeat(((List)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=4] = yyrv;
        return yypcmd();
    }

    private int yyr7() { // cmd : WRITE exp
        { yyrv = new Write(((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr8() { // cmd : READ ID
        { yyrv = new Read(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr9() { // cmd : ID ATRIB exp
        { yyrv = new Atrib(((Token)yysv[yysp-3]).getLexeme(), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypcmd();
    }

    private int yypcmd() {
        switch (yyst[yysp-1]) {
            case 9: return 18;
            default: return 3;
        }
    }

    protected String[] yyerrmsgs = {
    };


TINYScanner scan;
int tipo;
Object node;

public Tiny out;

public TINYParser(TINYScanner scan) {
        this.scan = scan;
        token();
}

int token() {
        try {
                Token tok = scan.token();
                tipo = tok.getTipo();
                node = tok;
                return tipo;
        } catch(java.io.IOException ioex) {
                throw new RuntimeException(ioex);
        }
}

void yyerror(String err) {
        throw new RuntimeException(err);        
}


}
