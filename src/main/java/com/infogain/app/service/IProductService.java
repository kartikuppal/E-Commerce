package com.infogain.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.exception.InvalidInputException;

public interface IProductService {
	public ProductDto insertProduct(@RequestBody @Valid ProductDto productDto) throws InvalidInputException;
	public List<ProductDto> displayAllProduct();
	public ProductDto displayProductById(Integer id);
	public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto) throws InvalidInputException;
	public void deleteProduct(Integer id);
}
