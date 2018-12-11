package com.infogain.app.dto;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StoreDto {
	@Column(length=5)
	@NotNull(message = "Id cannot be null")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	@Column(length=50)
	private String name;
	
	@NotNull(message="Address cannot be blank")
	@Size(min=10,max=255)
	@Column(length=255)
	private String address;
	
	@NotNull(message="code cannot be null")
	//@Size(min=5,max=6,message = "size must be 6")
	@Column(length=6)
	@Min(6)
	@Max(6)
	private Integer postalCode;
	
	@NotNull(message="number cannot be null")
	@Min(10)
	@Max(10)
	@Column(unique=true)
	private BigInteger contactNo;
	
	/*private List<Integer> productId;
	
	private List<Integer> categoryId;*/
	
	public StoreDto() {
		super();
	}
	public StoreDto(Integer id, String name, String address, Integer postalCode, BigInteger contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.contactNo = contactNo;
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
	
	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", contactNo=" + contactNo + "]";
	}
}
