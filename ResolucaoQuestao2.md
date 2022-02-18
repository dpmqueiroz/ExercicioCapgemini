# Exercicio Capgemini
Academia Java

## Resoluçao da Questão 02

Para Resolver a segunda questão eu criei várias funções, para não criar uma única função contendo tudo. Para cada regra de negócio eu criei uma função que retorna um booleano que responde a pergunta.

~~~java
	public static boolean validaMinimoSeisCaracteres(String senha){
		if(senha.length() <= 5) {
			return false;
		}else {
			return true;
		}
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

Apos criar essas funçoes para validar algumas exigências na senha eu criei a função principal que irá chamar todas essas funçoes e retornar uma String confirmando se a senha é forte, ou avisando qual regra de negócio ela não atingiu.

~~~java
		public static String validaSenha(String senha){
		
		StringBuilder resposta = new StringBuilder();
		
		if(!validaMinimoSeisCaracteres(senha)) {
			resposta.append("\n- A senha deve possuir no mínimo 6 caracteres. Você deve acrescentar mais " + (6 - senha.length()) + " caracter(es).");
		}
		
		if(!contemUmDigito(senha)) {
			resposta.append("\n- A senha deve possuir no mínimo 1 dígito. Exemplo : '123456789'.");
		}
		
		if(!contemLetraMinuscula(senha)) {
			resposta.append("\n- A senha deve possuir no mínimo UMA letra minúscula.");
		}
		
		if(!contemLetraMaiuscula(senha)) {
			resposta.append("\n- A senha deve possuir no mínimo UMA letra maiúscula.");
		}
		
		if(!contemCaractereEspecial(senha)) {
			resposta.append("\n- A senha deve possuir no mínimo UM caracter especial. Exemplo : '!@#$%^&*()-+'");
		}
		
		if(resposta.isEmpty()) {
			resposta.append("- Senha considerada FORTE.");
			return resposta.toString();
		}
		
		return resposta.toString();
	}
~~~


