package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class ClientDaoMySQL implements RequestDao{
	
	private EntityManager em;
	
	public ClientDaoMySQL() {
		
	}
	
	public ClientDaoMySQL(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Object type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer findById(Object type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findName(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object type) {
		// TODO Auto-generated method stub
		
	}

}
