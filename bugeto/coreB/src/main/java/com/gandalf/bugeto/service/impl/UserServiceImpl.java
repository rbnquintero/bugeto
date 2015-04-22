package com.gandalf.bugeto.service.impl;

import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.exception.UtilException;
import com.gandalf.bugeto.persistence.domain.User;
import com.gandalf.bugeto.persistence.domain.UserInfo;
import com.gandalf.bugeto.persistence.repository.UserRepository;
import com.gandalf.bugeto.service.UserService;
import com.gandalf.bugeto.util.EncriptionUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rbnquintero on 3/26/15.
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger _log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(String username) {
		User user = null;
		try {
			user = userRepository.findUserByUsername(username);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	@Transactional
	public User saveUser(User user) throws ServiceException {
		try {
			user.setUserPassword(EncriptionUtils.encryptPassword(user.getUserPassword()));
			userRepository.save(user);
			return user;
		} catch (UtilException ue) {
			throw new ServiceException(ue.getMessage(), ue);
		} catch (Exception e) {
			throw new ServiceException("No se pudo guardar el usuario", e);
		}
	}

	@Override
	@Transactional
	public void saveUserInfo(UserInfo userInfo) throws ServiceException {
		try {
			userRepository.saveUserInfo(userInfo);
		} catch (Exception e) {
			throw new ServiceException("No se pudo guardar la informacion del usuario", e);
		}

	}
	
	@Override
	@Transactional
	public void createUserInfo(UserInfo userInfo) throws ServiceException {
		try {
			User user = userInfo.getUser();
			userInfo.setUserInfoId(user.getUserId());
			userRepository.saveUserInfo(userInfo);
			user.setUserInfo(userInfo);
			userRepository.save(user);
		} catch (Exception e) {
			throw new ServiceException("No se pudo guardar la informacion del usuario", e);
		}

	}

	@Override
	public boolean existingUser(String username) {
		User user = userRepository.findUserByUsername(username);
		if (user != null) {
			return true;
		}
		return false;
	}

}
