package com.gandalf.bugeto.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gandalf.bugeto.config.PersistenceConfig;
import com.gandalf.bugeto.config.ServiceConfig;
import com.gandalf.bugeto.config.SpringConfig;
import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.persistence.domain.User;

/**
 * Created by rbnquintero on 3/26/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, SpringConfig.class, ServiceConfig.class })
public class UserServiceTest {
	private static final Logger _log = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Test
	public void getUser() {
		String username = "rbnquintero@yahoo.com";
		User user = userService.getUser(username);
		Assert.assertNotNull(user);
		_log.debug("SUCCESS");
	}

	@Test
	public void sendMail() {
		String to = "rbnquintero@gluo.mx";
		String subject = "prueba1";
		String content = "contenido de adentro";
		boolean isHtml = false;
		if (to.equals(subject)) {
			try {
				mailService.sendMail(to, subject, content, isHtml);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}
}
