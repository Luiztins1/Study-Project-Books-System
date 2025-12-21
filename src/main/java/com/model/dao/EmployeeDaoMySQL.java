package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDaoMySQL implements RequestDao{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-system");
	private EntityManager em;
	
	public EmployeeDaoMySQL() {
		
	}

	@Override
	public void insert() {
		//Inicia Transação
		em.getTransaction().begin();;
		
		em.persist(em);
		
		//Confirma Transação
		em.getTransaction().commit();
		
		//Fecha a conexão.
		em.close();
		emf.close();
	}

	@Override
	public Integer findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll() {
		
		return null;
	}

	@Override
	public String findName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
