package com.gandalf.bugeto.ws.response;

import java.io.Serializable;

public class WSResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "SUCCESS";

	private String errorCode;
	private String errorMessage;
	private String errorDetails;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setSuccess() {
		this.errorCode = "0";
		this.errorMessage = SUCCESS;
	}

	public void setError(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public void setError(String errorCode, String errorMessage, String errorDetails) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
}
