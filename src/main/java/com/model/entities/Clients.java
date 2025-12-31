package com.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 25)
	private String name;
	
	@Column(length = 15)
	private String surname;
	
	@Column(length = 14)
	private String cpf;
	
	@Column(length = 10)
	private LocalDate dateBirthday;
	
	@Column(length = 60)
	private String email;
	
	@Column(length = 14)
	private String telephoneNumber; 
	
	public Clients() {
		
	}

	public Clients(String name, String surname, String cpf, LocalDate dateBirthday, String email,
			String telephoneNumber) {
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.dateBirthday = dateBirthday;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
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
		return Objects.hash(cpf, dateBirthday, email, id, name, surname, telephoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dateBirthday, other.dateBirthday)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname)
				&& Objects.equals(telephoneNumber, other.telephoneNumber);
	}

	@Override
	public String toString() {
		return "ClientBase [id=" + id + ", name=" + name + ", surname=" + surname + ", cpf=" + cpf + ", dateBirthday="
				+ dateBirthday + ", email=" + email + ", telephoneNumber=" + telephoneNumber + "]";
	}
	

	
	
}
