package com.capgemini.app;

import com.capgemini.utils.CapgeminiUtils;

public class AppExercicio {

	public static void main(String[] args) {

		System.out.println("1ª Questão: \n");
		CapgeminiUtils.geraEscada(8);
		
		System.out.println("\n\n2ª Questão :");
		
		int validaSenhaForte = CapgeminiUtils.validaSenha("y@3");
		System.out.println("O retorno para essa senha foi " + validaSenhaForte);

		System.out.println("\n\n3ª Questão :");
		
		int quantidadeParesSubstring = CapgeminiUtils.descobrirParesAnagramas("desenvolvedor");
		System.out.println("\n O retorno da função descobrirParesAnagramas(" + "\"desenvolvedor\"" + ") é igual a = " + quantidadeParesSubstring);
	}

}
