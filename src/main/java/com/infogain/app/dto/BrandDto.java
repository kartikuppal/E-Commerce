package com.infogain.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BrandDto {
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	private String name;
	
	/*private List<Product> product = new ArrayList<>();*/
	
	public BrandDto() {
		super();
	}
	
	public BrandDto(Integer id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "BranDto [id=" + id + ", name=" + name + "]";
	}
}
