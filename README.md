Análise Léxica
==============

<pre>
              -----------               --------
             |           |             |        |
--entrada--> | *Scanner* | --tokens--> | Parser | --AST--> .eval() 
             |           |             |        |          .compile()
              -----------               --------
</pre>

A análise léxica é a primeira fase de um compilador ou 
interpretador, e serve para processar a entrada de modo
a tornar mais fácil e eficiente o trabalho da análise
sintática.

O analisador léxico quebra um programa em átomos da linguagem,
chamados de *tokens*. Cada token é composto da *classe* ou *tipo*
do token, mais seu valor, que normalmente é o próprio texto
do token.

Podemos especificar as regras de como classificar cadeias
de caracteres em classes de tokens para determinada linguagem
usando linguagem natural, como nos manuais, mas linguagem
natural é imprecisa, e ainda nos deixa o problema de como fazer
a quebra do programa em tokens de maneira eficiente. Por isso
costuma-se usar uma linguagem formal para especificar regras
de classificação de tokens: as *expressões regulares*.

1. Expressões Regulares
-----------------------

Expressões regulares são expressões algébricas que denotam
conjuntos de cadeias de caracteres. Assim como "2+3*4" é uma
expressão aritmética que denota o número 14, a expressão
regular "a0+" denota o conjunto { "a0", "a00", "a000", ... }.

A função lex.RE.findAll, usada abaixo, extrai de uma cadeia
de caracteres (no segundo argumento), todas as ocorrências
da expressão regular passada no primeiro argumento, em ordem:
ela procura a primeira ocorrência, depois procura a segunda
ocorrência no restante da string, depois a terceira no que
restou novamente, e assim por diante. Veja a implementação
no arquivo `re.kt`. Você pode usar o REPL Kotlin para
executar os comandos abaixo.

    lex.RE.findAll("a0+", "a0 fooa0005a0000a0 a00bar")
       => [a0, a000, a0000, a0, a00]		

    lex.RE.findAll("0", "a0 fooa0005a0000a0 a00bar")
       => [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		
    lex.RE.findAll(".", "a0 fooa0005a0000a0\n a00bar")
       => [a, 0,  , f, o, o, a, 0, 0, 0, 5, a, 0, 0, 0, 0, a, 0,  , a, 0, 0, b, a, r](java.util.ArrayList<E>) [a, 0,  , f, o, o, a, 0, 0, 0, 5, a, 0, 0, 0, 0, a, 0,  , a, 0, 0, b, a, r]

    lex.RE.findAll("[0-9]", "a0 fooa0005a0000a0\n a00bar")
       => [0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0]

    lex.RE.findAll("[\n ]", "a0 fooa0005a0000a0\n a00bar")
       => [ , 
          ,  ]
		
    lex.RE.findAll("[^\n ]", "a0 fooa0005a0000a0\n a00bar")
       => [a, 0, f, o, o, a, 0, 0, 0, 5, a, 0, 0, 0, 0, a, 0, a, 0, 0, b, a, r]		

    lex.RE.findAll("[^a-z0-9]", "a0 fooa0005a0000a0\n a00bar")
       => [ , 
          ,  ]		

    lex.RE.findAll("foo", "a0 fooa0005a0000a0\n a00bar")
       => [foo]

    lex.RE.findAll("[a-z][0-9]", "a0 fooa0005a0000a0\n a00bar")
       => [a0, a0, a0, a0, a0]

    lex.RE.findAll("...", "a0 fooa0005a0000a0\n a00bar")
       => [a0 , foo, a00, 05a, 000, 0a0,  a0, 0ba]

    lex.RE.findAll("\"[^\"\n]*\"", "a0 \"fooa\"0005a\"0000a0\n\" a\"00b\"ar")
       => ["fooa", " a"]

## Caracteres e classes de caracteres

São expressões regulares que denotam cadeias contendo apenas
um caractere. A expressão "." é especial e denota qualquer
caractere, enquanto colchetes podem ser usados para especificar
conjuntos e intervalos de caracteres. Veja os exemplos abaixo
(você pode executar as expressões abaixo no REPL Kotlin):

    lex.RE.findAll("a", "A linguagem JaVa") => [a, a, a]
    lex.RE.findAll(".", "A linguagem JaVa é um\t tanto verbosa") =>
        [A,  , l, i, n, g, u, a, g, e, m,  , J, a, V, a]
    lex.RE.findAll("[ag0-5]", "Linguagem 1982") => [g, a, g, 1, 2]
    lex.RE.findAll("[a-zA-Z]", "A linguagem JaVa") =>
       [A, l, i, n, g, u, a, g, e, m, J, a, V, a]
    lex.RE.findAll("[a-zA-Z0-9_]", "foo_123_bar abc 1982 ___") =>
       [f, o, o, _, 1, 2, 3, _, b, a, r, a, b, c, 1, 9, 8, 2, _, _, _]
    lex.RE.findAll("[.]", "A linguagem ... JaVa.")
      => [., ., ., .]

Um circunflexo logo após o colchete que abre uma classe
de caractere serve para denotar o *complemento* dessa classe:
		   
    lex.RE.findAll("[^a-zA-Z0-9_]", "abc _foo@ 123;$ a$ˆ% x_43_f#")
      => [ , @,  , ;, $,  , $, ˆ, %,  , #]

A justaposição, ou concatenação, de expressões regulares
permite formar expressões que denotam cadeias de vários
caracteres, onde cada caractere vem de uma das expressões
regulares que formam a concatenação:
		  
    lex.RE.findAll("[a-z][0-9]", "a b1 z34 a234 fa _foo") =>
      [b1, z3, a2]
    lex.RE.findAll("while", "while(true) { while(i<0) { i = i + 1;} }")
      => [while, while]
    lex.RE.findAll("while", "while(true) { WhiLe(i<0) { i = i + 1;} }")
      => [while]
    lex.RE.findAll("[wW][hH][iI][lL][eE]", 
		"while(true) { WhiLe(i<0) { i = i + 1;} }") =>
      [while, WhiLe]
    lex.RE.findAll("...", 
		"while(true) { WhiLe(i<0) { i = i + 1;} }") =>
      [whi, le(, tru, e) , { W, hiL, e(i, <0),  { , i =,  i , + 1, ;} ]
		  
O operador + denota uma sequência de uma ou mais repetições
dos caracteres da expressão que ele modifica:
		  
    lex.RE.findAll("[a-z]+","A linguagem JaVa") => [linguagem, a, a]
    lex.RE.findAll("[a-z][0-9]+", "a b1 a3b4 z34 a234 fa _foo")
      => [b1, a3, b4, z34, a234]
    lex.RE.findAll("[a-z0-9]+", "a b1 a3b4 z34 a234 fa _foo")
      => [a, b1, a3b4, z34, a234, fa, foo]
    lex.RE.findAll("[a-zA-Z_][a-zA-Z0-9_]+","abc _foo 123 a x_43_f")
      => [abc, _foo, x_43_f]
    lex.RE.findAll("[0-9]+", "a b1 a3b4 z34 a234 fa _foo")
      => [1, 3, 4, 34, 234]
    lex.RE.findAll("\"[^\"]+\"", "foo \"hello world\" \"xyz\"abc\"\"")
      => ["hello world", "xyz"]
		  
O operador * denota uma sequência de zero ou mais repetições
dos caracteres da expressão que ele modifica:
		  
    lex.RE.findAll("[a-zA-Z_][a-zA-Z0-9_]*","abc _ _foo 123 a x_43_f")
        => [abc, _, _foo, a, x_43_f]
    lex.RE.findAll("[0-9][0-9]*", "a b1 a3b4 z34 a234 fa _foo")
      => [1, 3, 4, 34, 234]
    lex.RE.findAll("[a-zA-Z_][a-zA-Z0-9_]*",
		"abc _foo@ 123;$ a$ˆ% x_43_f#")
      => [abc, _foo, a, x_43_f]
    lex.RE.findAll("\"[^\"]*\"",
		"abc 1\"23 -967\"  \"\"9a-\"2 .\"3 1.2\" #ˆ#ˆ$\"34z xyz")
      => ["23 -967", "", "2 .", " #ˆ#ˆ$"]

A barra (|) denota união dos conjuntos das expressões
regulares que estão no lado esquerdo e direito da mesma:
		  
    lex.RE.findAll("[a-zA-Z_][a-zA-Z0-9_]*|[0-9]+", 
    	"abc _foo 123 a x_43_f") => [abc, _foo, 123, a, x_43_f]

A ordem de precedência dos operadores é a seguinte
(do maior para o menor):
	
    + *
    <concatenação>
    |

Como nas expressões aritméticas, podemos usar parênteses para
mudar a precedência:

    lex.RE.findAll("([a-z][0-9])+", "a b1 a3b4 z34 a234 fa _foo") =>
    	[b1, a3b4, z3, a2]

Finalmente, o operador ? (mesma precedência de + e *) denota
uma expressão ou a ausência dela (zero ou uma vez, ou opcional):
			
    lex.RE.findAll("[0-9]+([.][0-9]+)?","abc 123.4 967 9a2 .3 1.2 34.34z xyz")
      => [123.4, 967, 9, 2, 3, 1.2, 34.34]
    lex.RE.findAll("[0-9]+(.[0-9]+)?","abc 123.4 967 9a2 .3 1.2 34.34z xyz")
      => [123.4, 967 9, 2, 3 1, 2 34, 34]
    lex.RE.findAll("-?[0-9]+","abc 123 -967 9a-2 .3 1.2 34z xyz")
      => [123, -967, 9, -2, 3, 1, 2, 34]

O uso de barras (|), parênteses e opcional pode complicar o
entendimento das expressões. Na prática, é mais legível reescrever
uma regra usando essas operações como uma sequência de várias
regras que classificam a mesma classe de token.

## Especificação de um fragmento de Java

As regras abaixo associam uma expressão regular a uma classe
de token. Note que são usados escapes (\) nos casos onde haveria
confusão entre o símbolo e um caractere especial das expressões.

    &&                      => E_LOGICO
    [|][|]                  => OU_LOGICO
    [+]                     => SOMA
    [+][+]                  => INC
    /                       => DIVISAO
    [.]                     => PONTO
    while                   => WHILE
    if                      => IF
    else                    => ELSE
    [a-zA-Z]                => ID
    [a-zA-Z_][a-zA-Z0-9_]+  => ID
    [0-9]+                  => NUM
    [0-9]+[.][0-9]+         => NUM
    [0-9]+[.]               => NUM
    [.][0-9]+               => NUM
    ["]["]                  => STRING
    ["][^"\n]+["]           => STRING

3. Ambiguidade
--------------

Uma especificação léxica como a feita acima é naturalmente ambígua.
Por exemplo, uma entrada como "123.4" pode ser tanto um token 
NUM (123.4), dois tokens NUM (123 e .4) ou um token NUM (123)
seguido de um PONTO e outro NUM (4).

A entrada "fora" pode ser tanto um token FOR e um token ID (a)
quanto um único ID (fora). A entrada "while" pode ser tanto um
token WHILE quanto um ID (while).

A resolução dessa ambiguidade é feitas nas implementações usando
duas regras simples. Primeiro dá-se prioridade à regra que casa
o maior número de caracteres em sequência. Isso resolve a maior
parte dos casos de ambiguidade, incluindo os dois primeiros acima
("123.4" seria classificado como um único NUM e "fora" como um
único ID).

Para os casos em que existem várias regras possíveis, todas casando
um token do mesmo tamanho, como no caso do "while", dá-se prioridade
à regra listada primeiro. Para a especificação acima isso seria
WHILE (while).

## Implementando o Scanner

Se temos a especificação léxica da linguagem em termos de regras
que associam uma expressão regular a um tipo de token, além de
uma regra para "espaços em branco", podemos usar a biblioteca de
expressões regulares de Java para implementar um scanner usando
um procedimento bem simples, assumindo que temos uma função
que tenta casar uma expressão regular com o *início* de uma
entrada, retornando o prefixo que foi casado (o possível corpo
do token) e o restante da entrada:
	
//  Casa espaços em branco enquanto puder usando a regra de espaço
    Inicializa corpo do token com "" e tipo com -1
    Inicializa o resto da entrada como a entrada
    Para cada regra, em ordem:
	    Tenta casar a expressão regular da regra
	    Se o prefixo casado é maior que o corpo do token que temos:
    		Prefixo casado passa a ser o corpo do token
    		Tipo associado à regra passa a ser o tipo do token
    		Resto da entrada passa a ser o resto desse casamento
    Se o corpo do token não é "":
    	Foi achado um token, retorna
    senão:
    	Erro na análise léxica, a entrada tem texto que não corresponde
    	a um token válido

Com uma implementação desse procedimento, como a em
ScannerRE.nextToken, podemos criar um analisador léxico
para o subconjunto de Java da seção 2:

    import lex.*
    // Scanner para um subconjunto de Java
    // Espaços em branco (não inclui comentários!)
    val space = "[ \n\r\t]"
    // Regras de tokenização (os números são os tipos de cada token)
    val rules = listOf(
        Rule("&&", 1),        // "e" lógico
        Rule("[|][|]", 2),    // "ou" lógico
        Rule("[+]", '+'.toInt()),     // soma
        Rule("/", '/'.toInt()),       // divisão
        Rule("[.]", '.'.toInt()),     // ponto (acesso a campos, por ex.)
        Rule("if", 4),        // palavra reservada if
        Rule("else", 5),      // palavra reservada else
        Rule("[+][+]",9),     // operador incremento
        Rule("[a-zA-Z]", 6),  // identificadores
        Rule("while", 3),     // palavra reservada while
        Rule("[a-zA-Z_][a-zA-Z0-9_]+", 6), // identificadores
        Rule("[0-9]+", 7),   // numerais
        Rule("[0-9]+[.][0-9]+", 7), // numerais
        Rule("[0-9]+[.]", 7), // numerais
        Rule("[.][0-9]+", 7), // numerais
        Rule("[\"][^\"\n]+[\"]", 8), // strings
        Rule("[\"][\"]", 8) // strings
    );
    val scan = ScannerRE(space, rules, "foo 1.2 .34 bar_34f "+
        "whilea while +\"olá mundo\" \"\"\nelse43 else &&|| ++_a.bar");
    scan.allTokens()
      => [Token(type=6, lexeme=foo), Token(type=7, lexeme=1.2), 
          Token(type=7, lexeme=.34), Token(type=6, lexeme=bar_34f), 
          Token(type=6, lexeme=whilea), Token(type=3, lexeme=while), 
          Token(type=43, lexeme=+), Token(type=8, lexeme="olá mundo"), 
          Token(type=8, lexeme=""), Token(type=6, lexeme=else43), 
          Token(type=5, lexeme=else), Token(type=1, lexeme=&&),
          Token(type=2, lexeme=||), Token(type=9, lexeme=++), 
          Token(type=6, lexeme=_a), Token(type=46, lexeme=.), 
          Token(type=6, lexeme=bar)]

Esse scanner funciona bem, mas tem dois problemas: primeiro, ele
depende de uma implementação de busca por expressões regulares,
e segundo, percorrer todo o conjunto de regras toda vez que se
precisa de um token não é nada eficiente.
