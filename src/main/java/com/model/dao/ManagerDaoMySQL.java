package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.model.entities.Manager;

public class ManagerDaoMySQL implements RequestDao {

	private EntityManagerFactory emf;

	public ManagerDaoMySQL() {

	}

	public ManagerDaoMySQL(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(type);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public Integer findById(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Manager man = em.find(Manager.class, type);
			em.getTransaction().commit();
			if (man == null) {
				System.out.println("Id não encontrado.");
				return null;
			}

			return man.getId();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<Manager> findAll() {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT e FROM Manager e";

			em.getTransaction().begin();
			List<Manager> listManager = em.createQuery(jpql, Manager.class).getResultList();
			em.getTransaction().commit();
			return listManager;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(type);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Manager man = em.find(Manager.class, type);
		
			if (man != null) {
				em.remove(man);
				em.getTransaction().commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}

}
