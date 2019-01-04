package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======

>>>>>>> 7dd7faed42c06206121171f492f4016151683369
import com.infogain.app.entity.Category;

public interface ICategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByName(String name);
<<<<<<< HEAD
=======

>>>>>>> 7dd7faed42c06206121171f492f4016151683369
}
