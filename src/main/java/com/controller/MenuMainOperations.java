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
		booksDao = new BooksDaoMySQL(this.em);
		clientDao = new ClientDaoMySQL(this.em);
		employeeDao = new EmployeeDaoMySQL(this.em);
	}
	
	public void loginVerification(String name, Integer password) {
		em.getTransaction().begin();
		Employee emp = employeeDao.findByLogin(name, password);
		
		if(emp != null) {
			System.out.println("Login realizado com sucesso!" + emp.getName());
		}else {
			System.out.println("Usuário ou senha inválidos!");
		}s
		
		em.getTransaction().commit();
	}
	
	public void registerEmployee(String name, Integer password) {
		em.getTransaction().begin();
		employeeDao.insert(new Employee(null, name, password));
		em.getTransaction().commit();
	}

}
