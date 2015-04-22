package com.gandalf.bugeto.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gandalf.bugeto.persistence.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, UserRepositoryCustom {

	@Query("from User")
	public List<User> findAllUsers();

	@Query("from User where username = ?1")
	public User findUserByUsername(String username);
}
