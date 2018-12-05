package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.Brand;

public interface IBrandRepo extends JpaRepository<Brand, Integer>{

	public Brand findByName(String name);

}
