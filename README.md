# Exercicio Capgemini
Academia Java

## Resoluçao da Questão 01

Criei um **método** para receber um inteiro que será a quantidade de degraus que terá a minha escada. Dentro do método eu criei três variáveis, uma para receber a quantidade de asteristicos, que será iniciada com o número 1, outra váriavel para receber a quantidade de espaços em branco, que irá receber o numero recebido como parâmetro da função - 1, e a ultima variável é quantidade de linhas, que recebe o parâmetro da funçao.

Fiz um Loop que acontecerá enquanto a quantidade de linhas for maior do que 0, dentro desse loop foi criado mais um loop que irá colocar a quantidade de espaços, e o outro loop irá colocar a quantidade de asterísticos, ao fim dos dois loops eu verifico se a quantidade de linhas, se for igual a 1 eu pulo uma linhha, modifico a quantidade de linhas, quantidade de espaços em branco e a quantidade de asteristicos e retorno para o loop, caso não eu encerro meu programa.

~~~java
	public static void geraEscada(int quantidadeDegraus) {
		int quantidadeDeAsteristicos = 1;
		int quantidadeDeLinhas = quantidadeDegraus;
		int quantidadeEspaçoEmBranco = quantidadeDegraus - quantidadeDeAsteristicos;
		
		while(quantidadeDeLinhas > 0) {
			
			for(int contador = 0 ; contador < quantidadeEspaçoEmBranco; contador++) {
				System.out.print(" ");
			}
			
			for(int contador = 0 ; contador < quantidadeDeAsteristicos; contador++) {
				System.out.print("*");
			}
			
			if(quantidadeDeLinhas == 1) {
				break;
			}else {				
				System.out.print("\n");
			}
			
			quantidadeDeAsteristicos++;
			quantidadeEspaçoEmBranco--;
			quantidadeDeLinhas--;
			
		}
	}
~~~
