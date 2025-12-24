package com.controller;

import javax.persistence.EntityManager;

import com.model.dao.RequestDaoFactory;
import com.view.Screen;

public class MenuMainOperations{
	
	private RequestDaoFactory daoFactory;
	private EntityManager em;
	
	public MenuMainOperations(EntityManager em){
		this.em = em;
		this.daoFactory = new RequestDaoFactory(this.em);
	}

}
