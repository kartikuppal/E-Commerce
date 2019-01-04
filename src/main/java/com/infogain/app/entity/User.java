package com.infogain.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
=======
	@GeneratedValue(strategy=GenerationType.AUTO)
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	@Column(length=5,columnDefinition="Integer(5) default 0"/*,columnDefinition = "Integer default 1"*/)
	private Integer id;
	private String password;
	private String name;
	private String email;
	private String address;
	private String postalCode;
	private String mobileNumber;
	private Byte status;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Store> store = new ArrayList<>();

	public User() {
		super();
	}

	public User(Integer id, String password, String name, String email, String address, String postalCode,
			String mobileNumber, Byte status, List<Store> store) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + ", postalCode=" + postalCode + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", store=" + store + "]";
	}

}
