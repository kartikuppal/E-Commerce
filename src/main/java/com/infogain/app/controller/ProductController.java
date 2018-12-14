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
import com.infogain.app.repository.IProductRepo;
import com.infogain.app.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	IProductRepo productRepo;
	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public ProductDto productInsert(@RequestBody @Valid ProductDto productDto) throws InvalidInputException {
		return productService.insertProduct(productDto);
	}
	
	@GetMapping("/product")
	public List<ProductDto> displayAllProducts(@RequestBody ProductDto productDto) {
		return productService.displayAllProduct();
	}

	@GetMapping("/product/{id}")
	public ProductDto displayUserById(@PathVariable(value = "id") Integer productId) {
		return productService.displayProductById(productId);
	}
	
	@PutMapping("/product")
	public ProductDto updateProduct(@RequestBody ProductDto productDto) throws InvalidInputException {
		return productService.updateProduct(productDto);
	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable(value = "id") Integer productId) {
		productService.deleteProduct(productId);
	}
}
