%%

%public
%class TINYScanner
%function token
%type Token
%line

%%

[ \n\r\t]  { }

"{"~"}"  { }

[0-9]+  { return new Token(Token.NUM, yytext(), yyline+1); }

[wW][rR][iI][tT][eE]    { return new Token(Token.WRITE, yytext(), yyline+1); }
[iI][fF]   { return new Token(Token.IF, yytext(), yyline+1); }
[rR][eE][pP][eE][aA][tT]    { return new Token(Token.REPEAT, yytext(), yyline+1); }
[tT][hH][eE][nN]   { return new Token(Token.THEN, yytext(), yyline+1); }
[eE][lL][sS][eE]   { return new Token(Token.ELSE, yytext(), yyline+1); }
[eE][nN][dD]   { return new Token(Token.END, yytext(), yyline+1); }
[uU][nN][tT][iI][lL]   { return new Token(Token.UNTIL, yytext(), yyline+1); }
[rR][eE][aA][dD]   { return new Token(Token.READ, yytext(), yyline+1); }

[a-zA-Z_][a-zA-Z0-9_]*  { return new Token(Token.ID, yytext(), yyline+1); }

":="       { return new Token(Token.ATRIB, yytext(), yyline+1); }

.          { return new Token(yytext().charAt(0), yytext(), yyline+1);  }

<<EOF>>    { return new Token(Token.EOF, "<<EOF>>", yyline+1); }
