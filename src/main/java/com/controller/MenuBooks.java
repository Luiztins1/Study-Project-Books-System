package com.controller;

import com.model.dao.BooksDaoMySQL;
import com.model.entities.Books;

public class MenuBooks {
	
	private Books books;
	
	public MenuBooks(Books books) {
		this.books = books;
	}
	
	public void registerBook(BooksDaoMySQL booksDao) {
		booksDao.insert(books);
	}
	
	public void deleteBook(BooksDaoMySQL booksDao) {
		booksDao.delete(books);
		
	}
	
	public void findBookById(BooksDaoMySQL booksDao) {
		booksDao.findById(books.getId());
	}
	
	public void listBook(BooksDaoMySQL books) {
		books.findAll();
		
	}

}
