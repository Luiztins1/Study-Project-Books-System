package com.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String author;
	
	@Column(length = 20)
	private String country;
	
	@Column(length = 10)
	private Date age;
	
	@Column(length = 255)
	private Double price;
	
	@Column(length = 255)
	private Double priceMarket;

	public Books() {

	}

	public Books(Integer id, String name, String author, String country, Date age, Double price,
			double priceMarket) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.country = country;
		this.age = age;
		this.price = price;
		this.priceMarket = priceMarket;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double getPriceMarket() {
		return priceMarket;
	}

	public void setPriceMarket(double priceMarket) {
		this.priceMarket = priceMarket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", country=" + country + ", age=" + age
				+ ", price=" + price + ", priceMarket=" + priceMarket + "]";
	}

}
