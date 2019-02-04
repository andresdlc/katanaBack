package com.pichincha.calculadora;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void operaciones_matematicas_numerica() throws Exception {

		EntityOperacion entityOperacion = new EntityOperacion();
		entityOperacion.setOperacion("5+3");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":true,\r\n" + "\"operacion\": 8\r\n" + "}"));

		entityOperacion.setOperacion("(5+3)*3+(2*3)");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":true,\r\n" + "\"operacion\": 30\r\n" + "}"));

	}

	@Test
	public void operaciones_matematicas_letras() throws Exception {

		EntityOperacion entityOperacion = new EntityOperacion();
		entityOperacion.setOperacion("dos+cuatro");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":false,\r\n" + "\"operacion\": -1\r\n" + "}"));

		entityOperacion.setOperacion("dos+tres");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":false,\r\n" + "\"operacion\": -1\r\n" + "}"));
	}

	@Test
	public void operaciones_matematicas_error_parentesis() throws Exception {

		EntityOperacion entityOperacion = new EntityOperacion();
		entityOperacion.setOperacion("((2+3)");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":false,\r\n" + "\"operacion\": -1\r\n" + "}"));

		entityOperacion.setOperacion("5+3((5");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":false,\r\n" + "\"operacion\": -1\r\n" + "}"));
	}

	@Test
	public void operaciones_matematicas_error_aceptacion() throws Exception {

		EntityOperacion entityOperacion = new EntityOperacion();
		entityOperacion.setOperacion("2+3*3");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":true,\r\n" + "\"operacion\": 11\r\n" + "}"));

		entityOperacion.setOperacion("(2+4)");

		this.mvc.perform(post("/hello/calculadora").contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
				.content(new ObjectMapper().writeValueAsString(entityOperacion))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
				.andExpect(content().json("{\r\n" + "\"status\":true,\r\n" + "\"operacion\": 6\r\n" + "}"));
	}

}
