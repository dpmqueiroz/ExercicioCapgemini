package com.capgemini.testeunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.utils.CapgeminiUtils;

public class UtilsAnagramaTest {
	
	
	
	
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
