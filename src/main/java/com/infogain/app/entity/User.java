package com.infogain.app.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User
{
	@Id
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=5)
	private Integer id;
	
	@NotNull(message="Password cannot be null")
	@Size(min=8, max=15)
	@Column(length=15)
	private String password;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	@Column(length=50)
	private String name;
	
	@NotNull(message="Email cannot be null")
	@Column(unique=true,length=60)
	private String email;
	
	@NotNull(message="Address cannot be blank")
	@Size(min=10,max=255)
	@Column(length=255)
	private String address;
	
	@NotNull(message="PostalCode cannot be null")
	//@Size(min=6,max=6)
	@Column(length=6)
	private Integer postalCode;
	
	@NotNull(message="Mobile Number cannot be null")
	//@Size(min=10,max=10)
	@Column(length=10)
	private BigInteger mobileNumber;
	
	@OneToMany
	private List<Store> store = new ArrayList<>();
	
	public User() {
		super();
	}

	public User(Integer id, @NotNull(message = "Password cannot be null") @Size(min = 8, max = 15) String password,
			@NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name, @NotNull String email,
			@NotNull(message = "Address cannot be blank") @Size(min = 10, max = 255) String address,
			@NotNull @Size(min = 6, max = 6) Integer postalCode,
			@NotNull @Size(min = 10, max = 10) BigInteger mobileNumber, List<Store> store) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.mobileNumber = mobileNumber;
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

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + ", postalCode=" + postalCode + ", mobileNumber=" + mobileNumber + ", store=" + store + "]";
	}

	
}
