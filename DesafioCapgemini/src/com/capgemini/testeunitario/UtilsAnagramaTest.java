package com.capgemini.testeunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.utils.CapgeminiUtils;

public class UtilsAnagramaTest {
	
	
	
	
	@Test
	public void AnagramaparaOvoRetorno2() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("ovo");
		 assertEquals(2, resultado);
	}
	
	@Test
	public void AnagramaparaIfailuhkqqRetorno3() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("ifailuhkqq");
		 assertEquals(3, resultado);
	}
	
	@Test
	public void AnagramaparaBananaRetorno12() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("banana");
		 assertEquals(12, resultado);
	}
	
	@Test
	public void AnagramaparaCapgeminiRetorno12() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("capgemini");
		 assertEquals(2, resultado);
	}
	
	@Test
	public void AnagramaparaJaveiroRetorno12() {
		
		 int resultado = CapgeminiUtils.descobrirParesAnagramas("Javeiro");
		 assertEquals(0, resultado);
	}
	
	
	
}
