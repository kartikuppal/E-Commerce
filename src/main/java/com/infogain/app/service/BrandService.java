package com.infogain.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.Brand;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IBrandRepo;

@Service
public class BrandService {
	@Autowired
	IBrandRepo brandRepo;
	
	/*inserting values*/
	
	public Brand insertBrand(Brand brand) throws CustomException {

		Brand existingBrand = brandRepo.findByName(brand.getName());
		
		if(existingBrand == null)
		{
			brand.setName(brand.getName());
		}
		else
		{
			throw new CustomException("Brand Name already exists");
		}
		return brandRepo.save(brand);
	}
	
	/*displaying values*/
	
	public List<Brand> displayAllBrands() {
		return brandRepo.findAll();
	}
	
	/*displaying values by id*/
	
	public Brand displayBrandById(Integer id) {
		return brandRepo.findById(id).get();
	}
	
	/*updating values by id*/
	
	public Brand updateBrand(Brand updatedBrand, Integer id) throws CustomException {
		
		Brand brand = brandRepo.findById(id).get();
		
		Brand existingBrand = brandRepo.findByName(updatedBrand.getName());
		
		if(existingBrand == null)
		{
			brand.setName(updatedBrand.getName());
		}
		else
		{
			throw new CustomException("Brand Name already exists");
		}
		return brandRepo.save(brand);
	}
	
	/*deleting values by id*/
	
	public void deleteBrand(Integer id) {
		brandRepo.deleteById(id);
	}
}
