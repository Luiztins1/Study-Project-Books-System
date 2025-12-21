package com.model.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class ClientBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String surname;
	private String cpf;
	private Date dateBirthday;
	private String email;
	private String telephoneNumber; 
	
	public ClientBase() {
		
	}

	public ClientBase(String name, String surname, String cpf, Date dateBirthday, String email,
			String telephoneNumber) {
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.dateBirthday = dateBirthday;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
	}
	
	public Date inactiveClient(Date date) {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDateBirthday() {
		return dateBirthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, name, surname, telephoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientBase other = (ClientBase) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname) && Objects.equals(telephoneNumber, other.telephoneNumber);
	}

	@Override
	public String toString() {
		return "ClientBase [name=" + name + ", surname=" + surname + ", cpf=" + cpf + ", dateBirthday=" + dateBirthday
				+ ", email=" + email + ", telephoneNumber=" + telephoneNumber + "]";
	}
	
	
}
