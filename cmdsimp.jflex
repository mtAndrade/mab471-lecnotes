package cmdsimp;

%%

%line
%public
%class Scanner
%function token
%type Token

%%

"/*"~"*/"    { }

"//".*       { }

[ \n\r\t]    { } // ignore espaços em branco

[0-9]+  { return new Token(Token.NUM, yytext(), yyline); }

[pP][rR][iI][nN][tT]    { return new Token(Token.PRINT, yytext(), yyline); }

[a-zA-Z_][a-zA-Z0-9_]*    { return new Token(Token.ID, yytext(), yyline); }

"+"|[-]|;|[(]|[)]|[=] {
   return new tok.Token(yytext().charAt(0), yytext(), yyline); }

<<EOF>>    { return new tok.Token(Token.EOF, "<<EOF>>", yyline); }

.          { throw new RuntimeException("caractere inválido "+yytext()); }

