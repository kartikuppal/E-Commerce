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

import com.infogain.app.dto.BrandDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.BrandServiceImpl;

@RestController
@RequestMapping("/api")
public class BrandController {
	@Autowired
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
	}
}
