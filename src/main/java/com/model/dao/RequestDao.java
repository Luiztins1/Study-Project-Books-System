package com.model.dao;

import java.util.List;


public interface RequestDao {

	public void insert();
	public Integer findById();
	public List<Object> findAll();
	public String findName(String name);
	public void update();
	public void delete();

}
