package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.entities.Clients;

public class ClientDaoMySQL implements RequestDao {

	private EntityManager em;

	public ClientDaoMySQL() {

	}

	public ClientDaoMySQL(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Object type) {
		em.persist(type);

	}

	@Override
	public Integer findById(Object type) {
		Clients client = em.find(Clients.class, type);

		if (client == null) {
			System.out.println("Id não encontrado;");
			return null;
		}

		return client.getId();
	}

	@Override
	public List<Clients> findAll() {
		String jpql = "SELECT e FROM ClientBase e";

		List<Clients> clients = em.createQuery(jpql, Clients.class).getResultList();
		return clients;
	}

	@Override
	public void update(Object type) {
		em.merge(type);
	}

	@Override
	public void delete(Object type) {
		Clients client = em.find(Clients.class, type);
		
		if (client != null) {
			em.remove(type);
		}
	}

}
