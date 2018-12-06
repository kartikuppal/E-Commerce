package com.infogain.app.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {
	private Integer id;
	private String name;
	private Double price;
	private Date manufacturingDate;
	private Float weight;
	private String size;
	private Byte rating;
	List<Integer> store = new ArrayList<>();
	List<Integer> category = new ArrayList<>();
	List<Integer> brand = new ArrayList<>();
	public ProductDto() {
		super();
	}
	public ProductDto(Integer id, String name, Double price, Date manufacturingDate, Float weight, String size,
			Byte rating, List<Integer> store, List<Integer> category, List<Integer> brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.size = size;
		this.rating = rating;
		this.store = store;
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
	public List<Integer> getStore() {
		return store;
	}
	public void setStore(List<Integer> store) {
		this.store = store;
	}
	public List<Integer> getCategory() {
		return category;
	}
	public void setCategory(List<Integer> category) {
		this.category = category;
	}
	public List<Integer> getBrand() {
		return brand;
	}
	public void setBrand(List<Integer> brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", manufacturingDate="
				+ manufacturingDate + ", weight=" + weight + ", size=" + size + ", rating=" + rating + ", store="
				+ store + ", category=" + category + ", brand=" + brand + "]";
	}
}
