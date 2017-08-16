package cmdsimp;

%%

%line
%public
%class Scanner
%function token
%type Token

%state COMENTARIO

%{
   int nivel = 0;
%}

%%

<COMENTARIO> {
   "/*"        { nivel++; }
   "*/"        { nivel--;
                 if(nivel == 0) yybegin(YYINITIAL);
               }
   [^]       {}
}

<YYINITIAL> {

"/*"         { yybegin(COMENTARIO); nivel++; }

"//".*       { }

[ \n\r\t]    { } // ignore espaços em branco

[0-9]+  { return new Token(Token.NUM, yytext(), yyline); }

[pP][rR][iI][nN][tT]    { return new Token(Token.PRINT, yytext(), yyline); }

[a-zA-Z_][a-zA-Z0-9_]*    { return new Token(Token.ID, yytext(), yyline); }

"+"|[-]|;|[(]|[)]|[=] {
   return new Token(yytext().charAt(0), yytext(), yyline); }

}

<<EOF>>    { return new Token(Token.EOF, "<<EOF>>", yyline); }

.          { throw new RuntimeException("caractere inválido "+yytext()); }

