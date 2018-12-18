package com.infogain.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.CategoryDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.ICategoryRepo;
import com.infogain.app.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ICategoryRepo categoryRepo;
	
	@PostMapping("/category")
	public CategoryDto insert(@RequestBody @Valid CategoryDto categoryDto) throws InvalidInputException {
		return categoryService.insert(categoryDto);
	}
	
	@GetMapping("/category")
	public List<CategoryDto> displayAll(@RequestBody CategoryDto categoryDto) {
		return categoryService.displayAll();
	}
	
	@GetMapping("/category/{id}")
	public CategoryDto displayById(@PathVariable(value = "id") Integer categoryId) {
		return categoryService.displayById(categoryId);
	}
	
	@PutMapping("/category")
	public CategoryDto updateCategory(@RequestBody @Valid CategoryDto categoryDto) throws InvalidInputException {
		return categoryService.update(categoryDto);
	}

	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable(value = "id") Integer categoryId) {
		categoryService.delete(categoryId);
	}
}
