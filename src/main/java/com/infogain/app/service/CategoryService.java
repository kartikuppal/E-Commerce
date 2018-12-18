package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.CategoryDto;
import com.infogain.app.entity.Category;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.ICategoryRepo;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private ICategoryRepo categoryRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class.getName());

	public CategoryDto entityToDtoAssembler(CategoryDto categoryDto, Category category) {
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		
		return categoryDto;
	}
	
	public Category dtoToEntityAssembler(CategoryDto categoryDto, Category category) {
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());

		return category;
	}
	
	/*inserting value*/
	
	public CategoryDto insert(CategoryDto categoryDto) throws InvalidInputException {
		try {
			Category category = new Category();
			category = dtoToEntityAssembler(categoryDto, category);
			categoryRepo.save(category);
			categoryDto.setId(category.getId());
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return categoryDto;
	}
	
	/*displaying all values*/
	
	public List<CategoryDto> displayAll() {
		
		List<Category> categoryList = categoryRepo.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<>();
		
		for(Category category : categoryList) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto = entityToDtoAssembler(categoryDto, category);
			categoryDtoList.add(categoryDto);
			
			logger.info("display>>>>>>>>>>>>");
		}
		return categoryDtoList;
	}

	/* displaying value by id */

	public CategoryDto displayById(Integer id) {
		Category category = categoryRepo.findById(id).get();
		CategoryDto categoryDto = new CategoryDto();
		categoryDto = entityToDtoAssembler(categoryDto, category);
		return categoryDto;
	}

	/* updating value by id */

	public CategoryDto update(CategoryDto categoryDto) throws InvalidInputException {
		try {
			Integer id = categoryDto.getId();
			Category category = categoryRepo.findById(id).get();
			category = dtoToEntityAssembler(categoryDto, category);
			category = categoryRepo.save(category);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return categoryDto;
	}

	/* deleting value by id */

	public void delete(Integer id) {
		categoryRepo.deleteById(id);
	}
}
