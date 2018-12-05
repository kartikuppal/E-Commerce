package com.infogain.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=5)
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	@Column(length=50)
	private String name;
	
	@ManyToMany(mappedBy="brand")
	List<Product> product = new ArrayList<>();

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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Brand(Integer id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", product=" + product + "]";
	}
	

}
