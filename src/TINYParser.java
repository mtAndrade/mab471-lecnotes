// Output created by jacc on Wed Oct 18 10:46:05 BRST 2017


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
                case 62:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 124;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    switch (yytok) {
                        case ';':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    switch (yytok) {
                        case ';':
                            yyn = 9;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                        case IF:
                            yyn = 12;
                            continue;
                        case READ:
                            yyn = 13;
                            continue;
                        case REPEAT:
                            yyn = 14;
                            continue;
                        case WRITE:
                            yyn = 15;
                            continue;
                    }
                    yyn = 127;
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
                case 68:
                    switch (yytok) {
                        case ID:
                            yyn = 16;
                            continue;
                    }
                    yyn = 127;
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
                case 69:
                    switch (yytok) {
                        case ID:
                            yyn = 18;
                            continue;
                    }
                    yyn = 127;
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
                case 70:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                        case IF:
                            yyn = 12;
                            continue;
                        case READ:
                            yyn = 13;
                            continue;
                        case REPEAT:
                            yyn = 14;
                            continue;
                        case WRITE:
                            yyn = 15;
                            continue;
                    }
                    yyn = 127;
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
                case 71:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 127;
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
                case 73:
                    switch (yytok) {
                        case ATRIB:
                            yyn = 22;
                            continue;
                        case '(':
                            yyn = 23;
                            continue;
                    }
                    yyn = 127;
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
                case 74:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 75:
                    switch (yytok) {
                        case ID:
                            yyn = 28;
                            continue;
                    }
                    yyn = 127;
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
                case 76:
                    yyn = yys14();
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
                case 77:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case '(':
                            yyn = 31;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case ',':
                            yyn = 32;
                            continue;
                        case ';':
                            yyn = 33;
                            continue;
                    }
                    yyn = 127;
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
                case 80:
                    switch (yytok) {
                        case ';':
                        case ',':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case ';':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 127;
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
                case 84:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 85:
                    switch (yytok) {
                        case ')':
                            yyn = 35;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys24();
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
                case 87:
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
                case 88:
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
                case 89:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 90:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case UNTIL:
                            yyn = 44;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys30();
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
                case 93:
                    switch (yytok) {
                        case ')':
                            yyn = 45;
                            continue;
                    }
                    yyn = 127;
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
                case 94:
                    switch (yytok) {
                        case ID:
                            yyn = 46;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case WRITE:
                        case IF:
                        case REPEAT:
                        case READ:
                        case ID:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys34();
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
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 127;
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
                case 98:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 100:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 101:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 103:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case NUM:
                            yyn = 26;
                            continue;
                        case '(':
                            yyn = 27;
                            continue;
                    }
                    yyn = 127;
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
                case 107:
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
                case 108:
                    switch (yytok) {
                        case ';':
                        case ',':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case ELSE:
                            yyn = 57;
                            continue;
                        case END:
                            yyn = 58;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case END:
                            yyn = 59;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    switch (yytok) {
                        case ';':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    switch (yytok) {
                        case ';':
                            yyn = 8;
                            continue;
                        case END:
                            yyn = 61;
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    yysv[yysp] = (node
                                 );
                    yytok = (token()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    switch (yytok) {
                        case ENDINPUT:
                        case END:
                        case ';':
                        case UNTIL:
                        case ELSE:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 127;
                    continue;

                case 124:
                    return true;
                case 125:
                    yyerror("stack overflow");
                case 126:
                    return false;
                case 127:
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
            case PROCEDURE:
                return 6;
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yys9() {
        switch (yytok) {
            case PROCEDURE:
                return 6;
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yys14() {
        switch (yytok) {
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yys24() {
        switch (yytok) {
            case THEN:
                return 36;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '=':
                return 42;
        }
        return 127;
    }

    private int yys25() {
        switch (yytok) {
            case ID:
            case error:
            case VAR:
            case REPEAT:
            case '(':
            case PROCEDURE:
            case ATRIB:
            case NUM:
            case IF:
            case ',':
            case READ:
            case WRITE:
                return 127;
        }
        return yyr27();
    }

    private int yys26() {
        switch (yytok) {
            case ID:
            case error:
            case VAR:
            case REPEAT:
            case '(':
            case PROCEDURE:
            case ATRIB:
            case NUM:
            case IF:
            case ',':
            case READ:
            case WRITE:
                return 127;
        }
        return yyr26();
    }

    private int yys30() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '=':
                return 42;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr15();
        }
        return 127;
    }

    private int yys34() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '=':
                return 42;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr17();
        }
        return 127;
    }

    private int yys36() {
        switch (yytok) {
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '=':
                return 42;
            case ')':
                return 54;
        }
        return 127;
    }

    private int yys45() {
        switch (yytok) {
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yys48() {
        switch (yytok) {
            case ID:
            case error:
            case VAR:
            case REPEAT:
            case '(':
            case PROCEDURE:
            case ATRIB:
            case NUM:
            case IF:
            case ',':
            case READ:
            case WRITE:
                return 127;
        }
        return yyr24();
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 37;
            case '/':
                return 40;
            case ENDINPUT:
            case '=':
            case END:
            case UNTIL:
            case '-':
            case THEN:
            case ';':
            case '<':
            case '+':
            case ')':
            case ELSE:
                return yyr21();
        }
        return 127;
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 37;
            case '/':
                return 40;
            case ENDINPUT:
            case '=':
            case END:
            case UNTIL:
            case '-':
            case THEN:
            case ';':
            case '<':
            case '+':
            case ')':
            case ELSE:
                return yyr22();
        }
        return 127;
    }

    private int yys51() {
        switch (yytok) {
            case ID:
            case error:
            case VAR:
            case REPEAT:
            case '(':
            case PROCEDURE:
            case ATRIB:
            case NUM:
            case IF:
            case ',':
            case READ:
            case WRITE:
                return 127;
        }
        return yyr23();
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case ENDINPUT:
            case '=':
            case END:
            case '<':
            case ';':
            case UNTIL:
            case THEN:
            case ')':
            case ELSE:
                return yyr19();
        }
        return 127;
    }

    private int yys53() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case ENDINPUT:
            case '=':
            case END:
            case '<':
            case ';':
            case UNTIL:
            case THEN:
            case ')':
            case ELSE:
                return yyr20();
        }
        return 127;
    }

    private int yys54() {
        switch (yytok) {
            case ID:
            case error:
            case VAR:
            case REPEAT:
            case '(':
            case PROCEDURE:
            case ATRIB:
            case NUM:
            case IF:
            case ',':
            case READ:
            case WRITE:
                return 127;
        }
        return yyr25();
    }

    private int yys55() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '=':
                return 42;
            case ENDINPUT:
            case END:
            case ';':
            case UNTIL:
            case ELSE:
                return yyr14();
        }
        return 127;
    }

    private int yys57() {
        switch (yytok) {
            case VAR:
                return 7;
            case WRITE:
            case IF:
            case REPEAT:
            case READ:
            case ID:
                return yyr7();
        }
        return 127;
    }

    private int yyr1() { // s : procs ';' cmds
        { out = new Tiny(((List)yysv[yysp-3]), ((Bloco)yysv[yysp-1])); yyrv = out; }
        yysv[yysp-=3] = yyrv;
        return 1;
    }

    private int yyr2() { // s : cmds
        { out = new Tiny(new ArrayList<Proc>(), ((Bloco)yysv[yysp-1])); yyrv = out; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr10() { // cmds : cmds ';' cmd
        { ((Bloco)yysv[yysp-3]).add(((Cmd)yysv[yysp-1])); yyrv = ((Bloco)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return yypcmds();
    }

    private int yyr11() { // cmds : var cmd
        { ((Bloco)yysv[yysp-2]).add(((Cmd)yysv[yysp-1])); yyrv = ((Bloco)yysv[yysp-2]); }
        yysv[yysp-=2] = yyrv;
        return yypcmds();
    }

    private int yypcmds() {
        switch (yyst[yysp-1]) {
            case 45: return 56;
            case 36: return 47;
            case 14: return 29;
            case 9: return 20;
            case 0: return 2;
            default: return 60;
        }
    }

    private int yyr19() { // exp : exp '<' exp
        { yyrv = new Menor(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr20() { // exp : exp '=' exp
        { yyrv = new Igual(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr21() { // exp : exp '+' exp
        { yyrv = new Soma(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr22() { // exp : exp '-' exp
        { yyrv = new Sub(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr23() { // exp : exp '/' exp
        { yyrv = new Div(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr24() { // exp : exp '*' exp
        { yyrv = new Mult(((Exp)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr25() { // exp : '(' exp ')'
        { yyrv = ((Exp)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexp();
    }

    private int yyr26() { // exp : NUM
        { yyrv = new Num(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yyr27() { // exp : ID
        { yyrv = new Var(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=1] = yyrv;
        return yypexp();
    }

    private int yypexp() {
        switch (yyst[yysp-1]) {
            case 42: return 53;
            case 41: return 52;
            case 40: return 51;
            case 39: return 50;
            case 38: return 49;
            case 37: return 48;
            case 27: return 43;
            case 22: return 34;
            case 15: return 30;
            case 12: return 24;
            default: return 55;
        }
    }

    private int yyr8() { // ids : ids ',' ID
        { ((List)yysv[yysp-3]).add(((Token)yysv[yysp-1]).getLexeme()); yyrv = ((List)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return 17;
    }

    private int yyr9() { // ids : ID
        { List<String> l = new ArrayList<String>(); l.add(((Token)yysv[yysp-1]).getLexeme()); yyrv = l; }
        yysv[yysp-=1] = yyrv;
        return 17;
    }

    private int yyr5() { // proc : PROCEDURE ID '(' ')' cmds END
        { yyrv = new Proc(((Token)yysv[yysp-5]).getLexeme(), ((Bloco)yysv[yysp-2]), ((Token)yysv[yysp-6]).getLin()); }
        yysv[yysp-=6] = yyrv;
        switch (yyst[yysp-1]) {
            case 0: return 3;
            default: return 21;
        }
    }

    private int yyr3() { // procs : procs ';' proc
        { ((List)yysv[yysp-3]).add(((Proc)yysv[yysp-1])); yyrv = ((List)yysv[yysp-3]); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr4() { // procs : proc
        { List<Proc> l = new ArrayList<Proc>();
               l.add(((Proc)yysv[yysp-1])); yyrv = l; }
        yysv[yysp-=1] = yyrv;
        return 4;
    }

    private int yyr12() { // cmd : IF exp THEN cmds END
        { yyrv = new If(((Exp)yysv[yysp-4]), ((Bloco)yysv[yysp-2]), new Bloco(new ArrayList<String>(), new ArrayList<Cmd>(), ((Token)yysv[yysp-3]).getLin()), ((Token)yysv[yysp-5]).getLin()); }
        yysv[yysp-=5] = yyrv;
        return yypcmd();
    }

    private int yyr13() { // cmd : IF exp THEN cmds ELSE cmds END
        { yyrv = new If(((Exp)yysv[yysp-6]), ((Bloco)yysv[yysp-4]), ((Bloco)yysv[yysp-2]), ((Token)yysv[yysp-7]).getLin()); }
        yysv[yysp-=7] = yyrv;
        return yypcmd();
    }

    private int yyr14() { // cmd : REPEAT cmds UNTIL exp
        { yyrv = new Repeat(((Bloco)yysv[yysp-3]), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=4] = yyrv;
        return yypcmd();
    }

    private int yyr15() { // cmd : WRITE exp
        { yyrv = new Write(((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr16() { // cmd : READ ID
        { yyrv = new Read(((Token)yysv[yysp-1]).getLexeme(), ((Token)yysv[yysp-1]).getLin()); }
        yysv[yysp-=2] = yyrv;
        return yypcmd();
    }

    private int yyr17() { // cmd : ID ATRIB exp
        { yyrv = new Atrib(((Token)yysv[yysp-3]).getLexeme(), ((Exp)yysv[yysp-1]), ((Token)yysv[yysp-2]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypcmd();
    }

    private int yyr18() { // cmd : ID '(' ')'
        { yyrv = new Chamada(((Token)yysv[yysp-3]).getLexeme(), ((Token)yysv[yysp-3]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return yypcmd();
    }

    private int yypcmd() {
        switch (yyst[yysp-1]) {
            case 5: return 10;
            default: return 19;
        }
    }

    private int yyr6() { // var : VAR ids ';'
        { yyrv = new Bloco(((List)yysv[yysp-2]), new ArrayList<Cmd>(), ((Token)yysv[yysp-3]).getLin()); }
        yysv[yysp-=3] = yyrv;
        return 5;
    }

    private int yyr7() { // var : /* empty */
        { yyrv = new Bloco(new ArrayList<String>(), new ArrayList<Cmd>(), 0); }
        yysv[yysp-=0] = yyrv;
        return 5;
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
        throw new RuntimeException(err + ": " + node.toString());
}


}
