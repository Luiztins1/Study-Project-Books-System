package com.model.dao;

import javax.persistence.EntityManagerFactory;

public class RequestDaoFactory {
	private EntityManagerFactory emf;
	
	public RequestDaoFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EmployeeDaoMySQL createEmployeeDaoMySQL() {
		return new EmployeeDaoMySQL(this.emf);
	}
	
	public ManagerDaoMySQL createManagerDaoMySQL() {
		return new ManagerDaoMySQL(this.emf);
	}
	
	public ClientDaoMySQL createClientDaoMySQL() {
		return new ClientDaoMySQL(this.emf);
	}
	
	public BooksDaoMySQL createBooksDaoMySQL() {
		return new BooksDaoMySQL(this.emf);
	}
	
	

}
