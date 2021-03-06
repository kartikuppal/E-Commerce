package com.infogain.app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infogain.app.entity.Role;
import com.infogain.app.entity.Store;

public class UserDto {
	private Integer id;

	@Size(min = 8, max = 15)
	private String password;

	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 50)
	private String name;

	@NotNull(message = "email cannot be null")
	@Email(message = "email should be in correct format")
	@Size(min = 2, max = 50)
	private String email;

	@NotNull(message = "Address cannot be blank")
	@Size(min = 10, max = 255)
	private String address;

	@NotNull(message = "PostalCode cannot be null")
	@Size(min = 6, max = 6)
	@Column(length = 6)
	@Pattern(regexp = "(^[0-9]{6}$)|(^$)", message = "Invalid postal Code format")
	private String postalCode;

	@NotNull(message = "Mobile number cannot be null")
	@Pattern(regexp = "(^[1-9]{1}[0-9]{9}$)|(^$)", message = "Invalid Phone Number format")
	private String mobileNumber;
	private Byte status;
	private String lastLogin;
	private String forgetPasswordToken;	
	@JsonIgnore
	private List<Role> role;
	
	
	public UserDto() {
	}


	public UserDto(Integer id, @Size(min = 8, max = 15) String password,
			@NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name,
			@NotNull(message = "email cannot be null") @Email(message = "email should be in correct format") @Size(min = 2, max = 50) String email,
			@NotNull(message = "Address cannot be blank") @Size(min = 10, max = 255) String address,
			@NotNull(message = "PostalCode cannot be null") @Size(min = 6, max = 6) @Pattern(regexp = "(^[0-9]{6}$)|(^$)", message = "Invalid postal Code format") String postalCode,
			@NotNull(message = "Mobile number cannot be null") @Pattern(regexp = "(^[1-9]{1}[0-9]{9}$)|(^$)", message = "Invalid Phone Number format") String mobileNumber,
			Byte status, String lastLogin, String forgetPasswordToken, List<Role> role) {
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


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + ", postalCode=" + postalCode + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", lastLogin=" + lastLogin + ", forgetPasswordToken=" + forgetPasswordToken + ", role=" + role + "]";
	}
	
	
}
