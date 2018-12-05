package com.infogain.app.service;

import java.util.List;

import com.infogain.app.entity.Category;
import com.infogain.app.exception.CustomException;

public interface ICategoryService {
	public Category insertCategory(Category category) throws CustomException;
	public List<Category> displayAllCategorys();
	public Category displayCategoryById(Integer id);
	public Category updateCategory(Category updatedCategory, Integer id) throws CustomException;
	public void deleteCategory(Integer id);
}
