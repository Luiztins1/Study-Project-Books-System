package com.model.dao;

import java.util.List;


public interface RequestDao<T> {

	public T insert(T type);
	public Integer findById(T type);
	public List<T> findAll();
	public String findName(T type);
	public void update();
	public T delete(T type);

}
