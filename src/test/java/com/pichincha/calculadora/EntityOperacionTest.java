package com.pichincha.calculadora;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityOperacionTest {

	@Test
	public void get_and_set() {
		
		EntityOperacion entityOperacion=new EntityOperacion();
		
		assertTrue("EntityOperacionTest:get_and_set:1", entityOperacion.getOperacion().equals(""));
		assertTrue("EntityOperacionTest:get_and_set:2", entityOperacion.getOperacion().equals(null)==false);
		entityOperacion.setOperacion("5+3");
		assertTrue("EntityOperacionTest:get_and_set:3", entityOperacion.getOperacion().equals("5+3"));

		
	}
}
