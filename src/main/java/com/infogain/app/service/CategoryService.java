package com.infogain.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.Category;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.ICategoryRepo;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	ICategoryRepo categoryRepo;
	
	/*inserting values*/
	
	public Category insertCategory(Category category) throws CustomException {

		Category existingCategory = categoryRepo.findByName(category.getName());
		
		if(existingCategory == null)
		{
			category.setName(category.getName());
			category.setDescription(category.getDescription());
		}
		else
		{
			throw new CustomException("category Name already exists");
		}
		return categoryRepo.save(category);
	}
	
	/*displaying values*/
	
	public List<Category> displayAllCategorys() {
		return categoryRepo.findAll();
	}
	
	/*displaying values by id*/
	
	public Category displayCategoryById(Integer id) {
		return categoryRepo.findById(id).get();
	}
	
	/*updating values by id*/
	
	public Category updateCategory(Category updatedCategory, Integer id) throws CustomException {
		
		Category category = categoryRepo.findById(id).get();
		
		Category existingCategory = categoryRepo.findByName(updatedCategory.getName());
		
		if(existingCategory == null)
		{
			category.setName(updatedCategory.getName());
			category.setDescription(updatedCategory.getDescription());
		}
		else
		{
			throw new CustomException("category Name already exists");
		}
		return categoryRepo.save(category);
	}
	
	/*deleting values by id*/
	
	public void deleteCategory(Integer id) {
		categoryRepo.deleteById(id);
	}
}
