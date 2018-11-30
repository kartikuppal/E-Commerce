package com.infogain.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=10)
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	@Column(length=50)
	private String name;
	
	@NotNull(message="Price cannot be Negati")
	@Column(length=12)
	@Size(min=1)
	private Double price;
	
	@NotNull
	private Date manufacturingDate;
	
	@NotNull
	@Column(length=8)
	private Float weight;
	
	@Column(length=16)
	private String size;
	
	@Column(length=2)
	private Byte rating;

	@ManyToMany(mappedBy = "product")
	List<Store> store = new ArrayList<>();

	@ManyToMany(mappedBy = "product")
	List<Category> category = new ArrayList<>();

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

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
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
			Byte rating, List<Store> store, List<Category> category, List<Brand> brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.size = size;
		this.rating = rating;
		this.store = store;
		this.category = category;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacturingDate=" + manufacturingDate
				+ ", weight=" + weight + ", size=" + size + ", rating=" + rating + ", store=" + store + ", category="
				+ category + ", brand=" + brand + "]";
	}

}
