package com.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adult_client")
public class AdultClient extends ClientBase{
	
	
	private static final long serialVersionUID = 1L;

	public AdultClient() {
		super();
	}
	
	public AdultClient(String name, String surname, String cpf, LocalDate dateBirthday, String email, String telephoneNumber) {
		super(name, surname, cpf, dateBirthday, email, telephoneNumber);
	}

}
