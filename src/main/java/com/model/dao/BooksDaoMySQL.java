package com.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.model.entities.Books;

public class BooksDaoMySQL implements RequestDao {

	private EntityManager em;

	public BooksDaoMySQL() {

	}

	public BooksDaoMySQL(EntityManager em) {
		this.em = em;
	}

	public List<Books> searchBookName(String name) {
		
		String jpql = "SELECT e FROM Books e WHERE e.name = :pName";
		
		if(!name.equals(jpql)) {
			JOptionPane.showMessageDialog(null, "Nome não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
			return new ArrayList<>();
		}else {
			List<Books> bkName = em.createQuery(jpql, Books.class).setParameter("pName", name).getResultList();
			return bkName;
		}
	}

	@Override
	public void insert(Object type) {
		em.persist(type);

	}

	@Override
	public Books findById(Object type) {
		Books bkId = em.find(Books.class, type);

		if (bkId == null) {
			JOptionPane.showMessageDialog(null, "Id não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return bkId;
	}

	@Override
	public List<Books> findAll() {
		String jpql = "SELECT e FROM Books e";

		List<Books> booksAll = em.createQuery(jpql, Books.class).getResultList();
		return booksAll;
	}

	@Override
	public void update(Object type) {
		em.getTransaction().begin();
		em.merge(type);
		em.getTransaction().commit();

	}

	@Override
	public void delete(Object type) {
		Books bkId = this.findById(type);
		
		
		if(bkId != null) {
			em.getTransaction().begin();
			em.remove(bkId);
			JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!", "Deletado",
					JOptionPane.INFORMATION_MESSAGE);
			em.getTransaction().commit();
		}
		

	}

}
