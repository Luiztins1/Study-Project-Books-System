package com.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import com.model.dao.BooksDaoMySQL;
import com.model.dao.ClientDaoMySQL;
import com.model.dao.EmployeeDaoMySQL;
import com.model.dao.RequestDaoFactory;
import com.model.entities.Books;
import com.model.entities.Clients;
import com.model.entities.Employee;
import com.model.utils.UtilsObj;

public class MenuMainOperations {

	private RequestDaoFactory daoFactory;
	public BooksDaoMySQL booksDao;
	public ClientDaoMySQL clientDao;
	public EmployeeDaoMySQL employeeDao;
	private boolean flag = false;
	private EntityManagerFactory emf;

	public MenuMainOperations(EntityManagerFactory emf) {
		this.emf = emf;
		this.daoFactory = new RequestDaoFactory(this.emf);
		booksDao = new BooksDaoMySQL(this.emf);
		clientDao = new ClientDaoMySQL(this.emf);
		employeeDao = new EmployeeDaoMySQL(this.emf);

	}

	public void loginVerification(String name, Integer password) {
		//Uma atualização é feita toda vez que um verificação de login é feita.
		Employee emp = employeeDao.findByLogin(name, password);
		
		if (emp != null) {
			employeeDao.update(emp);
			UtilsObj.flagUtil = true;
			JOptionPane.showMessageDialog(null, "Bem vindo " + emp.getName() + "!", "Login - Sucesso",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	public void registerEmployee(String name, Integer password) {
		if (employeeDao.existName(name)) {
			JOptionPane.showMessageDialog(null, "Usuário já possui cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado",
						JOptionPane.PLAIN_MESSAGE);
				employeeDao.insert(new Employee(name, password));
				UtilsObj.flagUtil = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}
	
	public void registerBook(String name, String author, String country, LocalDate age,  Double price, Double priceMarket) {
		try {
		
			booksDao.insert(new Books(null, name, author, country, age, price, priceMarket));
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado",
					JOptionPane.PLAIN_MESSAGE);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void registerClient(String name, String surname, String cpf, LocalDate dateBirthday, String email, String telephoneNumber) {
		try {
			
			clientDao.insert(new Clients(name, surname, cpf, dateBirthday, email, telephoneNumber));
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado",
					JOptionPane.PLAIN_MESSAGE);
			
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "Erro ao salvar " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public List<Books> addItensInViewTable() {
		List<Books> bkList = booksDao.findAll();
		return bkList;
	}

}
