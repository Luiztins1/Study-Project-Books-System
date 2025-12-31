package com.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends WorkingPeople{
	
	private static final long serialVersionUID = 1L;

	public Manager() {
		super();
	}
	
	public Manager(String name, Integer password) {
		super(null, name, password);
	}

}
