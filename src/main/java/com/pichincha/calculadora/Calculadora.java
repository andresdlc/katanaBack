package com.pichincha.calculadora;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculadora {

	public Double operacion(String cadena) {
		
		if (cadena.trim().length()==0)return -1.d;
		
		 /*Pattern pat = Pattern.compile("[^1-9()+-\\*\\/]");
	     Matcher mat = pat.matcher(cadena);
	     if (mat.find()) {
	    	 return -1.d;
	     }*/
		

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			Object result = engine.eval(cadena);
			return Double.parseDouble(result.toString());
		} catch (ScriptException e) {
			return -1.d;
		}
	}

}
