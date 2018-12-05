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

import com.infogain.app.entity.Brand;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IBrandRepo;
import com.infogain.app.service.BrandService;

@RestController
@RequestMapping("/api")
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@Autowired
	IBrandRepo brandRepo;
	
	@PostMapping("/brand")
	public Brand insertBrand(@RequestBody Brand brand) throws CustomException {
		return brandService.insertBrand(brand);
	}
	
	@GetMapping("/brand")
	public List<Brand> displayAllBrands(@RequestBody Brand brand) {
		return brandService.displayAllBrands();
	}
	
	@GetMapping("/brand/{id}")
	public Brand displayBrandById(@PathVariable(value = "id") Integer brandId) {
		return brandService.displayBrandById(brandId);
	}
	
	@PutMapping("/brand/{id}")
	public Brand updateBrand(@RequestBody Brand brand, @PathVariable(value = "id") Integer brandId) throws CustomException {
		return brandService.updateBrand(brand, brandId);
	}

	@DeleteMapping("/brand/{id}")
	public void deleteBrand(@PathVariable(value = "id") Integer brandId) {
		brandService.deleteBrand(brandId);
	}
}
