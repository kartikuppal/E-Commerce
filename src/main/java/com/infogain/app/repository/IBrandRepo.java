package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import com.infogain.app.entity.Brand;

public interface IBrandRepo extends JpaRepository<Brand, Integer> {
	Brand findByName(String name);
=======

import com.infogain.app.entity.Brand;

public interface IBrandRepo extends JpaRepository<Brand, Integer>{

	public Brand findByName(String name);

>>>>>>> 7dd7faed42c06206121171f492f4016151683369
}
