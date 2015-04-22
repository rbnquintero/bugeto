package com.gandalf.bugeto.service;

import org.springframework.stereotype.Service;

import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.persistence.domain.User;
import com.gandalf.bugeto.persistence.domain.UserInfo;

/**
 * Created by rbnquintero on 3/26/15.
 */
@Service
public interface UserService {

	public User getUser(String username);

	public User saveUser(User user) throws ServiceException;
	
	public void saveUserInfo(UserInfo userInfo) throws ServiceException;
	
	public void createUserInfo(UserInfo userInfo) throws ServiceException;

	public boolean existingUser(String username);

}