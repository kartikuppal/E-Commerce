package com.infogain.app.controller;

import java.util.List;

<<<<<<< HEAD
import javax.validation.Valid;

=======
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.infogain.app.dto.BrandDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.BrandServiceImpl;
=======
import com.infogain.app.entity.Brand;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IBrandRepo;
import com.infogain.app.service.BrandService;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369

@RestController
@RequestMapping("/api")
public class BrandController {
	@Autowired
<<<<<<< HEAD
    private BrandServiceImpl brandService;
	
	@PostMapping("/brand")
	public BrandDto insert(@RequestBody @Valid BrandDto brandDto) throws InvalidInputException {
		return brandService.insert(brandDto);
	}
	
	@GetMapping("/brand")
	public List<BrandDto> displayAll(@RequestBody BrandDto brandDto) {
		return brandService.displayAll();
	}
	
	@GetMapping("/brand/{id}")
	public BrandDto displayById(@PathVariable(value = "id") Integer brandId) {
		return brandService.displayById(brandId);
	}
	
	@PutMapping("/brand")
	public BrandDto update(@RequestBody @Valid BrandDto brandDto) throws InvalidInputException {
		return brandService.update(brandDto);
	}

	@DeleteMapping("/brand/{id}")
	public void delete(@PathVariable(value = "id") Integer brandId) {
		brandService.delete(brandId);
=======
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
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	}
}
