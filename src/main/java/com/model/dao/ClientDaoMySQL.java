package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.model.entities.Clients;

public class ClientDaoMySQL implements RequestDao {

	private EntityManagerFactory emf;

	public ClientDaoMySQL() {

	}

	public ClientDaoMySQL(EntityManagerFactory emf) {
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
			Clients client = em.find(Clients.class, type);

			if (client == null) {
				System.out.println("Id não encontrado;");
				return null;
			}
			em.getTransaction().commit();
			return client.getId();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<Clients> findAll() {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT e FROM ClientBase e";

			em.getTransaction().begin();
			List<Clients> clients = em.createQuery(jpql, Clients.class).getResultList();
			em.getTransaction().commit();
			return clients;
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
			Clients client = em.find(Clients.class, type);

			if (client != null) {
				em.remove(type);
				em.getTransaction().commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}
