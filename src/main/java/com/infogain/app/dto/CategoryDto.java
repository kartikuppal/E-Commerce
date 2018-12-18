package com.infogain.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDto {
	private Integer id;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=50)
	private String name;
	
	@NotNull(message="Address cannot be blank")
	@Size(min=10,max=255)
	String description;
	

	/*List<Product> product = new ArrayList<>();
	List<Store> store = new ArrayList<>();*/
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(Integer id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50) String name,
			@NotNull(message = "Address cannot be blank") @Size(min = 10, max = 255) String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
