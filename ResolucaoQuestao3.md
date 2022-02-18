
# Exercicio Capgemini
Academia Java

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

Tendo essa função de verificar se é anagrama ou não agora eu preciso criar uma função que receba como parametro a String que será analizada e preciso encontrar uma maneira para fazer meu algorítmo percorrer todas as hipóteses de subStrings, para isso eu criei tres variáveis, sendo elas, textoRecebido, parteTexto1 e parteTexto2.  O textoRecebido irá receber o parametro da função principal e ira colocar como .lowerCase , pois caso não seja feito isso podemos ter erro na função de verifar se é anagrama, pois letra maiúscula e minúscula são diferentes. Para percorrer minha String recebida eu preciso criar 

~~~java
    public static int descobrirParesAnagramas(String texto) {
		
		String textoRecebido = texto.toLowerCase();
		String parteTexto1;
		String parteTexto2;	
		
		List<String> listaAnagramas = new ArrayList<String>();
	
		for(int intervalo = 1; intervalo < (textoRecebido.length()); intervalo++) {
			
			for(int contLetras = 0; contLetras < textoRecebido.length(); contLetras++) {
				
				if(contLetras + intervalo <= textoRecebido.length()) {
					parteTexto1 = textoRecebido.substring(contLetras, contLetras + intervalo);				
				}else {
					continue;
				}
				
				for(int contComparacao = 0; contComparacao < texto.length(); contComparacao++) {
					
					if(contComparacao + intervalo <= textoRecebido.length()) {					
						parteTexto2 = textoRecebido.substring(contComparacao, contComparacao + intervalo);
					}else {
						continue;
					}

					if(contLetras != contComparacao)
					 if(eAnagrama(parteTexto1, parteTexto2))
						 listaAnagramas.add("String1 '" + parteTexto1 + "' inicia na posiçao [" + contLetras + "] e String2 '" + parteTexto2 + "' inicia na posiçao [" + contComparacao +"]");
					
				}
				
			}
		}
		
		System.out.println("\nVou imprimir o que achei sobre anagramas : ");
		
		if(listaAnagramas.isEmpty()) {
			System.out.println("A palavra " + texto + " não possui nenhum par de anagrama.");
		}else {
			listaAnagramas.forEach((p) -> {
				System.out.println(p);
			});
			System.out.println("A palavra "+ texto + " possui "+ listaAnagramas.size() / 2 +"  par(es) de anagrama(s).");
		}
			
		return listaAnagramas.size() / 2;
		
	}
~~~
