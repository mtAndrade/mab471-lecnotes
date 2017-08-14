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
   .|[\n]       {}
}

<YYINITIAL> {

"/*"         { yybegin(COMENTARIO); nivel++; }

"//".*       { }

[ \n\r\t]    { } // ignore espaços em branco

[0-9]+  { return new Token(1, yytext(), yyline); }

[pP][rR][iI][nN][tT]    { return new Token(3, yytext(), yyline); }

[a-zA-Z_][a-zA-Z0-9_]*    { return new Token(2, yytext(), yyline); }

"+"|[-]|;|[(]|[)]|[=] {
   return new Token(yytext().charAt(0), yytext(), yyline); }

}

<<EOF>>    { return new Token(0, "<<EOF>>", yyline); }

.          { throw new RuntimeException("caractere inválido "+yytext()); }

