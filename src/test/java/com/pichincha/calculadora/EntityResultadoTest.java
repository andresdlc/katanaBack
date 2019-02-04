package com.pichincha.calculadora;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityResultadoTest {

	@Test
	public void get_and_set() {
		
		EntityResultado entityResultado=new EntityResultado();
		
		assertTrue("EntityResultadoTest:get_and_set:1", entityResultado.getStatus()==false);
		entityResultado.setStatus(true);
		assertTrue("EntityResultadoTest:get_and_set:2", entityResultado.getStatus()==true);
		entityResultado.setOperacion(5.d);
		assertTrue("EntityResultadoTest:get_and_set:3", entityResultado.getOperacion()==5.d);
		
	}
}
