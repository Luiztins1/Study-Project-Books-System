package com.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.model.dao.BooksDaoMySQL;
import com.model.dao.ClientDaoMySQL;
import com.model.dao.EmployeeDaoMySQL;
import com.model.dao.RequestDaoFactory;
import com.model.entities.Books;
import com.model.entities.Employee;
import com.model.utils.UtilsObj;

public class MenuMainOperations {

	private RequestDaoFactory daoFactory;
	public BooksDaoMySQL booksDao;
	private ClientDaoMySQL clientDao;
	private EmployeeDaoMySQL employeeDao;
	private boolean flag = false;
	private EntityManager em;

	public MenuMainOperations(EntityManager em) {
		this.em = em;
		this.daoFactory = new RequestDaoFactory(this.em);
		booksDao = new BooksDaoMySQL(this.em);
		clientDao = new ClientDaoMySQL(this.em);
		employeeDao = new EmployeeDaoMySQL(this.em);

	}

	public void loginVerification(String name, Integer password) {
		//Uma atualização é feita toda vez que um verificação de login é feita.
		Employee emp = employeeDao.findByLogin(name, password);
		
		if (emp != null) {
			em.getTransaction().begin();
			employeeDao.update(emp);
			UtilsObj.flagUtil = true;
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Bem vindo " + emp.getName() + "!", "Login - Sucesso",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	public void registerEmployee(String name, Integer password) {
		if (employeeDao.existName(name)) {
			JOptionPane.showMessageDialog(null, "Usuário já possui cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				em.getTransaction().begin();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado",
						JOptionPane.PLAIN_MESSAGE);
				employeeDao.insert(new Employee(name, password));
				UtilsObj.flagUtil = true;
				em.getTransaction().commit();

			} catch (Exception e) {
				em.getTransaction().rollback();
				JOptionPane.showMessageDialog(null, "Erro ao salvar " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}
	
	public void registerBook(String name, String author, String country, LocalDate age,  Double price, Double priceMarket) {
		try {
			em.getTransaction().begin();
			booksDao.insert(new Books(null, name, author, country, age, price, priceMarket));
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado",
					JOptionPane.PLAIN_MESSAGE);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao salvar " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public List<Books> addItensInViewTable() {
		List<Books> bkList = booksDao.findAll();
		return bkList;
	}

}
