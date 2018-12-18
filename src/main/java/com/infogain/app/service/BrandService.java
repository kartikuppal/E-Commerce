package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.BrandDto;
import com.infogain.app.entity.Brand;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IBrandRepo;

@Service
public class BrandService implements IBrandService{
	@Autowired
	private IBrandRepo brandRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BrandService.class.getName());
	
	public BrandDto entityToDtoAssembler(BrandDto brandDto, Brand brand) {
		brandDto.setId(brand.getId());
		brandDto.setName(brand.getName());
		
		return brandDto;
	}
	
	public Brand dtoToEntityAssembler(BrandDto brandDto, Brand brand) {
		brand.setName(brandDto.getName());

		return brand;
	}
	
	/*inserting value*/
	
	public BrandDto insert(BrandDto brandDto) throws InvalidInputException {
		try {
			Brand brand = new Brand();
			brand = dtoToEntityAssembler(brandDto, brand);
			brandRepo.save(brand);
			brandDto.setId(brand.getId());
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return brandDto;
	}
	
	/*displaying all values*/
	
	public List<BrandDto> displayAll() {
		
		List<Brand> brandList = brandRepo.findAll();
		List<BrandDto> brandDtoList = new ArrayList<>();
		
		for(Brand brand : brandList) {
			BrandDto brandDto = new BrandDto();
			brandDto = entityToDtoAssembler(brandDto, brand);
			brandDtoList.add(brandDto);
			
			logger.info("display>>>>>>>>>>>>");
		}
		return brandDtoList;
	}
	
	/* displaying value by id */

	public BrandDto displayById(Integer id) {
		Brand brand = brandRepo.findById(id).get();
		BrandDto brandDto = new BrandDto();
		brandDto = entityToDtoAssembler(brandDto, brand);
		return brandDto;
	}

	/* updating value by id */

	public BrandDto update(BrandDto brandDto) throws InvalidInputException {
		try {
			Integer id = brandDto.getId();
			Brand brand = brandRepo.findById(id).get();
			brand = dtoToEntityAssembler(brandDto, brand);
			brand = brandRepo.save(brand);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return brandDto;
	}

	/* deleting value by id */

	public void delete(Integer id) {
		brandRepo.deleteById(id);
	}
}
