package com.gandalf.bugeto.ws.response;

public class ConfirmUserResponse extends WSResponse {
	private static final long serialVersionUID = 1L;

	private String email;
	private boolean validado;

	public ConfirmUserResponse() {
		this.setSuccess();
	}

	public ConfirmUserResponse(String email) {
		this.email = email;
		this.setSuccess();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

}
