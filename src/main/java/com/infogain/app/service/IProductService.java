package com.infogain.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.exception.InvalidInputException;

public interface IProductService {
	public ProductDto insert(ProductDto productDto) throws InvalidInputException;
	public List<ProductDto> displayAll();
	public ProductDto displayById(Integer id);
	public ProductDto update(ProductDto productDto) throws InvalidInputException;
	public void delete(Integer id);
}
