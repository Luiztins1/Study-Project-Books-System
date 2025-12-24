package com.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends WorkingPeople{

	private static final long serialVersionUID = 1L;
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Integer password) {
		super(null, name, password);
	}

}
