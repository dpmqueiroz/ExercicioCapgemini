package com.capgemini.testeunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.app.AppExercicio;
import com.capgemini.utils.CapgeminiUtils;

public class CapgeminiUtilsTest {

	@Test
	public void SenhaDanRetornoDeveriaSer3() {
		
		 int resultado = CapgeminiUtils.validaSenha("dan");
		 assertEquals(3, resultado);
	}
	
	@Test
	public void SenhaServinRetornoDeveriaSer1() {
		
		 int resultado = CapgeminiUtils.validaSenha("Servi");
		 assertEquals(1, resultado);
	}
	
	@Test
	public void SenhaDan1elCorretonRetornoDeveriaSer0() {
		
		 int resultado = CapgeminiUtils.validaSenha("D@n1el");
		 assertEquals(0, resultado);
	}
	
	@Test
	public void SenhaVazionRetornoDeveriaSer0() {
		
		 int resultado = CapgeminiUtils.validaSenha("");
		 assertEquals(6, resultado);
	}
	
	@Test
	public void SenhadanielRetornoDeveria0() {
		
		 int resultado = CapgeminiUtils.validaSenha("daniel");
		 assertEquals(-1, resultado);
	}
	
	@Test
	public void SenhaYa3RetornoDeveria3() {
		
		 int resultado = CapgeminiUtils.validaSenha("ya3");
		 assertEquals(3, resultado);
	}
	
	@Test
	public void SenhaYDWRDSIRetornoDeveria3() {
		
		 int resultado = CapgeminiUtils.validaSenha("YDWRDSI");
		 assertEquals(-1, resultado);
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
	
	@Test
	public void gerarEscadaComValor6() {
		
		 CapgeminiUtils.geraEscada(6);
	}
	
	@Test
	public void gerarEscadaComValorMenos1() {
		
		 CapgeminiUtils.geraEscada(-1);
	}
	
	@Test
	public void testeDeCoberturaApplicationMain() {
		
		AppExercicio app = new AppExercicio();
		app.main(null);
	}

}

