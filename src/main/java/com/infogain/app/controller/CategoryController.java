package com.infogain.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.entity.Category;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.ICategoryRepo;
import com.infogain.app.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ICategoryRepo categoryRepo;
	
	@PostMapping("/category")
	public Category insertCategory(@RequestBody Category category) throws CustomException {
		return categoryService.insertCategory(category);
	}
	
	@GetMapping("/category")
	public List<Category> displayAllCategorys(@RequestBody Category category) {
		return categoryService.displayAllCategorys();
	}
	
	@GetMapping("/category/{id}")
	public Category displayCategoryById(@PathVariable(value = "id") Integer categoryId) {
		return categoryService.displayCategoryById(categoryId);
	}
	
	@PutMapping("/category/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable(value = "id") Integer categoryId) throws CustomException {
		return categoryService.updateCategory(category, categoryId);
	}

	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable(value = "id") Integer categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
