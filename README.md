Análise Léxica de MiniJava
==========================

Escreva um analisador léxico para
a linguagem MiniJava (http://www.dcc.ufrj.br/~fabiom/comp/minijava.html).
Para facilitar, esta pasta contém o esqueleto de um analisador
escrito usando o JFlex (http://jflex.de) que vocês podem apenas
completar e testar. O esqueleto está no arquivo `minijava.jflex`.

Vocês devem usar a classe Token para retornar os tokens necessários.

Bolar uma estratégia de testes para o analisador léxico também
é responsabilidade de vocês. Para facilitar estou fornecendo o
código Java do meu analisador (Scanner.java), que vocês podem
executar em casos de teste e comparar a saída dele com o do
seu analisador. Nem tentem fazer "engenharia reversa" do
Scanner.java para chegar na especificação, vai ser um esforço
jogado fora.

O arquivo `testscanner.kt` contém alguns testes não
exaustivos que exercitam o analisador léxico.


Análise Sintática de MiniJava
=============================

Esreva um analisador sintático para
a linguagem MiniJava (http://www.dcc.ufrj.br/~fabiom/comp/minijava.html).
Para facilitar, esta pasta contém o esqueleto de um analisador
escrito usando o JACC (http://web.cecs.pdx.edu/~mpj/jacc/) que vocês podem apenas
completar e testar. O esqueleto está no arquivo `minijava.jacc`. O
próprio JACC também está incluso, e consiste nos arquivos `jacc.bat`
e `jacc.jar`. Comentários `TODO` no esqueleto marcam os pontos que devem ser
completados.

A parte de expressões da gramática está quase completa; estão
faltando as classes de prioridade para poder eliminar os conflitos
shift-reduce que irão aparecer. A gramática de MiniJava que está
na página codifica as classes de precedência diretamente na gramática,
vocês terão que entender e reinterpretar isso para classes de precedência.
Lembre que MiniJava é uma linguagem com a ambiguidade do if-else.

A análise sintática deve gerar uma árvore sintática abstrata
para o programa, usando as classes que estão no arquivo `ast.kt`.
Depois de analisar o programa usando o método `parse`, a AST do
programa (uma instância de Prog) fica no campo `saida` do parser.
O método toString de de Prog reproduz o código fonte do programa,
a menos de espaços em branco e comentários.

O arquivo `testparser.kt` contém alguns casos de teste para o
analisador sintático.


