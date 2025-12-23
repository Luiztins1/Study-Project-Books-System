package com.model.dao;

import javax.persistence.EntityManager;

public class RequestDaoFactory {
	private EntityManager em;
	
	public RequestDaoFactory(EntityManager em) {
		this.em = em;
	}
	
	public EmployeeDaoMySQL createEmployeeDaoMySQL() {
		return new EmployeeDaoMySQL(this.em);
	}
	
	public ManagerDaoMySQL createManagerDaoMySQL() {
		return new ManagerDaoMySQL(this.em);
	}
	
	public ClientDaoMySQL createClientDaoMySQL() {
		return new ClientDaoMySQL(this.em);
	}
	
	public BooksDaoMySQL createBooksDaoMySQL() {
		return new BooksDaoMySQL(this.em);
	}

}
