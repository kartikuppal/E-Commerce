package com.infogain.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
<<<<<<< HEAD
	private String postalCode;
	private String contactNo;
=======
	
	@NotNull
	//@Size(min=6,max=6)
	@Column(length=6)
	private Integer postalCode;
	
	@NotNull
	//@Size(min=10,max=10)
	@Column(unique=true,length=10)
	private BigInteger contactNo;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369

	@ManyToMany(fetch=FetchType.EAGER)
	List<Product> product = new ArrayList<>();
	
	@ManyToMany
	List<Category> category = new ArrayList<>();

	public Store() {
		super();
	}

	public Store(Integer id, String name, String address, String postalCode, String contactNo, List<Product> product,
			List<Category> category) {
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
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
