package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;


public class BooksDaoMySQL implements RequestDao{

	private EntityManager em;
	
	public BooksDaoMySQL() {
		
	}
	
	public BooksDaoMySQL(EntityManager em) {
		this.em = em;
	}

	@Override
	public Object insert(Object type) {
		return null;
	}

	@Override
	public Integer findById(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll() {
		return null;
	}

	@Override
	public String findName(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object delete(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

}
