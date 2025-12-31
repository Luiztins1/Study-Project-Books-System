package com.model.dao;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;

import com.model.entities.Books;

public class BooksDaoMySQL implements RequestDao {

	private EntityManager em;

	public BooksDaoMySQL() {

	}

	public BooksDaoMySQL(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Object type) {
		em.persist(type);

	}

	@Override
	public Integer findById(Object type) {
		Books bkId = em.find(Books.class, type);
		
		if(bkId == null) {
			System.out.println("Id não encontrado.");
			return null;
		}
		return bkId.getId();
	}

	@Override
	public List<Books> findAll() {
		String jpql = "SELECT e FROM Books e";

		List<Books> booksAll = em.createQuery(jpql, Books.class).getResultList();
		return booksAll;
	}

	@Override
	public void update(Object type) {
		em.merge(type);

	}

	@Override
	public void delete(Object type) {
		Books bkId = em.find(Books.class, type);
		
		if(bkId != null) {
			em.remove(type);
		}

	}

}
