package com.gandalf.bugeto.exception;

import java.util.List;

import com.gandalf.bugeto.vo.ValidatorObject;

/**
 * Exception a utilizar por los validadores. Contiene una lista de objetos de error
 * 
 * @author  JWM - Ruben Quintero
 *
 */
public class ValidatorException extends ServiceException{
	private static final long serialVersionUID = 1L;
	
	private List<ValidatorObject> errors;

	public ValidatorException(String msg) {
		super(msg);
	}
	
	public ValidatorException(String msg, String status) {
        super(msg);
        this.status = status;
    }
	
	public ValidatorException(String msg, List<ValidatorObject> errors) {
		super(msg);
		this.errors = errors;
	}
	
	public ValidatorException(String msg, String status, List<ValidatorObject> errors) {
		super(msg);
		this.status = status;
		this.errors = errors;
	}

	public List<ValidatorObject> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidatorObject> errors) {
		this.errors = errors;
	}
	
}
