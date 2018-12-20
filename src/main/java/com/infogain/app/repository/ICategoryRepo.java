package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infogain.app.entity.Category;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

	Category findByName(String name);

}
