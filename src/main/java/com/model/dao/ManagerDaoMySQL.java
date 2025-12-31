package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.entities.Manager;

public class ManagerDaoMySQL implements RequestDao {

	private EntityManager em;

	public ManagerDaoMySQL() {

	}

	public ManagerDaoMySQL(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Object type) {
		em.persist(type);

	}

	@Override
	public Integer findById(Object type) {
		Manager man = em.find(Manager.class, type);

		if (man == null) {
			System.out.println("Id não encontrado.");
			return null;
		}

		return man.getId();
	}

	@Override
	public List<Manager> findAll() {
		String jpql = "SELECT e FROM Manager e";
		
		List<Manager> listManager = em.createQuery(jpql, Manager.class).getResultList();
		return listManager;
	}

	@Override
	public void update(Object type) {
		em.merge(type);

	}

	@Override
	public void delete(Object type) {
		Manager man = em.find(Manager.class, type);
		
		if(man != null) {
			em.remove(man);
		}

	}

}
