package com.gandalf.bugeto.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gandalf.bugeto.persistence.domain.UserInfo;

public class UserRepositoryImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		em.persist(userInfo);
	}

}
