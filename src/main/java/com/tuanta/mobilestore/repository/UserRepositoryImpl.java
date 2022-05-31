package com.tuanta.mobilestore.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	EntityManager em;
	
	@Override
	public boolean checkLogin(String userName, String password) {
		boolean result = false;
		try {
			String sql = "SELECT u FROM User AS u WHERE u.userName = :userName AND u.password = :password";
			Query query = em.createQuery(sql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			if(query.getSingleResult() != null) {
				result = true;
			}
			return result;
		} catch (NoResultException e) {
			return false;
		}
	}
}
