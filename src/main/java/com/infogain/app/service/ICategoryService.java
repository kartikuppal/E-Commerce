package com.infogain.app.service;

import java.util.List;

import com.infogain.app.dto.CategoryDto;
import com.infogain.app.exception.InvalidInputException;

public interface ICategoryService {
	public CategoryDto insert(CategoryDto categoryDto) throws InvalidInputException;
	public List<CategoryDto> displayAll();
	public CategoryDto displayById(Integer id);
	public CategoryDto update(CategoryDto categoryDto) throws InvalidInputException;
	public void delete(Integer id);
}
