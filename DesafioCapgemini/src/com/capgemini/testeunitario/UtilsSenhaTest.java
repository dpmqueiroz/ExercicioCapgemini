package com.capgemini.testeunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.utils.CapgeminiUtils;

public class UtilsSenhaTest {

	@Test
	public void SenhaDanRetorno3() {
		
		 int resultado = CapgeminiUtils.validaSenha("dan");
		 assertEquals(3, resultado);
	}
	
	@Test
	public void SenhaServinRetorno1() {
		
		 int resultado = CapgeminiUtils.validaSenha("Servi");
		 assertEquals(1, resultado);
	}
	
	@Test
	public void SenhaDanielCorretonRetorno0() {
		
		 int resultado = CapgeminiUtils.validaSenha("D@n1el");
		 assertEquals(0, resultado);
	}
	
	@Test
	public void SenhaVazionRetorno0() {
		
		 int resultado = CapgeminiUtils.validaSenha("");
		 assertEquals(6, resultado);
	}
	
	@Test
	public void SenhadanielRetorno0() {
		
		 int resultado = CapgeminiUtils.validaSenha("daniel");
		 assertEquals(-1, resultado);
	}
	
	@Test
	public void SenhaYa3Retorno0() {
		
		 int resultado = CapgeminiUtils.validaSenha("ya3");
		 assertEquals(3, resultado);
	}

}
