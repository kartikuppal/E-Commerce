package com.infogain.app.dto;

import java.math.BigInteger;
import java.util.List;

public class StoreDto {
	private Integer id;
	private String name;
	private String address;
	private Integer postalCode;
	private BigInteger contactNo;
	private List<Integer> productId;
	private List<Integer> categoryId;
	
	public StoreDto() {
		super();
	}
	public StoreDto(Integer id, String name, String address, Integer postalCode, BigInteger contactNo,
			List<Integer> productId, List<Integer> categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.contactNo = contactNo;
		this.productId = productId;
		this.categoryId = categoryId;
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
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	public List<Integer> getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", contactNo=" + contactNo + ", productId=" + productId + ", categoryId=" + categoryId + "]";
	}
}
