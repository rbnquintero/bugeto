package com.gandalf.bugeto.business.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.bugeto.business.RegistroBusiness;
import com.gandalf.bugeto.business.validator.RegistroBusinessValidator;
import com.gandalf.bugeto.exception.BusinessException;
import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.exception.ValidatorException;
import com.gandalf.bugeto.persistence.domain.MovCategory;
import com.gandalf.bugeto.persistence.domain.Movimiento;
import com.gandalf.bugeto.persistence.domain.User;
import com.gandalf.bugeto.persistence.domain.UserBalance;
import com.gandalf.bugeto.persistence.domain.UserInfo;
import com.gandalf.bugeto.service.MailService;
import com.gandalf.bugeto.service.MovementService;
import com.gandalf.bugeto.service.UserService;
import com.gandalf.bugeto.util.ConstantesCore;
import com.gandalf.bugeto.util.EncriptionUtils;
import com.gandalf.bugeto.util.Properties;
import com.gandalf.bugeto.vo.RegistroVO;

@Service
public class RegistroBusinessImpl implements RegistroBusiness {
	private static final Logger _log = LoggerFactory.getLogger(RegistroBusinessImpl.class);

	private static final String ERROR_USUARIO_REGISTRADO = "error_usuario_registrado";
	private static final String ERROR_USUARIO_NO_EXISTENTE = "error_usuario_no_existente";
	private static final String ERROR_USUARIO_YA_CONFIRMADO = "error_usuario_ya_confirmado";
	private static final String ERROR_TOKEN_INVALIDO = "error_token_invalido";

	@Autowired
	private UserService userService;

	@Autowired
	private MovementService movementService;

	@Autowired
	private MailService mailService;

	@Autowired
	private Properties properties;

	@Override
	public boolean checkUserRegistrado(String username) {
		return userService.existingUser(username);
	}

	@Override
	public void registroUser(RegistroVO registroVO) throws ValidatorException, BusinessException {
		RegistroBusinessValidator.registroUser(registroVO);

		if (userService.existingUser(registroVO.getUsername())) {
			_log.debug("El usuario " + registroVO.getUsername() + " ya está registrado");
			throw new BusinessException(ERROR_USUARIO_REGISTRADO);
		}
		Date today = new Date();

		// Crea el usuario
		User user = new User();
		user.setUserUsername(registroVO.getUsername());
		user.setUserPassword(registroVO.getPassword());
		user.setUserStatus(1L);
		user.setUserFechaCreacion(today);
		user.setUserToken(EncriptionUtils.generateAuthCode());
		try {
			userService.saveUser(user);
		} catch (ServiceException se) {
			throw new BusinessException(se.getMessage(), se);
		}
		if (registroVO.getNickname() != null) {
			UserInfo userInfo = new UserInfo(registroVO.getNickname());
			userInfo.setUser(user);
			try {
				userService.createUserInfo(userInfo);
			} catch (ServiceException se) {
				throw new BusinessException(se.getMessage(), se);
			}
		}
		// TODO cascade=CascadeType.ALL

		// Crea el primer balance
		UserBalance userBalance = new UserBalance(0.0, user);
		userBalance.setBalAmount(registroVO.getInitialAmount());
		try {
			movementService.saveBalance(userBalance);
		} catch (ServiceException e) {
			throw new BusinessException(e.getMessage(), e);
		}

		// Crea el primer movimiento asociado con el balance anterior
		Movimiento movimiento = new Movimiento();
		movimiento.setMovAmmount(registroVO.getInitialAmount());
		movimiento.setMovDate(today);
		movimiento.setMovComments(ConstantesCore.MOV_COMMENT_CREACION);
		movimiento.setUserBalance(userBalance);
		MovCategory movCategory = movementService.getCategoria(1L);
		movimiento.setMovCategory(movCategory);
		movimiento.setMovType(movCategory.getMovType());
		movimiento.setUser(user);
		movimiento.setMovCuentaId(1L);
		try {
			movementService.saveMovimiento(movimiento);
		} catch (ServiceException e) {
			throw new BusinessException(e.getMessage(), e);
		}

		// Manda el correo para confirmación del usuario
		try {
			mailService.sendMail(user.getUserUsername(), properties.getProperty("mail.template.registro.subject"),
					properties.getProperty("mail.template.registro.content"), true);
		} catch (ServiceException e) {
			_log.error("No se envió el correo", e);
		}
	}

	@Override
	public void confirmaUser(String username, String token) throws BusinessException {
		User user = userService.getUser(username);
		if (user == null) {
			throw new BusinessException(ERROR_USUARIO_NO_EXISTENTE);
		}
		if (user.getUserStatus() != 1) {
			throw new BusinessException(ERROR_USUARIO_YA_CONFIRMADO);
		}
		if (!user.getUserToken().equals(token) || user.getUserToken() == null) {
			throw new BusinessException(ERROR_TOKEN_INVALIDO);
		}

		user.setUserToken(null);
		user.setUserStatus(0L);
		try {
			userService.saveUser(user);
		} catch (ServiceException e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}
}
