package com.gandalf.bugeto.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.bugeto.business.PerfilBusiness;
import com.gandalf.bugeto.exception.BusinessException;
import com.gandalf.bugeto.exception.UtilException;
import com.gandalf.bugeto.persistence.domain.User;
import com.gandalf.bugeto.service.UserService;
import com.gandalf.bugeto.util.EncriptionUtils;

@Service
public class PerfilBusinessImpl implements PerfilBusiness {
	private static final Logger log = LoggerFactory.getLogger(PerfilBusinessImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public boolean validateUserAndPassword(String username, String password) throws BusinessException {
		User user = userService.getUser(username);

		try {
			if (user != null && EncriptionUtils.checkPassword(password, user.getUserUsername())) {
				return true;
			}
		} catch (UtilException ue) {
			log.error("No se pudo validar el password: " + password, ue);
			throw new BusinessException(ue.getMessage(), ue);
		}

		return false;
	}

}
