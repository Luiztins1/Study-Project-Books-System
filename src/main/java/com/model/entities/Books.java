package com.model.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.GenerationType;

@Entity
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String author;
	private String country;
	private Integer age;
	private Double price;
	private Double priceMarket;
	//private PriceCategory priceCategory;
	
	public Books() {
		
	}
	
	public Books(Integer id, String name, String author, String country, Integer age, Double price,
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
