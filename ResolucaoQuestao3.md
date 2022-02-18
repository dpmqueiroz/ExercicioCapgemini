
# Exercicio Capgemini
Academia Java

## Links Uteis ( Documentação )

*[Questões](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/Questoes.md)

*[Resolução da 1ª Questão](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/ResolucaoQuestao1.md)

*[Resolução da 2ª Questão](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/ResolucaoQuestao2.md)

## Resoluçao da Questão 03

Na questão numero tres temos a seguinte informação como exemplo :

    entrada = ovo           ->          Saída = 3

Explicação
      
    A lista de todos os anagramas pares são: [o, o], [ov, vo] que estão nas posições [[0, 2], [0, 1], [1, 2]] respectivamente. 

### Porém o Correto seria

Entrada:

    entrada = ovo           ->          Saída = 2

Explicação
      
    A lista de todos os anagramas pares são: [o, o], [ov, vo] que estão nas posições [0, 2], [[0, 1], [1, 2]] respectivamente. 

Foi corrigido a saída do programa que deveria ser 2 e não 3, e também foi corrigido os colchetes que não estavam condizentes com os pares de anagrama das subStrings.

Agora vamos para o código para criar esse algorítmo. A primeira coisa que fiz foi criar uma função para ver se é anagrama ou não as duas subStrings, sendo assim criei uma função que recebe dois parâmetros, sendo as duas subStrings a serem comparadas, eu transformo essas Strings em um array de CHAR, e depois ordeno esses Arrays de CHAR utilizando o Array.sort . em seguinda eu uso Array.equals para comparar as duas subStrings e retornar um booleano.

~~~java
    public static boolean eAnagrama(String string1, String string2) {
		char[] string1char = string1.toCharArray();
		char[] string2char = string2.toCharArray();
		Arrays.sort(string1char);
		Arrays.sort(string2char);
		
		// Código Comentado para não poluir muito a saida do console, mas caso queira analisar todas as subStrings comparadas somente descomentar.
		//System.out.println("VOU COMPARAR '" + string1 + "' COM '" + string2 + "' Resultado foi = " + Arrays.equals(string1char, string2char));
		
		return Arrays.equals(string1char, string2char);
	}
~~~

Para Fins de visualização eu criei essa função que recebe o index da String e o intervalo para então conseguir devolver os valores certos de onde foram encontrados os anagramas.
~~~java
	public static String pegarPosicoesDaSubString(int valorInicial, int intervalo) {
		
		StringBuilder resposta = new StringBuilder();
		
		for(int contador = 0; contador < intervalo; contador++) {
			resposta.append((valorInicial + contador));
			
			if(contador != intervalo -1) {
				resposta.append(", ");
			}
		}
		
		return resposta.toString();
	}		
~~~

Tendo essa função de verificar se é anagrama ou não agora eu preciso criar uma função que receba como parametro a String que será analizada e preciso encontrar uma maneira para fazer meu algorítmo percorrer todas as hipóteses de subStrings, para isso eu criei tres variáveis, sendo elas, textoRecebido, parteTexto1 e parteTexto2.  O textoRecebido irá receber o parametro da função principal e ira colocar como .lowerCase , pois caso não seja feito isso podemos ter erro na função de verifar se é anagrama, pois letra maiúscula e minúscula são diferentes. Para percorrer minha String recebida eu criei três loops, responsáveis pelo intervalo das subStrings, valor da String1 e valor da String2, assim como mostra o exemplo abaixo:

~~~java
    public static int descobrirParesAnagramas(String texto) {
		
		String textoRecebido = texto.toLowerCase();
		String parteTexto1;
		String parteTexto2;	
		
		List<String> listaAnagramas = new ArrayList<String>();
	
		//Este loop controla o tamanho da subString, que começa com 1 e vai até tamanho do textoRecebido - 1
		for(int intervalo = 1; intervalo < textoRecebido.length(); intervalo++) {
			
			//Este Loop controla o valor da String1.
			for(int contString1 = 0; contString1 < textoRecebido.length(); contString1++) {
				
				//Esta estrutura de decisão impede que crie uma subString que vá além do que minha string permite, o que ocasionaria em um erro.
				if(contString1 + intervalo <= textoRecebido.length()) {
					parteTexto1 = textoRecebido.substring(contString1, contString1 + intervalo);				
				}else {
					continue;
				}
				
				//Este Loop controla o valor da String2, pois esse loop é responsável por alterar o valor da String2 e comparar com a String1 
				for(int contString2 = 0; contString2 < texto.length(); contString2++) {
					
					//Esta estrutura de decisão impede que crie uma subString que vá além do que minha string permite, o que ocasionaria em um erro.
					if(contString2 + intervalo <= textoRecebido.length()) {					
						parteTexto2 = textoRecebido.substring(contString2, contString2 + intervalo);
					}else {
						continue;
					}

					//Essa estrutura de decisão impede que eu compare a subString com ela mesmo, pois os loops estariam alinhados.
					if(contString1 != contString2) {
						
						//Esse estrutura de decisão verifica se é anagrama ou não, caso seja adiciona uma string na minha lista.
						if(eAnagrama(parteTexto1, parteTexto2))
							listaAnagramas.add("String1 '" + parteTexto1 + "' na posiçao [" + pegarPosicoesDaSubString(contString1, intervalo) + "] e "
									+ "String2 '" + parteTexto2 + "' na posiçao [" + pegarPosicoesDaSubString(contString2, intervalo) +"]");
						
					}
				}
			}
		}
		
		// Coloquei essa exibição para padronizar.
		System.out.println("\nVou imprimir o que achei sobre anagramas das subStrings de '"+ texto +"' : ");
		
		if(listaAnagramas.isEmpty()) {
			System.out.println("A palavra " + texto + " não possui nenhum par de anagrama.");
		}else {
			listaAnagramas.forEach((p) -> {
				System.out.println(p);
			});
			
			System.out.println("A palavra "+ texto + " possui "+ listaAnagramas.size() / 2 +"  par(es) de anagrama(s).");
		}
			
		// A Lista irá receber duas vezes o mesmo anagrama, por isso na hora de exibir eu divido por dois.
		return listaAnagramas.size() / 2;
		
	}		
~~~

Optei por deixar o código comentado para facilitar a compreensão da metodologia usada.

A saída desse código devolve a quantidade de pares de substrings que são anagramas, porém foi configurado para exibir na tela o seguinte resultado para facilitar o entendimento: 

	Vou imprimir o que achei sobre anagramas das subStrings de 'ovo' : 
	String1 'o' na posiçao [0] e String2 'o' na posiçao [2]
	String1 'o' na posiçao [2] e String2 'o' na posiçao [0]
	String1 'ov' na posiçao [0, 1] e String2 'vo' na posiçao [1, 2]
	String1 'vo' na posiçao [1, 2] e String2 'ov' na posiçao [0, 1]
	A palavra ovo possui 2  par(es) de anagrama(s).

	Vou imprimir o que achei sobre anagramas das subStrings de 'ifailuhkqq' : 
	String1 'i' na posiçao [0] e String2 'i' na posiçao [3]
	String1 'i' na posiçao [3] e String2 'i' na posiçao [0]
	String1 'q' na posiçao [8] e String2 'q' na posiçao [9]
	String1 'q' na posiçao [9] e String2 'q' na posiçao [8]
	String1 'ifa' na posiçao [0, 1, 2] e String2 'fai' na posiçao [1, 2, 3]
	String1 'fai' na posiçao [1, 2, 3] e String2 'ifa' na posiçao [0, 1, 2]
	A palavra ifailuhkqq possui 3  par(es) de anagrama(s).
