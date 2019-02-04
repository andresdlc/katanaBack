package com.pichincha.calculadora;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 30/01/2019
 * 
 * @author dbello
 *
 */
@RestController
@RequestMapping("/hello")
public class Controller {
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/calculadora", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityResultado calculadora(@RequestBody EntityOperacion operacion) {

		Calculadora calculadora = new Calculadora();
		double resultado = calculadora.operacion(operacion.getOperacion());

		EntityResultado entityResultado = new EntityResultado();
		entityResultado.setOperacion(resultado);

		if (resultado == -1 || resultado==Double.POSITIVE_INFINITY) {
			entityResultado.setStatus(false);

		} else {
			entityResultado.setStatus(true);
		}

		return entityResultado;

	}
}
