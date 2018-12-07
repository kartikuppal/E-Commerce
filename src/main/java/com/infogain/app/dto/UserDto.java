package com.infogain.app.dto;

import java.math.BigInteger;
import java.util.List;

public class UserDto {
	private Integer id;
	private String password;
	private String name;
	private String email;
	private String address;
	private Integer postalCode;
	private BigInteger mobileNumber;
	private Byte status;
	private List<Integer> storeId;

	public UserDto() {

	}

	
	public UserDto(Integer id, String password, String name, String email, String address, Integer postalCode,
			BigInteger mobileNumber, Byte status, List<Integer> storeId) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.storeId = storeId;
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
	

	public Byte getStatus() {
		return status;
	}


	public void setStatus(Byte status) {
		this.status = status;
	}


	public List<Integer> getStoreId() {
		return storeId;
	}

	public void setStoreId(List<Integer> storeId) {
		this.storeId = storeId;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + ", postalCode=" + postalCode + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", storeId=" + storeId + "]";
	}

	

}
