package com.model.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class WorkingPeople implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer password;
	private Character[] code;
	
	public WorkingPeople() {
		
	}

	public WorkingPeople(String name, Integer password, Character[] code) {
		this.name = name;
		this.password = password;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Character[] getCode() {
		return code;
	}

	public void setCode(Character[] code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(code);
		result = prime * result + Objects.hash(password);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkingPeople other = (WorkingPeople) obj;
		return Arrays.equals(code, other.code) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "WorkingPeople [name=" + name + ", password=" + password + ", code=" + Arrays.toString(code) + "]";
	}

}
