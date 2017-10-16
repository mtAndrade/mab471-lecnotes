// Output created by jacc on Mon Oct 16 11:39:31 BRST 2017


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
                case 49:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 98;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case ';':
                            yyn = 5;
                            continue;
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case ID:
                            yyn = 7;
                            continue;
                        case IF:
                            yyn = 8;
                            continue;
                        case READ:
                            yyn = 9;
                            continue;
                        case REPEAT:
                            yyn = 10;
                            continue;
                        case WRITE:
                            yyn = 11;
                            continue;
                    }
                    yyn = 101;
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
                case 53:
                    switch (yytok) {
                        case ID:
                            yyn = 13;
                            continue;
                    }
                    yyn = 101;
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
                case 54:
                    switch (yytok) {
                        case ID:
                            yyn = 7;
                            continue;
                        case IF:
                            yyn = 8;
                            continue;
                        case READ:
                            yyn = 9;
                            continue;
                        case REPEAT:
                            yyn = 10;
                            continue;
                        case WRITE:
                            yyn = 11;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 101;
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
                case 56:
                    switch (yytok) {
                        case ATRIB:
                            yyn = 15;
                            continue;
                    }
                    yyn = 101;
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
                case 57:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
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
                case 58:
                    switch (yytok) {
                        case ID:
                            yyn = 20;
                            continue;
                    }
                    yyn = 101;
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
                case 59:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    switch (yytok) {
                        case ',':
                            yyn = 23;
                            continue;
                        case ';':
                            yyn = 24;
                            continue;
                    }
                    yyn = 101;
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
                case 62:
                    switch (yytok) {
                        case ';':
                        case ',':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 101;
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
                case 64:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
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
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
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
                case 69:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case ';':
                            yyn = 5;
                            continue;
                        case UNTIL:
                            yyn = 34;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    yyn = yys22();
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
                case 72:
                    switch (yytok) {
                        case ID:
                            yyn = 35;
                            continue;
                    }
                    yyn = 101;
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
                case 73:
                    switch (yytok) {
                        case READ:
                        case WRITE:
                        case IF:
                        case REPEAT:
                        case ID:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys25();
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
                case 75:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
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
                case 77:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 31:
                    yyst[yysp] = 31;
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
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case ID:
                            yyn = 17;
                            continue;
                        case NUM:
                            yyn = 18;
                            continue;
                        case '(':
                            yyn = 19;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case ';':
                        case ',':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case ';':
                            yyn = 5;
                            continue;
                        case ELSE:
                            yyn = 45;
                            continue;
                        case END:
                            yyn = 46;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case ';':
                            yyn = 5;
                            continue;
                        case END:
                            yyn = 48;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 98:
                    return true;
                case 99:
                    yyerror("stack overflow");
                case 100:
                    return false;
                case 101:
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

    private int yys0() {
        switch (yytok) {
            case VAR:
                return 4;
            case READ:
            case WRITE:
            case IF:
            case REPEAT:
            case ID:
                return yyr3();
        }
        return 101;
    }

    private int yys10() {
        switch (yytok) {
            case VAR:
                return 4;
            case READ:
            case WRITE:
            case IF:
            case REPEAT:
            case ID:
                return yyr3();
        }
        return 101;
    }

    private int yys16() {
        switch (yytok) {
            case THEN:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '=':
                return 32;
        }
        return 101;
    }

    private int yys17() {
        switch (yytok) {
            case REPEAT:
            case error:
            case IF:
            case ID:
            case READ:
            case '(':
            case ATRIB:
            case VAR:
            case WRITE:
            case ',':
            case NUM:
                return 101;
        }
        return yyr22();
    }

    private int yys18() {
        switch (yytok) {
            case REPEAT:
            case error:
            case IF:
            case ID:
            case READ:
            case '(':
            case ATRIB:
            case VAR:
            case WRITE:
            case ',':
            case NUM:
                return 101;
        }
        return yyr21();
    }

    private int yys22() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '=':
                return 32;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr11();
        }
        return 101;
    }

    private int yys25() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '=':
                return 32;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr13();
        }
        return 101;
    }

    private int yys26() {
        switch (yytok) {
            case VAR:
                return 4;
            case READ:
            case WRITE:
            case IF:
            case REPEAT:
            case ID:
                return yyr3();
        }
        return 101;
    }

    private int yys33() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '=':
                return 32;
            case ')':
                return 43;
        }
        return 101;
    }

    private int yys37() {
        switch (yytok) {
            case REPEAT:
            case error:
            case IF:
            case ID:
            case READ:
            case '(':
            case ATRIB:
            case VAR:
            case WRITE:
            case ',':
            case NUM:
                return 101;
        }
        return yyr19();
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case ')':
            case ENDINPUT:
            case END:
            case '<':
            case ';':
            case UNTIL:
            case '-':
            case THEN:
            case '=':
            case '+':
            case ELSE:
                return yyr16();
        }
        return 101;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case ')':
            case ENDINPUT:
            case END:
            case '<':
            case ';':
            case UNTIL:
            case '-':
            case THEN:
            case '=':
            case '+':
            case ELSE:
                return yyr17();
        }
        return 101;
    }

    private int yys40() {
        switch (yytok) {
            case REPEAT:
            case error:
            case IF:
            case ID:
            case READ:
            case '(':
            case ATRIB:
            case VAR:
            case WRITE:
            case ',':
            case NUM:
                return 101;
        }
        return yyr18();
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case ')':
            case ENDINPUT:
            case END:
            case '<':
            case ';':
            case UNTIL:
            case '=':
            case THEN:
            case ELSE:
                return yyr14();
        }
        return 101;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case ')':
            case ENDINPUT:
            case END:
            case '<':
            case ';':
            case UNTIL:
            case '=':
            case THEN:
            case ELSE:
                return yyr15();
        }
        return 101;
    }

    private int yys43() {
        switch (yytok) {
            case REPEAT:
            case error:
            case IF:
            case ID:
            case READ:
            case '(':
            case ATRIB:
            case VAR:
            case WRITE:
            case ',':
            case NUM:
                return 101;
        }
        return yyr20();
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '=':
                return 32;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr10();
        }
        return 101;
    }

    private int yys45() {
        switch (yytok) {
            case VAR:
                return 4;
            case READ:
            case WRITE:
            case IF:
            case REPEAT:
            case ID:
                return yyr3();
        }
        return 101;
    }

    private int yyr1() { // s : cmds
        { out = new Tiny(((Bloco)yysv[yysp-1])); yyrv = out; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr6() { // cmds : cmds ';' cmd
        { ((Bloco)yysv[yysp-3]).add(((Cmd)yysv[yysp-1])); yyrv = ((Bloco)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return yypcmds();
    }

    private int yyr7() { // cmds : var cmd
        { ((Bloco)yysv[yysp-2]).add(((Cmd)yysv[yysp-1])); yyrv = ((Bloco)yysv[yysp-2]); }
        yysv[yysp-=2] = yyrv;
        return yypcmds();
    }

    private int yypcmds() {
        switch (yyst[yysp-1]) {
            case 26: return 36;
            case 10: return 21;
            case 0: return 2;
            default: return 47;
        }
    }

    private int yyr14() { // exp : exp '<' exp
        { yyrv = new Menor(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr15() { // exp : exp '=' exp
        { yyrv = new Igual(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr16() { // exp : exp '+' exp
        { yyrv = new Soma(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr17() { // exp : exp '-' exp
        { yyrv = new Sub(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr18() { // exp : exp '/' exp
        { yyrv = new Div(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr19() { // exp : exp '*' exp
        { yyrv = new Mult(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr20() { // exp : '(' exp ')'
        { yyrv = ((Exp)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr21() { // exp : NUM
        { yyrv = new Num(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yyr22() { // exp : ID
        { yyrv = new Var(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yypexp() {
        switch (yyst[yysp-1]) {
            case 32: return 42;
            case 31: return 41;
            case 30: return 40;
            case 29: return 39;
            case 28: return 38;
            case 27: return 37;
            case 19: return 33;
            case 15: return 25;
            case 11: return 22;
            case 8: return 16;
            default: return 44;
        }
    }

    private int yyr4() { // ids : ids ',' ID
        { ((List)yysv[yysp-3]).add(((Token)yysv[yysp-1]).getLexeme()); yyrv = ((List)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr5() { // ids : ID
        { List<String> l = new ArrayList<String>(); l.add(((Token)yysv[yysp-1]).getLexeme()); yyrv = l; }
        yysv[yysp-=1] = yyrv;
        return 12;
    }

    private int yyr8() { // cmd : IF exp THEN cmds END
        { yyrv = new If(((Exp)yysv[yysp-4]), ((Bloco)yysv[yysp-2]), new Bloco(new ArrayList<String>(), new ArrayList<Cmd>(), ((Token)yysv[yysp-3]).getLin()), ((Token)yysv[yysp-5]).getLin()); }
        yysv[yysp-=5] = yyrv;
        return yypcmd();
    }

    private int yyr9() { // cmd : IF exp THEN cmds ELSE cmds END
        { yyrv = new If(((Exp)yysv[yysp-6]), ((Bloco)yysv[yysp-4]), ((Bloco)yysv[yysp-2]), ((Token)yysv[yysp-7]).getLin()); }
        yysv[yysp-=7] = yyrv;
        return yypcmd();
    }

    private int yyr10() { // cmd : REPEAT cmds UNTIL exp
        { yyrv = new Repeat(((Bloco)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=4] = yyrv;
        return yypcmd();
    }

    private int yyr11() { // cmd : WRITE exp
        { yyrv = new Write(((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr12() { // cmd : READ ID
        { yyrv = new Read(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr13() { // cmd : ID ATRIB exp
        { yyrv = new Atrib(((Token)yysv[yysp-3]).getLexeme(), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypcmd();
    }

    private int yypcmd() {
        switch (yyst[yysp-1]) {
            case 3: return 6;
            default: return 14;
        }
    }

    private int yyr2() { // var : VAR ids ';'
        { yyrv = new Bloco(((List)yysv[yysp-2]), new ArrayList<Cmd>(), ((Token)yysv[yysp-3]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr3() { // var : /* empty */
        { yyrv = new Bloco(new ArrayList<String>(), new ArrayList<Cmd>(), 0); }
        yysv[yysp-=0] = yyrv;
        return 3;
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
