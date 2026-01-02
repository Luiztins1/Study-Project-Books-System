package com.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import com.model.entities.Books;

public class BooksDaoMySQL implements RequestDao {

	private EntityManagerFactory emf;

	public BooksDaoMySQL() {

	}

	public BooksDaoMySQL(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<Books> searchBookName(String name) {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT e FROM Books e WHERE e.name = :pName";

			em.getTransaction().begin();
			List<Books> bkName = em.createQuery(jpql, Books.class).setParameter("pName", name).getResultList();
			em.getTransaction().commit();

			if (bkName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Livro não encontrado.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
			return bkName;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return new ArrayList<>();
		} finally {
			em.close();
		}

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
	public Books findById(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Books bkId = em.find(Books.class, type);
			em.getTransaction().commit();
			if (bkId == null) {
				JOptionPane.showMessageDialog(null, "Id não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			return bkId;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<Books> findAll() {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT e FROM Books e";

			em.getTransaction().begin();
			List<Books> booksAll = em.createQuery(jpql, Books.class).getResultList();
			em.getTransaction().commit();
			return booksAll;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return new ArrayList<>();
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
		} catch (Exception e) {
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
			Books bkId = em.find(Books.class, type);

			if (bkId != null) {
				em.getTransaction().begin();
				em.remove(bkId);
				JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!", "Deletado",
						JOptionPane.INFORMATION_MESSAGE);
				em.getTransaction().commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}
