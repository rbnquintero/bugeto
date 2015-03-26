package com.gandalf.bugeto.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertyResolver;

/**
 * Clase para la obtención de propiedades
 * 
 * @author  JWM - Ruben Quintero
 *
 */
public class Properties{
	@Autowired
	PropertyResolver propRes;
	
	/**
	 * Obtiene una propiedad
	 * @param key
	 * @return
	 */
	public String getProperty(String key){
		return propRes.getProperty(key);
	}
	
	/**
	 * Obtiene una propiedad o su default
	 * @param key
	 * @param def
	 * @return
	 */
	public String getProperty(String key, String def){
		return propRes.getProperty(key, def);
	}
}