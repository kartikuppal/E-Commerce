package com.infogain.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=5)
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	@Column(length=50)
	private String name;
	
	@NotNull
	@Column(length=255)
	String description;

	@OneToMany(fetch=FetchType.EAGER)
	List<Product> product = new ArrayList<>();
	
	@ManyToMany(mappedBy="category")
	List<Store> store = new ArrayList<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

	public Category() {
		super();
	}

	public Category(Integer id, String name, String description, List<Product> product, List<Store> store) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.product = product;
		this.store = store;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", product=" + product
				+ ", store=" + store + "]";
	}
}
