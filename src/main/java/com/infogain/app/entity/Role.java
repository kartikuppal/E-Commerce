package com.infogain.app.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@ManyToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<User> user;
	
	public Role() {
		}

/*	
	public Role(Integer id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}*/
	@JsonCreator
	public Role(@JsonProperty("id") Integer id, @JsonProperty("name")String name) {
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
	
	@JsonIgnore
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name +  "]";
	}

	

}
