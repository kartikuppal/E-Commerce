package com.infogain.app.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String address;
	
	private Integer postalCode;
	
	private BigInteger contactNo;

	@ManyToMany(fetch=FetchType.EAGER)
	List<Product> product = new ArrayList<>();
	
	@ManyToMany
	List<Category> category = new ArrayList<>();

	public Store() {
		super();
	}

	public Store(Integer id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name,
			@NotNull(message = "Address cannot be blank") @Size(min = 10, max = 255) String address,
			@NotNull @Size(min = 6, max = 6) Integer postalCode,
			@NotNull @Size(min = 10, max = 10) BigInteger contactNo, List<Product> product, List<Category> category) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.contactNo = contactNo;
		this.product = product;
		this.category = category;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", contactNo=" + contactNo +", category=" + category + "]";
	}
}
