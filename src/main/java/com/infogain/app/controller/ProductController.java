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

import com.infogain.app.dto.ProductDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@PostMapping("/product")
	public ProductDto insert(@RequestBody @Valid ProductDto productDto) throws InvalidInputException {
		return productService.insert(productDto);
	}
	
	@GetMapping("/product")
	public List<ProductDto> displayAll(@RequestBody ProductDto productDto) {
		return productService.displayAll();
	}

	@GetMapping("/product/{id}")
	public ProductDto displayById(@PathVariable(value = "id") Integer productId) {
		return productService.displayById(productId);
	}
	
	@PutMapping("/product")
	public ProductDto update(@RequestBody @Valid ProductDto productDto) throws InvalidInputException {
		return productService.update(productDto);
	}

	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable(value = "id") Integer productId) {
		productService.delete(productId);
	}
}
