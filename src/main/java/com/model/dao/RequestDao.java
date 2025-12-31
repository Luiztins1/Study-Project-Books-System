package com.model.dao;

import java.util.List;


public interface RequestDao<T> {

	public void insert(T type);
	public T findById(T type);
	public List<T> findAll();
	public void update(T type);
	public void delete(T type);

}
