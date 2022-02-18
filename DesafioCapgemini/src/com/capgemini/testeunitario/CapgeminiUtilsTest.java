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
	
	@Test
	public void ParesDeAnagramasParaOvoDeveriaRetornar2() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("ovo");
		 assertEquals(2, resultado);
	}
	
	@Test
	public void ParesDeAnagramaParaIfailuhkqqDeveriaRetornar3() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("ifailuhkqq");
		 assertEquals(3, resultado);
	}
	
	@Test
	public void ParesDeAnagramaParaBananaDeveriaRetornar12() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("banana");
		 assertEquals(12, resultado);
	}
	
	@Test
	public void ParesDeAnagramaParaCapgeminiDeveriaRetornar2() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("capgemini");
		 assertEquals(2, resultado);
	}
	
	@Test
	public void ParesDeAnagramaParaJaveiroRetornar0() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("Javeiro");
		 assertEquals(0, resultado);
	}

}
