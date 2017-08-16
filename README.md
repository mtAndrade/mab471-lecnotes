# Análise Sintática (Parsing)

                  ---------               ----------
                 |         |             |          |
    --entrada--> | Scanner | --tokens--> | *Parser* | --AST--> .eval() 
                 |         |             |          |          .compile()
                  ---------               ----------

Para compilar ou interpretar um programa de computador precisamos
primeiro colocar o programa em uma forma melhor de se trabalhar
do que uma simples sequência de caracteres. A primeira etapa para
isso foi feita na *análise léxica*, onde o analisador léxico
agrupou e classificou caracteres individuais em *tokens*:
identificadores, palavras-chave, numerais, operadores, etc.

Uma sequência de tokens tem mais estrutura e informação agregada
do que a sequência de caracteres do código fonte, mas ainda não
é o suficiente para o compilador. O próximo passo é agrupar esses
tokens em estruturas maiores, termos e operações da linguagem.
Essa é a função da *análise sintática*, feita pelo *parser*.

O parser recebe a sequência de tokens gerada pelo analisador
léxico e gera uma forma ainda mais estruturada do programa fonte,
sua árvore sintática abstrata (AST). A AST tem explícita toda
a estrutura sintática do programa fonte, contendo informação
suficiente para as fases de verificação de erros (análise
semântica) e geração de código ou interpretação.

Quebramos o problema da análise léxica na construção de uma 
especificação formal dos tokens da linguagem, junto com uma 
forma de transformar essa especificação em código executável,
seja manualmente, seja usando uma ferramenta como o JFlex.
Faremos o mesmo na análise sintática.

Para a análise léxica usamos as expressões regulares como nossa
notação para especificação. Expressões regulares são muito
úteis para descrever conjuntos de palavras, e por isso são
úteis na análise léxica. Para a análise sintática precisamos
de uma notação mais poderosa, que descreva conjuntos de 
programas inteiros, e descreva também a estrutura desses programas.
Vamos usar a notação das *gramáticas livres de contexto* (CFGs).

## CFGs

Uma gramática livre de contexto, ou apenas *gramática*, é um
conjunto de regras de reescrita onde temos uma palavra do lado
esquerdo e uma sequência de palavras do lado direito de
cada regra.

    sentença -> sujeito verbo
    sentença -> sujeito verbo objeto
    sujeito  -> substantivo
    sujeito  -> artigo substantivo
    artigo   -> artigo_def
    artigo   -> artigo_indef
    objeto   -> artigo substantivo

Todas as palavras que aparecem do lado esquerdo de uma regra
são os *não-terminais* da gramática, as outras palavras são
os *terminais*. Na gramática acima os não-terminais são 
"sentença", "sujeito", "artigo" e "objeto", e os terminais
são "verbo", "substantivo", "artigo_def" e "artigo_indef".

## Derivações

Dada uma frase contendo palavras de uma gramática, podemos
produzir uma nova frase escolhendo um dos não-terminais
que estão nela e substituindo-o pelo lado direito de uma das
regras em que esse não-terminal aparece. Por exemplo, se
temos a frase "sujeito verbo" podemos usar a regra
`sujeito -> artigo substantivo` para obter a frase
"artigo substantivo verbo".

   
    val g = parse.Grammar();
    g.rules("sentença", "sujeito verbo"); // 0
    g.rules("sentença", "sujeito verbo objeto"); // 1
    g.rules("sujeito", "substantivo"); // 2
    g.rules("sujeito", "artigo substantivo"); // 3
    g.rules("artigo", "artigo_def"); // 4
    g.rules("artigo", "artigo_indef"); // 5
    g.rules("objeto", "artigo substantivo"); // 6
    g.derive("sujeito verbo objeto", 6)
      => sujeito verbo artigo substantivo
		
Esse processo de reescrita é chamado de derivação, e é assim
que usamos uma gramática para produzir frases gramaticalmente
válidas. Escolhemos um dos não-terminais da gramática para ser
o *símbolo inicial*, e fazemos derivações dele até chegar em
uma frase contendo apenas terminais. Vamos usar a gramática
acima e "sentença" como símbolo inicial para derivar uma
frase válida:

    val g = parse.Grammar();
    g.rules("sentença", "sujeito verbo"); // 0
    g.rules("sentença", "sujeito verbo objeto"); // 1
    g.rules("sujeito", "substantivo"); // 2
    g.rules("sujeito", "artigo substantivo"); // 3
    g.rules("artigo", "artigo_def"); // 4
    g.rules("artigo", "artigo_indef"); // 5
    g.rules("objeto", "artigo substantivo"); // 6

    g.derivation("sentença", 1, 6, 5, 3, 4)
      => sentenÃ§a -1-> sujeito verbo objeto
             -6-> sujeito verbo artigo substantivo
             -5-> sujeito verbo artigo_indef substantivo
             -3-> artigo substantivo verbo artigo_indef substantivo
             -4-> artigo_def substantivo verbo artigo_indef substantivo
 
    g.derivation("sentença", 1, 3, 4, 6, 5);
      => sentenÃ§a -1-> sujeito verbo objeto
             -3-> artigo substantivo verbo objeto
             -4-> artigo_def substantivo verbo objeto
             -6-> artigo_def substantivo verbo artigo substantivo
             -5-> artigo_def substantivo verbo artigo_indef substantivo

As setas numeradas indicam quais regras foram usadas
na derivação da frase "substantivo verbo artigo_indef substantivo"
a partir de "sentença".

## Árvores de Parse

Para a análise sintática, os terminais serão os *tipos* de tokens,
e os não-terminais dão a estrutura sintática da linguagem. Para
facilitar a leitura, vamos escrever terminais como palavras
começando com minúsculas, e não-terminais como palavras todas
em maiúsculas, comumente abreviadas como uma só letra. Poderíamos
reescrever a gramática acima como (com "S" como símbolo inicial):

    S -> SJ verbo
    S -> SJ verbo O
    SJ -> substantivo
    SJ -> A substantivo
    A -> artigo_def
    A -> artigo_indef
    O -> artigo substantivo

A gramática acima produz um número *finito* de frases de terminais.
O mesmo conjunto de frases poderia ser gerado pela gramática abaixo:
 
    S -> substantivo verbo
    S -> artigo_def substantivo verbo
    S -> artigo_indef substantivo verbo
    S -> substantivo verbo artigo_def substantivo
    S -> substantivo verbo artigo_indef substantivo
    S -> artigo_def substantivo verbo artigo_def substantivo
    S -> artigo_def substantivo verbo artigo_indef substantivo
    S -> artigo_indef substantivo verbo artigo_def substantivo
    S -> artigo_indef substantivo verbo artigo_indef substantivo
 
No uso que fazemos de gramática, esse tipo de transformação
deve ser feito com cuidado. Embora a gramática acima valide
a mesma linguagem que a anterior (elas têm o mesmo conjunto
frases válidas), a *estrutura* que ela impõe às frases da
linguagem é bem diferente. 

Essa estrutura é dada pela derivação feita para se chegar até
a frase. Uma outra forma de representarmos derivações é usando
uma estrutura em árvore, a *árvore de parse*. A aplicação
de uma regra da gramática faz o nó correspondente ao
não-terminal do lado esquerdo da regra ganhar as palavras do
lado direito como filhos. 

É mais fácil mostrar um exemplo. O arquivo frase1_g1.png tem
a árvore de parse para a derivação da frase "substantivo verbo
artigo_indef substantivo" pela primeira gramática que vimos.
A última gramática acima produz uma árvore de parse bem
diferente, como pode ser visto no arquivo frase1_g2.png.

4. Recursão e Repetição
-----------------------

Gramáticas mais interessantes, como as de linguagens de programação,
possuem regras *recursivas*, que permitem produzir um número
infinito de frases válidas. Veja por exemplo a gramática abaixo:

    /*
    0: E -> E + num
    1: E -> num
    	
    Em expressão regular: num (+ num)*
    Em geral:
    A -> A x y z ...
    A -> a b c ...
      isso é: a b c ... (x y z ...)*
    */
    val g = parse.Grammar();
    g.rules("E", "E + num"); // 0
    g.rules("E", "num"); // 1
    g.derivation("E", 0, 0, 0, 0, 1)
      => E -0-> E + num
       -0-> E + num + num
       -0-> E + num + num + num
       -0-> E + num + num + num + num
       -1-> num + num + num + num + num

A recursão na regra 0 permite que a apliquemos um número arbitrário
de vezes, de modo a obter frases cada vez maiores. Com isso podemos
expressar repetição em uma gramática. A árvore de parse para a
derivação acima é bem interessante (exp1_g1.png).

Repetição pode ser feita tanto com uma regra recursiva à esquerda
como a regra acima, quanto uma regra à direita:

    /*
    0: E -> num + E
    1: E -> num
    		
    Em expressão regular: (num +)* num
    Em geral:
    A -> x y z ... A
    A -> a b c ...
      isso é: (x y z ...)* a b c ...
    */
    val g = parse.Grammar();
    g.rules("E", "num + E");
    g.rules("E", "num");
    g.leftDerivation("E", 0, 0, 0, 0, 1)
      => E -0-> num + E
           -0-> num + num + E
           -0-> num + num + num + E
           -0-> num + num + num + num + E
           -1-> num + num + num + num + num

Veja a diferença entre as árvores de parse produzidas por
essas duas gramáticas comparando exp1_g1.png com exp1_g2.png,
embora as frases produzidas tenham sido as mesmas.

## Estruturas Aninhadas

Gramáticas não se limitam a expressar repetição. Como um
uso recursivo de um não-terminal pode aparecer em qualquer
lugar de uma frase, podemos usar gramáticas para expressar
qualquer tipo de estrutura aninhada: expressões com parênteses,
blocos, declarações aninhadas, etc.

Como um exemplo, a gramática a seguir expressa comentários
aninhados, algo que vimos ser impossível de expressar usando
expressões regulares. Os terminais /* e */ são os delimitadores
de início e fim de comentário, e o terminal "texto" é qualquer
coisa dentro de um comentário que não seja um comentário aninhado:

    /*
    0: S -> /* C */
     Um comentário é /* seguido do corpo do comentário e um */
    1: C -> texto C
     O corpo do comentário texto,
    2: C -> S C
     ou um comentário aninhado, repetindo
    3: C -> 
     O corpo também pode ser vazio
     
    Em "expressão regular": S -> /* (texto | S)* */
     
    */
    val g = parse.Grammar();
    g.rules("S", "/* C */");
    g.rules("C", "texto C");
    g.rules("C", "S C");
    g.rules("C", "");
    g.leftDerivation("S",0,1,2,1,2,1,3,0,3,2,0,2,0,3,3)
    => S -0-> /* C */
         -1-> /* texto C */
         -2-> /* texto S C */
         -1-> /* texto S texto C */
         -2-> /* texto S texto S C */
         -1-> /* texto S texto S texto C */
         -3-> /* texto S texto S texto  */
         -0-> /* texto /* C */ texto S texto  */
         -3-> /* texto /*  */ texto S texto  */
         -2-> /* texto /*  */ texto S texto  */
         -0-> /* texto /*  */ texto /* C */ texto  */
         -2-> /* texto /*  */ texto /* S C */ texto  */
         -0-> /* texto /*  */ texto /* /* C */ C */ texto  */
         -3-> /* texto /*  */ texto /* /*  */ C */ texto  */
         -3-> /* texto /*  */ texto /* /*  */  */ texto  */

Acima vemos uma derivação para um comentário complexo com
vários níveis de aninhamento. Outro exemplo de estrutura
aninhada é a gramática abaixo, que adiciona expressões com
parênteses à gramática de somatórios `E->E+num E->num`:

    /*
    0: E -> E + T
    1: E -> T
       em "expressão regular": E -> T (+ T)*
    2: T -> num
    3: T -> ( E )
    */
    val g = parse.Grammar();
    g.rules("E", "E + T"); // 0
    g.rules("E", "T");           // 1
    g.rules("T", "num");         // 2
    g.rules("T", "( E )"); // 3
    g.derivation("E", 0, 1, 2, 3, 0, 1, 2, 2);
      => E -0-> E + T
           -1-> T + T
           -2-> num + T
           -3-> num + ( E )
           -0-> num + ( E + T )
           -1-> num + ( T + T )
           -2-> num + ( num + T )
           -2-> num + ( num + num )

Vejam a árvore de parse correspondente à derivação acima
no arquivo exp2.png. A estrutura da árvore induz o compilador
ou interpretador a primeiro obter o resultado da segunda soma
(que está entre parênteses), para depois efetuar a primeira
soma. Compare com exp1_g1.png, onde a árvore induz às somas
serem feitas da esquerda para a direita.
       
## Ambiguidade

Vamos ver agora o que acontece quando reescrevemos a gramática
acima para não precisar mais do não-terminal T, ficando da forma
abaixo, e mostrando duas derivações para a frase "num + num + num":

    /*
    0: E -> E + E
    1: E -> num
    2: E -> ( E )
    */
    val g = parse.Grammar();
    g.rules("E", "E + E");
    g.rules("E", "num");
    g.rules("E", "( E )");
    g.derivation("E", 0, 1, 0, 1, 1)
      => E -0-> E + E
           -1-> num + E
           -0-> num + E + E
           -1-> num + num + E
           -1-> num + num + num

    g.derivation("E", 0, 0, 1, 1, 1)
      => E -0-> E + E
           -0-> E + E + E
           -1-> num + E + E
           -1-> num + num + E
           -1-> num + num + num

Essas duas derivações produzem duas árvores de parse diferentes,
exp3_1.png e exp3_2.png. Notem a diferença entre as duas árvores.
A primeira induz o compilador a fazer primeiro a soma da direita,
e a segunda induz o compilador a fazer primeiro a soma da esquerda.

Adição é uma operação associativa, então tanto faz a ordem em que
fazemos as somas, e as duas árvores produziriam o mesmo resultado.
Mas se a operação fosse uma subtração teríamos a gramática produzindo
uma árvore para a frase "num - num - num" que geraria um resultado
incorreto. 

    val g = parse.Grammar();
    g.rules("E", "E - E"); // 0
    g.rules("E", "num");         // 1
    g.leftDerivation("E", 0, 1, 0, 1, 1)
      => E -0-> E - E
           -1-> num - E
           -0-> num - E - E
           -1-> num - num - E
           -1-> num - num - num,
    g.leftDerivation("E", 0, 0, 1, 1, 1)
      =>  E -0-> E - E
            -0-> E - E - E
            -1-> num - E - E
            -1-> num - num - E
            -1-> num - num - num

Se os números fossem respectivamente 3, 1 e 4, por
exemplo, a árvore exp4_1.png daria 9 (3-(1-4)) para 3-1-4, enquanto
exp4_2.png daria -2, como esperado ((3-1)-4).

Qualquer gramática capaz de produzir duas árvores de parse para
a mesma frase é chamada de *ambígua*. Ambiguidade é um problema
em gramáticas de linguagens de programação pois ela pode introduzir
inconsistência entre diferentes compiladores, ou mesmo falhas,
como ocorreria se um compilador usasse a árvore de parse de
exp4_1.png com uma operação de subtração de três termos.

Veremos mais à frente que o significado de um programa está
intimamente ligado à sua árvore sintática abstrata, e a AST
está intimamente ligada à árvore de parse gerada para a gramática,
logo uma gramática ambígua leva a programas que podem ser
interpretado de várias maneiras diferentes, um comportamento
claramente indesejável.

Um exemplo muito comum de gramática ambígua é a gramática
de operações binárias, como a gramática abaixo para as
quatro operações aritméticas:

    /*
    0: E -> E + E
    1: E -> E - E
    2: E -> E * E
    3: E -> E / E
    4: E -> num
    5: E -> ( E )
    */
    val g = parse.Grammar();
    g.rules("E", "E + E");
    g.rules("E", "E - E");
    g.rules("E", "E * E");
    g.rules("E", "E / E");
    g.rules("E", "num");
    g.rules("E", "( E )");
    g.leftDerivation("E", 0, 4, 2, 4, 4)
      => E -0-> E + E
           -4-> num + E
           -2-> num + E * E
           -4-> num + num * E
           -4-> num + num * num
    g.leftDerivation("E", 2, 0, 4, 4, 4)
      => E -2-> E * E
           -0-> E + E * E
           -4-> num + E * E
           -4-> num + num * E
           -4-> num + num * num
     
A ambiguidade dessa gramática vem do fato dela não determinar
a associatividade nem precedência das operações que ela
especifica. As duas árvores do exemplo acima (exp5_g1.png e
exp5_2_g1.png) são árvores de parse para a expressão
"num + num * num", mas expressam precedências diferentes. Em
uma a operação de * tem precedência sobre +, como na aritmética,
enquanto na outra + tem precedência.

Para corrigir a ambiguidade de uma gramática de operações
binárias precisamos dividir as operações em classes de precedência,
substituindo a recursão à direita em cada nível pelo não-terminal
do nível acima. 

A gramática acima pode ser escrita sem ambiguidade
e respeitando as regras de precedência e associatividade dos
operadores usando três níveis, o mais baixo para expressões
aditivas, o intermediário para expressões multiplicativas, e
o mais alto para expressões unárias. O resultado é a gramática
abaixo:

    /*
    0: E -> E + T
    1: E -> E - T
    2: E -> T

      Em "expressões regulares": E -> T (+ T | - T)*
    
    3: T -> T * F
    4: T -> T / F
    5: T -> F
    
      Em "expressões regulares": T -> F (* F | / F)*
    
    7: F -> num
    8: F -> ( E )
    */
    val g = parse.Grammar();
    g.rules("E", "E + T");
    g.rules("E", "E - T");
    g.rules("E", "T");
    g.rules("T", "T * F");
    g.rules("T", "T / F");
    g.rules("T", "F");
    g.rules("F", "num");
    g.rules("F", "( E )");
    g.computeSets();
    g.leftDerivation("E", 0, 2, 5, 6, 3, 5, 6, 6)
      => E -0-> E + T
           -2-> T + T
           -5-> F + T
           -6-> num + T
           -3-> num + T * F
           -5-> num + F * F
           -6-> num + num * F
           -6-> num + num * num
    g.print()
      => 0: E -> E + T [num, (]
         1: E -> E - T [num, (]
         2: E -> T [num, (]
         3: T -> T * F [num, (]
         4: T -> T / F [num, (]
         5: T -> F [num, (]
         6: F -> num  [num]
         7: F -> ( E )  [(]
    
Veja no arquivo "exp5_g2.png" a árvore que essa gramática gera
para "num + num * num", e como essa árvore codifica a precedência
correta entre essas duas operações.

Da mesma forma que fizemos para a gramática das quatro operações
aritméticas, a técnica acima pode ser usada para se criar gramáticas
sem ambiguidade para quaisquer conjunto de operações binárias e
unárias, com qualquer número de classes de precedência.

Um terceiro caso de ambiguidade bastante comum é o "dangling else",
ou ambiguidade do else, onde a mistura de ifs sem else e ifs com
else pode levar a uma ambiguidade quanto a qual if um else se
refere.

Pense no programa "if exp then if exp then print else print".
O comando "print" da cláusula "else" é executado quando
a primeira "exp" é falsa (ou seja, ele pertence ao if externo)
ou quando ela é verdadeira e a segunda "exp" é falsa (ou
seja, pertence ao if interno)? 

Ao contrário da associatividade e precedência de operações, aqui
não temos uma regra já estabelecida para nos guiar, então fica
a cargo do projetista da linguagem. A convenção que C e Java
usam é fazer o else pertencer ao if mais interno.

A gramática a seguir é um fragmento de uma gramática de comandos
que expressa a ambiguidade do else. Ela permite derivar o programa
acima, mas de maneira ambígua:

    /*
    0: C -> if exp then C else C
    1: C -> if exp then C
    2: C -> { LC }
    3: C -> print
    4: LC -> C LC
    5: LC ->
    */
    val g = parse.Grammar();
    g.rules("C", "if exp then C else C");
    g.rules("C", "if exp then C");
    g.rules("C", "{ LC }");
    g.rules("C", "print");
    g.rules("LC", "C LC");
    g.rules("LC", "");
    g.leftDerivation("C", 0, 1, 3, 3)
    => C -0-> if exp then C else C
     -1-> if exp then if exp then C else C
     -3-> if exp then if exp then print else C
     -3-> if exp then if exp then print else print
    g.leftDerivation("C", 1, 0, 3, 3)
    => C -1-> if exp then C
     -0-> if exp then if exp then C else C
     -3-> if exp then if exp then print else C
     -3-> if exp then if exp then print else print

As árvores de parse "dangif_1.png" e "dangif_2.png" são duas
árvores de parse para o programa "if exp then if exp then print
else print", provando que a gramática é ambígua.

A solução da ambiguidade do else é parecida com a solução
da ambiguidade nas gramáticas de operações. Temos que separar
a gramática em três níveis, e dentro da cláusa "then" de um 
comando if com else eu não posso ter um if sem o "else"
correspondente. A gramática a seguir mostra uma solução, 
e a árvore "dangif_3.png" mostra como é a (única) árvore 
de parse que essa gramática gera para o programa exemplo:

    /*
    0: C1 -> if exp then C1
    1: C1 -> if exp then C2 else C1
    2: C1 -> C3
    3: C2 -> if exp then C2 else C2
    4: C2 -> C3
    5: C3 -> { LC }
    6: C3 -> print
    7: LC -> C1 LC
    8: LC ->
    
    Programas:
      if exp then print
      print
      { print print if exp then { } }
      if exp then print else print
      if exp then if exp then print else print

    */
    val g = parse.Grammar();
    g.rules("C1", "if exp then C1");
    g.rules("C1", "if exp then C2 else C1");
    g.rules("C1", "C3");
    g.rules("C2", "if exp then C2 else C2");
    g.rules("C2", "C3");
    g.rules("C3", "{ LC }");
    g.rules("C3", "print");
    g.rules("LC", "C1 LC");
    g.rules("LC", "");
    g.leftDerivation("C1", 0, 1, 4, 6, 2, 6)
    => C1 -0-> if exp then C1
    -1-> if exp then if exp then C2 else C1
    -4-> if exp then if exp then C3 else C1
    -6-> if exp then if exp then print else C1
    -2-> if exp then if exp then print else C3
    -6-> if exp then if exp then print else print

Outra maneira de resolver a ambiguidade do else é simplesmente
deixá-la na gramática, e resolvê-la no *parser*. Todas as
implementações de métodos do parsing possuem certa tolerância
a gramáticas ambíguas, e heurísticas simples para resolver
ambiguidade que funcionam do jeito esperado no caso da ambiguidade
do else. 

Um outro jeito é usar uma marca para o final do comando
if, como "endif", o que torna o programa original não-ambíguo:
	
    if exp then if exp then print else print endif endif
    if exp then if exnp then print endif else print endif

No primeiro está claro que o else pertence ao if interno, no
segundo está claro que pertence ao if externo. Incluir as marcas
"endif" na primeira gramática de comandos acima nos dá uma
gramática não ambígua.

