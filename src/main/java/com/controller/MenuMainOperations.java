package com.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.model.dao.BooksDaoMySQL;
import com.model.dao.ClientDaoMySQL;
import com.model.dao.EmployeeDaoMySQL;
import com.model.dao.RequestDaoFactory;
import com.model.entities.Employee;
import com.model.utils.Utils;

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
			JOptionPane.showMessageDialog(null, "Bem vindo "+emp.getName()+"!", "Login - Sucesso", JOptionPane.PLAIN_MESSAGE);
			Utils.flagUtil = true;
		}
		em.getTransaction().commit();
	}
	
	public void registerEmployee(String name, Integer password) {
		em.getTransaction().begin();
		employeeDao.insert(new Employee(null, name, password));
		em.getTransaction().commit();
	}

}
