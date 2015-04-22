package com.gandalf.bugeto.ws.response;

public class CheckAvailabilityResponse extends WSResponse {
	private static final long serialVersionUID = 1L;

	public static final String ERROR_INVALID_EMAIL = "-1";
	public static final String ERROR_INVALID_EMAIL_MESSAGE = "Formato de correo inválido";

	private boolean available = true;
	private String email = "";

	public CheckAvailabilityResponse() {}

	public CheckAvailabilityResponse(String email) {
		this.email = email;
		this.setSuccess();
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
