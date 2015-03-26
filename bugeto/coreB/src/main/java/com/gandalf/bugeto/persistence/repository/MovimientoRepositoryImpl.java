package com.gandalf.bugeto.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gandalf.bugeto.persistence.domain.UserBalance;

public class MovimientoRepositoryImpl implements MovimientoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveUserBalance(UserBalance userBalance) {
		em.persist(userBalance);
	}
}
