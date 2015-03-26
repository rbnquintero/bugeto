package com.gandalf.bugeto.persistence.repository;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gandalf.bugeto.config.PersistenceConfig;
import com.gandalf.bugeto.config.SpringConfig;
import com.gandalf.bugeto.persistence.domain.MovCategory;
import com.gandalf.bugeto.persistence.domain.Movimiento;
import com.gandalf.bugeto.persistence.domain.User;
import com.gandalf.bugeto.persistence.domain.UserBalance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, SpringConfig.class })
public class RepositoryTest {
	private static final Logger _log = LoggerFactory.getLogger(RepositoryTest.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovimientoRepository movRepository;

	@Test
	public void UserTest() {
		List<User> loginList = userRepository.findAllUsers();
		Iterator<User> it = loginList.iterator();
		User user = null;
		while (it.hasNext()) {
			user = it.next();
			_log.debug(user.getUserUsername());
			if (user.getUserInfo() != null) {
				_log.debug(user.getUserInfo().getUserInfoNickname());
			}
		}
	}

	@Test
	@Transactional
//	@Rollback(false)
	public void MovTest() {
		User user = userRepository.findUserByUsername("rbnquintero@yahoo.com");
		UserBalance userBalance = new UserBalance(0.0, user);
		movRepository.saveUserBalance(userBalance);
		MovCategory cat = movRepository.findMovCategoryBycatId(1L);
		Movimiento mov = new Movimiento();
		mov.setMovAmmount(200);
		mov.setMovDate(new Date());
		mov.setMovComments("");
		mov.setUserBalance(userBalance);
		mov.setMovCategory(cat);
		mov.setMovType(cat.getMovType());
		mov.setUser(user);
		System.out.println("success");
		movRepository.save(mov);
		System.out.println("success");
	}
}