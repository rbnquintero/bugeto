package com.gandalf.bugeto.ws.response;

public class RegistroUserResponse extends WSResponse {
	private static final long serialVersionUID = 1L;

	public static final String ERROR_INVALID_OBJECT = "-1";
	public static final String ERROR_INVALID_OBJECT_MESSAGE = "Petición inválida";
	public static final String ERROR_VALIDATION = "-2";
	public static final String ERROR_VALIDATION_MESSAGE = "Error de validación";
	public static final String ERROR_BUSINESS = "-3";
	public static final String ERROR_BUSINESS_MESSAGE = "Error en la capa business";
	public static final String ERROR_GENERIC = "-4";
	public static final String ERROR_GENERIC_MESSAGE = "Error en el servicio";
	
	private String email;
	private boolean registrado = false;

	public RegistroUserResponse() {
		this.setSuccess();
	}

	public RegistroUserResponse(String email) {
		this.email = email;
		this.setSuccess();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
}
