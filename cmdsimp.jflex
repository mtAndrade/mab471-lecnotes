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

[0-9]+  { return new Token(1, yytext(), yyline); }

[pP][rR][iI][nN][tT]    { return new Token(3, yytext(), yyline); }

[a-zA-Z_][a-zA-Z0-9_]*    { return new Token(2, yytext(), yyline); }

"+"|[-]|;|[(]|[)]|[=] {
   return new tok.Token(yytext().charAt(0), yytext(), yyline); }

<<EOF>>    { return new tok.Token(0, "<<EOF>>", yyline); }

.          { throw new RuntimeException("caractere inválido "+yytext()); }

