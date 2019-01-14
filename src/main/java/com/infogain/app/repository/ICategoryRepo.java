package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.app.entity.Category;
@Repository
public interface ICategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByName(String name);
}
