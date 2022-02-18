
# Exercicio Capgemini
Academia Java

## Resoluçao da Questão 03

Na questão numero tres temos as seguintes informações como exemplo :


~~~java
	public static boolean contemCaractereEspecial(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			
			if(!Character.isAlphabetic(senha.charAt(c)) && !Character.isDigit(senha.charAt(c)) ) {
				return true;
			}
		}
		return false;
	}
~~~

~~~java
	public static boolean contemUmDigito(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isDigit(senha.charAt(c))){
				return true;
			}
		}
		return false;
	}
~~~
~~~java
	public static boolean contemLetraMaiuscula(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isUpperCase(senha.charAt(c))) {
				return true;
			}
		}
		return false;
	}
~~~
~~~java
	public static boolean contemLetraMinuscula(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isLowerCase(senha.charAt(c))) {
				return true;
			}
		}
		return false;
	}
~~~
~~~java
	public static boolean contemCaractereEspecial(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			
			if(!Character.isAlphabetic(senha.charAt(c)) && !Character.isDigit(senha.charAt(c)) ) {
				return true;
			}
		}
		return false;
	}
~~~

Apos criar essas funçoes para validar algumas exigências na senha eu criei a função principal que irá chamar todas essas funçoes e retornar um int confirmando se a senha é forte, ou avisando qual regra de negócio ela não atingiu.

status :

      -  -1 = possui as 6 letras que são minimas porém violou alguma regra de négocio que será exibida utilizando System.Out.PrintLn.
      -  0 = Sucesso a senha é forte
      -  0 até 6 = quantas letras são necessárias para para atingir o mínimo de 6 letras
      
A seguir segue o código que chama as demais funções e retorna o inteiro referente a tabela acima:

~~~java
	public static int validaSenha(String senha){
		
		System.out.println("\nRESULTADO para senha '" + senha + "' ->  ");
		StringBuilder resposta = new StringBuilder();
		int resultado = 0;
		
		if(senha.length() < 6) {
			System.out.println(("- A senha deve possuir no mínimo 6 caracteres. Você deve acrescentar mais " + (6 - senha.length()) + " caracter(es)."));
			return 6 - senha.length();	
		}
		
		if(!contemUmDigito(senha)) {
			resultado = -1;
			resposta.append("\n- A senha deve possuir no mínimo 1 dígito. Exemplo : '123456789'.");
		}
		
		if(!contemLetraMinuscula(senha)) {
			resultado = -1;
			resposta.append("\n- A senha deve possuir no mínimo UMA letra minúscula.");
		}
		
		if(!contemLetraMaiuscula(senha)) {
			resultado = -1;
			resposta.append("\n- A senha deve possuir no mínimo UMA letra maiúscula.");
		}
		
		if(!contemCaractereEspecial(senha)) {
			resultado = -1;
			resposta.append("\n- A senha deve possuir no mínimo UM caracter especial. Exemplo : '!@#$%^&*()-+'");
		}
		
		if(resposta.isEmpty()) {
			System.out.println(("- Senha considerada FORTE."));
			return resultado;
		}else {
			System.out.print(resposta.toString() + "\n");
			return resultado;
		}
		
	}
~~~


