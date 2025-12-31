package com.model.entities;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItensProperty{
	
	private SimpleStringProperty bookName;
	private SimpleStringProperty authorBook;
	private SimpleStringProperty country;
	private SimpleIntegerProperty age;
	private SimpleDoubleProperty price;
	private SimpleDoubleProperty priceMarket;
	
	public ItensProperty(String bookName, String authorBook, String country, Integer age, Double price, Double priceMarket) {
		this.bookName = new SimpleStringProperty(bookName);
		this.authorBook = new SimpleStringProperty(authorBook);
		this.country = new SimpleStringProperty(country);
		this.age = new SimpleIntegerProperty(age);
		this.price = new SimpleDoubleProperty(price);
		this.priceMarket = new SimpleDoubleProperty(priceMarket);
	}
	
	public String getBookName() {
		return bookName.get();
	}
	
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}
	
	public String getAuthorName() {
		return authorBook.get();
	}
	
	public void setauthorBookName(String authorBook) {
		this.authorBook.set(authorBook);
	}
	
	public String getcountry() {
		return country.get();
	}
	
	public void setcountry(String country) {
		this.bookName.set(country);
	}
	
	public Integer getaAge() {
		return age.get();
	}
	
	public void setAge(Integer age) {
		this.age.set(age);
	}
	
	public Double getPrice() {
		return price.get();
	}
	
	public void setPrice(Double price) {
		this.price.set(price);
	}
	
	public Double getPriceMarket() {
		return price.get();
	}
	
	public void setPriceMarket(Double priceMarket) {
		this.priceMarket.set(priceMarket);
	}
}