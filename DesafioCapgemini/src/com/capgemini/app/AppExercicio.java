package com.capgemini.app;

import com.capgemini.utils.CapgeminiUtils;

public class AppExercicio {

	public static void main(String[] args) {

		System.out.println("1� Quest�o: \n");
		CapgeminiUtils.geraEscada(8);
		
		System.out.println("\n\n2� Quest�o :");
		
		int validaSenhaForte = CapgeminiUtils.validaSenha("y@3");
		System.out.println("O retorno para essa senha foi " + validaSenhaForte);

		System.out.println("\n\n3� Quest�o :");
		
		int quantidadeParesSubstring = CapgeminiUtils.descobrirParesAnagramas("desenvolvedor");
		System.out.println("\n O retorno da fun��o descobrirParesAnagramas(" + "\"desenvolvedor\"" + ") � igual a = " + quantidadeParesSubstring);
	}

}
