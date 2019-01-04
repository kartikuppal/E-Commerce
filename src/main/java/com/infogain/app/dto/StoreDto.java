package com.infogain.app.dto;

<<<<<<< HEAD
import java.util.List;

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
	
	private List<Integer> productId;
	
=======
import java.math.BigInteger;
import java.util.List;

public class StoreDto {
	private Integer id;
	private String name;
	private String address;
	private Integer postalCode;
	private BigInteger contactNo;
	private List<Integer> productId;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	private List<Integer> categoryId;
	
	public StoreDto() {
		super();
	}
<<<<<<< HEAD

	public StoreDto(Integer id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name,
			@NotNull(message = "Address cannot be blank") @Size(min = 10, max = 255) String address,
			@NotNull(message = "postal Code cannot be null") @Pattern(regexp = "(^[0-9]{6}$)|(^$)", message = "Invalid postal Code format") String postalCode,
			@NotNull(message = "contact number cannot be null") @Pattern(regexp = "(^[1-9]{1}[0-9]{9}$)|(^$)", message = "Invalid Phone Number format") String contactNo,
=======
	public StoreDto(Integer id, String name, String address, Integer postalCode, BigInteger contactNo,
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
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
<<<<<<< HEAD

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

=======
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
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", contactNo=" + contactNo + ", productId=" + productId + ", categoryId=" + categoryId + "]";
	}
}
