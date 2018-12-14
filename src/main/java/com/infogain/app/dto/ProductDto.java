package com.infogain.app.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.infogain.app.entity.Brand;
import com.infogain.app.entity.Category;

public class ProductDto {
	private Integer id;

	@NotNull(message="Name cannot be null")
	@Size(min=4, max=50)
	private String name;

	@NotNull(message="price cannot be null")
	@Column(length=12)
	private Double price;
	
	//@NotNull(message="date cannot be null")
	private Date manufacturingDate;
	
	@Column(length=8)
	private Float weight;
	
	//@NotNull(message="weight cannot be null")
	@Column(length=16)
	private String size;
	
	@NotNull(message="rating cannot be null")
	@Column(length=2)
	private Byte rating;
	
	private List<Category> category;
	private List<Brand> brand;
	
	public ProductDto() {
		super();
	}
	
	public ProductDto(Integer id, @NotNull(message = "Name cannot be null") @Size(min = 10, max = 50) String name,
			@NotNull(message = "price cannot be null") Double price, Date manufacturingDate, Float weight, String size,
			@NotNull(message = "rating cannot be null") Byte rating, List<Category> category, List<Brand> brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.size = size;
		this.rating = rating;
		this.category = category;
		this.brand = brand;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Byte getRating() {
		return rating;
	}
	public void setRating(Byte rating) {
		this.rating = rating;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<Brand> getBrand() {
		return brand;
	}
	public void setBrand(List<Brand> brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", manufacturingDate="
				+ manufacturingDate + ", weight=" + weight + ", size=" + size + ", rating=" + rating + ", category="
				+ category + ", brand=" + brand + "]";
	}
}
