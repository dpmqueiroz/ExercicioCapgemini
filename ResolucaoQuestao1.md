# Exercicio Capgemini
Academia Java

## Links Uteis ( Documentação )

*[Questões](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/Questoes.md)

*[Resolução da 2ª Questão](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/ResolucaoQuestao2.md)

*[Resolução da 3ª Questão](https://github.com/dpmqueiroz/ExercicioCapgemini/blob/main/ResolucaoQuestao3.md)

## Resoluçao da Questão 01

Criei um método para receber um inteiro que será a quantidade de degraus que terá a minha escada. Dentro do método eu criei três variáveis, uma para receber a quantidade de asteriscos, que será iniciada com o número 1, outra váriavel para receber a quantidade de espaços em branco, que irá receber o numero recebido como parâmetro da função - 1, e a ultima variável é quantidade de linhas, que recebe o parâmetro da funçao.

Fiz um Loop que acontecerá enquanto a quantidade de linhas for maior do que 0, dentro desse loop foi criado mais um loop que irá colocar a quantidade de espaços, e o outro loop irá colocar a quantidade de asteriscos, ao fim dos dois loops eu verifico se a quantidade de linhas, se for igual a 1 eu pulo uma linhha, modifico a quantidade de linhas, quantidade de espaços em branco e a quantidade de asteriscos e retorno para o loop, caso não eu encerro meu programa.

~~~java
	public static void geraEscada(int quantidadeDegraus) {
		int quantidadeDeAsteriscos = 1;
		int quantidadeDeLinhas = quantidadeDegraus;
		int quantidadeEspacoEmBranco = quantidadeDegraus - quantidadeDeAsteriscos;
		
		while(quantidadeDeLinhas > 0) {
			
			for(int contador = 0 ; contador < quantidadeEspacoEmBranco; contador++) {
				System.out.print(" ");
			}
			
			for(int contador = 0 ; contador < quantidadeDeAsteriscos; contador++) {
				System.out.print("*");
			}
			
			if(quantidadeDeLinhas == 1) {
				break;
			}else {				
				System.out.print("\n");
			}
			
			quantidadeDeAsteriscos++;
			quantidadeEspacoEmBranco--;
			quantidadeDeLinhas--;	
		}
	}
~~~

Aqui um exemplo do retorno dessa função caso a quantidade degraus (n) seja igual a 8 

           *
          **
         ***
        ****
       *****
      ******
     *******
    ********
