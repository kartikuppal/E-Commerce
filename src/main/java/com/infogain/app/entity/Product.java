package com.infogain.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Double price;
	private Date manufacturingDate;
	private Float weight;
	private String size;
	private Byte rating;
	
	@ManyToMany(mappedBy = "product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Store> store = new ArrayList<>();

	@ManyToMany
	List<Brand> brand = new ArrayList<>();

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}
	
	@JsonIgnore
	public List<Store> getStore() {
		return store;
	}
	
	
	/*public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}*/


	public void setStore(List<Store> store) {
		this.store = store;
	}

	public List<Brand> getBrand() {
		return brand;
	}

	public void setBrand(List<Brand> brand) {
		this.brand = brand;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, Double price, Date manufacturingDate, Float weight, String size,
			Byte rating, List<Store> store, List<Brand> brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.size = size;
		this.rating = rating;
		this.store = store;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacturingDate=" + manufacturingDate
				+ ", weight=" + weight + ", size=" + size + ", rating=" + rating + ", store=" + store + ", brand=" + brand + "]";
	}

}
