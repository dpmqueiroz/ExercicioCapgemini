package com.capgemini.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CapgeminiUtils {

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
	
	public static boolean contemUmDigito(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isDigit(senha.charAt(c))){
				return true;
			}
		}
		return false;
	}
	
	public static boolean contemLetraMinuscula(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isLowerCase(senha.charAt(c))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean contemLetraMaiuscula(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			if(Character.isUpperCase(senha.charAt(c))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean contemCaractereEspecial(String senha) {
		
		for(int c = 0; c < senha.length(); c++) {
			
			if(!Character.isAlphabetic(senha.charAt(c)) && !Character.isDigit(senha.charAt(c)) ) {
				return true;
			}
		}
		return false;
	}
	
	public static int descobrirParesAnagramas(String texto) {
		
		String textoRecebido = texto.toLowerCase();
		String parteTexto1;
		String parteTexto2;	
		
		List<String> listaAnagramas = new ArrayList<String>();
	
		//Este loop controla o tamanho da subString, que começa com 1 e vai até tamanho da String - 1
		for(int intervalo = 1; intervalo < textoRecebido.length(); intervalo++) {
			
			//Este Loop controla o valor da String1.
			for(int contString1 = 0; contString1 < textoRecebido.length(); contString1++) {
				
				//Esta estrutura de decisão impede que crie uma subString além do que minha string permite, o que ocasionaria em um erro.
				if(contString1 + intervalo <= textoRecebido.length()) {
					parteTexto1 = textoRecebido.substring(contString1, contString1 + intervalo);				
				}else {
					continue;
				}
				
				//Este Loop controla o valor da String2, pois esse loop é responsável por alterar o valor da String2 e comparar com a String1 
				for(int contString2 = 0; contString2 < texto.length(); contString2++) {
					
					//Esta estrutura de decisão impede que crie uma subString além do que minha string permite, o que ocasionaria em um erro.
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
	
	public static boolean eAnagrama(String string1, String string2) {
		char[] string1char = string1.toCharArray();
		char[] string2char = string2.toCharArray();
		Arrays.sort(string1char);
		Arrays.sort(string2char);
		
		// Código Comentado para não poluir muito a saida do console, mas caso queira analisar todas as subStrings comparadas somente descomentar.
		//System.out.println("VOU COMPARAR '" + string1 + "' COM '" + string2 + "' Resultado foi = " + Arrays.equals(string1char, string2char));
		
		return Arrays.equals(string1char, string2char);
	}
	
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
}
