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

import com.infogain.app.dto.ProductDto;
import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IProductRepo;
import com.infogain.app.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	IProductRepo productRepo;

	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<ProductDto> displayAllProducts(@RequestBody ProductDto productDto) {
		return productService.displayAllProduct();

	}

	@GetMapping("/product/{id}")
	public ProductDto displayUserById(@PathVariable(value = "id") Integer productId) {
		return productService.displayProductById(productId);

	}

	@PostMapping("/product")
	public ProductDto productInsert(@RequestBody ProductDto productDto) throws CustomException {
		return productService.insertProduct(productDto);

	}

	@PutMapping("/product/{id}")
	public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable(value = "id") Integer productId)
			throws CustomException {
		return productService.updateProduct(productDto, productId);

	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable(value = "id") Integer productId) {
		productService.deleteProduct(productId);
	}

}
