package com.infogain.app.dto;

public class RoleDto {

	private Integer id;
	private String name;
	public RoleDto() {
	}
	public RoleDto(Integer id, String name) {
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
		return "RoleDto [id=" + id + ", name=" + name + "]";
	}
}