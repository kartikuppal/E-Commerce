package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.app.entity.Brand;
@Repository
public interface IBrandRepo extends JpaRepository<Brand, Integer> {
	Brand findByName(String name);
}
