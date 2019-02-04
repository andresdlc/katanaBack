package com.pichincha.calculadora;

import org.springframework.web.bind.annotation.RequestAttribute;

public class EntityOperacion {

	
	private String operacion="";

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public EntityOperacion() {
		super();
	}
	
	
	
	
}
