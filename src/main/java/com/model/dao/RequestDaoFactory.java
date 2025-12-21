package com.model.dao;

import javax.persistence.EntityManagerFactory;

public class RequestDaoFactory {
	
	public void createEmployeeDaoMySQL(EntityManagerFactory em) {
		em.createEntityManager();
	}
	
	public void createManagerDaoMySQL(EntityManagerFactory em) {
		em.createEntityManager();
	}
	
	public void createClientDaoMySQL(EntityManagerFactory em) {
		em.createEntityManager();
	}
	
	public void createBooksDaoMySQL(EntityManagerFactory em) {
		em.createEntityManager();
	}

}
