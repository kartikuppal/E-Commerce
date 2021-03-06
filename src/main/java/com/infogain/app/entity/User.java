package com.infogain.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String password;
	private String name;
	private String email;
	private String address;
	private String postalCode;
	private String mobileNumber;
	private Byte status;
	private String lastLogin;
	private String forgetPasswordToken;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Store> store = new ArrayList<>();
	
	@ManyToMany
	private List<Role> role;

	public User() {
		super();
	}

	public User(Integer id, String password, String name, String email, String address, String postalCode,
			String mobileNumber, Byte status, String lastLogin, String forgetPasswordToken, List<Role> role,
			List<Store> store) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.lastLogin = lastLogin;
		this.forgetPasswordToken = forgetPasswordToken;
		this.role = role;
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

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getForgetPasswordToken() {
		return forgetPasswordToken;
	}

	public void setForgetPasswordToken(String forgetPasswordToken) {
		this.forgetPasswordToken = forgetPasswordToken;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
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
				+ address + ", postalCode=" + postalCode + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", lastLogin=" + lastLogin + ", forgetPasswordToken=" + forgetPasswordToken + ", role=" + role
				+ ", store=" + store + "]";
	}

	
}
