package com.controller;

import javax.persistence.EntityManager;

import com.model.dao.BooksDaoMySQL;
import com.model.dao.ClientDaoMySQL;
import com.model.dao.EmployeeDaoMySQL;
import com.model.dao.RequestDaoFactory;
import com.model.entities.Employee;

public class MenuMainOperations{
	
	private RequestDaoFactory daoFactory;
	private BooksDaoMySQL booksDao;
	private ClientDaoMySQL clientDao;
	private EmployeeDaoMySQL employeeDao;
	private EntityManager em;
	
	public MenuMainOperations(EntityManager em){
		this.em = em;
		this.daoFactory = new RequestDaoFactory(this.em);
		employeeDao = new EmployeeDaoMySQL(this.em);
	}
	
	public void loginVerification(String name, Integer password) {
		em.getTransaction().begin();
		employeeDao.findName(new Employee(name, password));
		em.getTransaction().commit();
	}
	
	public void registerEmployee(String name, Integer password) {
		em.getTransaction().begin();
		employeeDao.insert(new Employee(name, password));
		em.getTransaction().commit();
	}

}
