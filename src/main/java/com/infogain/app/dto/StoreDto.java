package com.infogain.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StoreDto {
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	private String name;
	
	@NotNull(message="Address cannot be blank")
	@Size(min=10,max=255)
	private String address;
	
	@NotNull(message="postal Code cannot be null")
	@Pattern(regexp="(^[0-9]{6}$)|(^$)", message="Invalid postal Code format")
	private String postalCode;
	
	@NotNull(message="contact number cannot be null")
	@Pattern(regexp="(^[1-9]{1}[0-9]{9}$)|(^$)", message="Invalid Phone Number format")
	private String contactNo;
	
	/*private List<Integer> productId;
	
	private List<Integer> categoryId;*/
	
	public StoreDto() {
		super();
	}
	public StoreDto(Integer id, String name, String address, String postalCode, String contactNo) {
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
	
	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", contactNo=" + contactNo + "]";
	}
}
