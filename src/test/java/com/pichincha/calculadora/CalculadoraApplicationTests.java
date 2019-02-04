package com.pichincha.calculadora;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraApplicationTests {

	@Test
	public void operacion_matemanticas() {
		Calculadora calculadora = new Calculadora();

		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:1",calculadora.operacion("2+3")==5);
		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:2",calculadora.operacion("2-3")==-1);
		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:3",calculadora.operacion("2*3")==6);
		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:4",calculadora.operacion("20/2")==10);
		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:5",calculadora.operacion("(1+2)*3")==9);
		assertTrue("CalculadoraApplicationTests:deberiaSumaDosNumeros:6",calculadora.operacion("3*3+2")==11);
	}
	
	
	@Test
	public void operacion_error() {
		Calculadora calculadora = new Calculadora();

		assertTrue("CalculadoraApplicationTests:operacion_error:1",calculadora.operacion("(2+3))")==-1.d);
		assertTrue("CalculadoraApplicationTests:operacion_error:2",calculadora.operacion("a+3")==-1.d);
		assertTrue("CalculadoraApplicationTests:operacion_error:3",calculadora.operacion("")==-1.d);
		assertTrue("CalculadoraApplicationTests:operacion_error:4",calculadora.operacion(" ")==-1.d);
		assertTrue("CalculadoraApplicationTests:operacion_error:5",calculadora.operacion("''''''''''")==-1.d);
	}

}
