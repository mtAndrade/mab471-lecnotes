# Autômatos

Para implementar o scanner de maneira mais eficiente vamos usar
*autômatos finitos determinísticos* (AFD), ou máquinas de estado.
Vamos ver como expressões regulares têm uma representação natural
e eficiente como AFDs, e vamos usar essa representação como base
para a implementação de um scanner.

Um AFD tem um conjunto de estados e transições entre esses
estados. Um dos estados é o estado inicial, no qual o AFD
inicia sua execução. Um subconjunto desses estados são os estados
finais, que marcamos com uma *tag* indicando qual o tipo de
token correspondente. Para as transições usamos conjuntos de
caracteres, que correspondem às expressões regulares mais
simples (caracteres, classes de caracteres, .).

Sempre que um AFD está em um estado s_i, verificamos todas
as transições saindo de s_i, checando se o próximo caractere
da entrada está no conjunto de uma das transições. Se estiver
adicionamos o caractere ao token atual, avançamos um caractere,
e passamos para o novo estado. Caso nenhuma das transições se
aplique temos duas possibilidades: se o estado for final
retornamos o token atual com o tipo da tag desse estado, e se
o estado não for final sinalizamos um erro de caractere
inválido na entrada.

A construção do autômato correspondente às regras da
especificação léxica normalmente é feita usando-se os algoritmos
de conversão de expressões regulares em autômatos finitos
*não*-determinísticos e conversão de autômatos não-determinísticos
em determinísticos, com pequenas extensões para manter as *tags*
nos estados finais. Em particular, caso o algoritmo de conversão
leve um estado final a ter duas possíveis tags, ganha a tag cuja
regra aparece primeiro.

Para um analisador léxico escrito à mão, é mais simples
tentar construir diretamente um AFD a partir das expressões
da especificação, usando as heurísticas vistas em sala. Também
é comum adotar atalhos que reduzem a ambiguidade da especificação,
como juntar as regras de reconhecimento de palavras-chaves com
as regras de reconhecimento de identificadores, e fazer
a identificação das palavras-chaves consultando uma tabela.

Os arquivos `calc.png` e `java.png` incluídos nesse projeto são
os AFDs para reconhecimento de tokens das linguagens de
expressões aritméticas e o subconjunto de Java acima,
respectivamente, construídos de acordo com as heurísticas
mostradas em sala. Na prática, usaríamos o AFD `java_simp.png`
para o subconjunto de Java, juntando palavras reservadas e
identificadores.

A classe ScannerDFA implementa scanners baseados em AFDs,
mas não faz a conversão de expressões regulares para AFDs.
Poderíamos criar um analisador léxico para a linguagem
de comandos simples a partir do AFD `calc.png` usando
o código a seguir:

    import lex.ScannerDFA
    val scan = ScannerDFA(15);
    scan.rule(0, "[ \r\n\t]", 0);
    scan.rule(0, "[0-9]", 1); scan.rule(1, "[0-9]", 1); scan.type(1, 1); // NUM
    scan.rule(0, "[(]", 2); scan.type(2, '(');
    scan.rule(0, "[)]", 3); scan.type(3, ')');
    scan.rule(0, "[+]", 4); scan.type(4, '+');
    scan.rule(0, "[-]", 5); scan.type(5, '-');
    scan.rule(0, "[=]", 13); scan.type(13, '=');
    scan.rule(0, "[;]", 14); scan.type(14, ';');
    scan.rule(0, "[pP]", 6); scan.type(6, 2); // ID
    scan.rule(6, "[rR]", 7); scan.type(7, 2); // ID
    scan.rule(7, "[iI]", 8); scan.type(8, 2); // ID
    scan.rule(8, "[nN]", 9); scan.type(9, 2); // ID
    scan.rule(9, "[tT]", 10); scan.type(10, 3); // PRINT
    scan.rule(10, "[a-zA-Z]", 11); scan.type(11, 2); // ID
    scan.rule(11, "[a-zA-Z]", 11);
    scan.rule(0, "[a-oq-zA-Z]", 11);
    scan.rule(6, "[a-qs-zA-Z]", 11);
    scan.rule(7, "[a-hj-zA-Z]", 11);
    scan.rule(8, "[a-mo-zA-Z]", 11);
    scan.rule(9, "[a-su-zA-Z]", 11);
    scan.rule(0, "<<EOF>>", 12); scan.type(12, lex.Token.EOF);
    scan.setInput("xy = 10;\ny = 5;\nPriNt x - (y-2) - 5;\n");
    scan.allTokens();
       => [Token(type=2, lexeme=xy), Token(type=61, lexeme==), 
           Token(type=1, lexeme=10), Token(type=59, lexeme=;), 
           Token(type=2, lexeme=y), Token(type=61, lexeme==), 
           Token(type=1, lexeme=5), Token(type=59, lexeme=;), 
           Token(type=3, lexeme=PriNt), Token(type=2, lexeme=x), 
           Token(type=45, lexeme=-), Token(type=40, lexeme=(), 
           Token(type=2, lexeme=y), Token(type=45, lexeme=-), 
           Token(type=1, lexeme=2), Token(type=41, lexeme=)), 
           Token(type=45, lexeme=-), Token(type=1, lexeme=5), 
           Token(type=59, lexeme=;)]

Uma implementação mais eficiente de um scanner baseado em
AFDs usa código especializado para cada estado:
	
    import lex.ScannerCalc
    import java.io.StringReader
    val scan = ScannerCalc(StringReader("2 + (3*5) -\n 42/2"));
    scan.allTokens();
      => [Token(type=1, lexeme=2), Token(type=43, lexeme=+), 
          Token(type=40, lexeme=(), Token(type=1, lexeme=3), 
          Token(type=42, lexeme=*), Token(type=1, lexeme=5), 
          Token(type=41, lexeme=)), Token(type=45, lexeme=-), 
          Token(type=1, lexeme=42), Token(type=47, lexeme=/), 
          Token(type=1, lexeme=2)]
          
