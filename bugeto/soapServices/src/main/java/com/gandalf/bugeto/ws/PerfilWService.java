package com.gandalf.bugeto.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gandalf.bugeto.business.RegistroBusiness;
import com.gandalf.bugeto.exception.BusinessException;
import com.gandalf.bugeto.exception.ValidatorException;
import com.gandalf.bugeto.vo.RegistroVO;
import com.gandalf.bugeto.ws.response.CheckAvailabilityResponse;
import com.gandalf.bugeto.ws.response.ConfirmUserResponse;
import com.gandalf.bugeto.ws.response.RegistroUserResponse;

@WebService
public class PerfilWService {
	private static final Logger _log = LoggerFactory.getLogger(PerfilWService.class);

	@Autowired
	private RegistroBusiness registroBusiness;

	@WebMethod(operationName = "checkEmailAvailability")
	public CheckAvailabilityResponse checkAvailability(@WebParam(name = "email") String email) {
		CheckAvailabilityResponse response = new CheckAvailabilityResponse(email);
		EmailValidator validator = EmailValidator.getInstance();
		if (!validator.isValid(email)) {
			response.setError(CheckAvailabilityResponse.ERROR_INVALID_EMAIL, CheckAvailabilityResponse.ERROR_INVALID_EMAIL_MESSAGE);
			response.setAvailable(false);
		} else if (registroBusiness.checkUserRegistrado(email)) {
			response.setAvailable(false);
		}

		return response;
	}

	@WebMethod(operationName = "registroUserService")
	public RegistroUserResponse registroUserWService(RegistroVO registro) {
		RegistroUserResponse response = new RegistroUserResponse();
		if (registro == null) {
			response.setError(RegistroUserResponse.ERROR_INVALID_OBJECT, RegistroUserResponse.ERROR_INVALID_OBJECT_MESSAGE);
		}

		try {
			registroBusiness.registroUser(registro);
		} catch (ValidatorException e) {
			response.setError(RegistroUserResponse.ERROR_VALIDATION, RegistroUserResponse.ERROR_VALIDATION_MESSAGE, e.getMessage());
			_log.error(e.getMessage(), e);
		} catch (BusinessException e) {
			response.setError(RegistroUserResponse.ERROR_BUSINESS, RegistroUserResponse.ERROR_BUSINESS_MESSAGE, e.getMessage());
			_log.error(e.getMessage(), e);
		} catch (Exception e) {
			response.setError(RegistroUserResponse.ERROR_GENERIC, RegistroUserResponse.ERROR_GENERIC_MESSAGE, e.getMessage());
			_log.error(e.getMessage(), e);
		}

		return response;
	}

	@WebMethod(operationName = "confirmaUsuario")
	public ConfirmUserResponse confirmaUsuario(@WebParam(name = "email") String email, @WebParam(name = "token") String token) {
		ConfirmUserResponse response = new ConfirmUserResponse(email);

		try {
			registroBusiness.confirmaUser(email, token);
		} catch (BusinessException e) {
			response.setError(RegistroUserResponse.ERROR_BUSINESS, RegistroUserResponse.ERROR_BUSINESS_MESSAGE, e.getMessage());
			_log.error(e.getMessage(), e);
		} catch (Exception e) {
			response.setError(RegistroUserResponse.ERROR_GENERIC, RegistroUserResponse.ERROR_GENERIC_MESSAGE, e.getMessage());
			_log.error(e.getMessage(), e);
		}

		return response;
	}

	@WebMethod(exclude = true)
	public static void main(String[] args) {
		_log.debug("abc");
	}
}