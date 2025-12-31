package com.controller;

import com.model.dao.ClientDaoMySQL;
import com.model.entities.Clients;

public class MenuClient {
	
	private Clients client;
	
	public MenuClient(Clients client) {
		this.client = client;
	}
	
	public void registerClient(ClientDaoMySQL clientDao) {
		clientDao.insert(client);
	}
	
	public void findClientById(ClientDaoMySQL clientDao) {
		clientDao.findById(client);
	}
	
	public void deleteClient(ClientDaoMySQL clientDao) {
		clientDao.delete(client);
	}

}
