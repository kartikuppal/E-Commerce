package com.infogain.app.service;

import java.util.List;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;

public interface IProductService {
	public List<ProductDto> displayAllProduct();
	public ProductDto displayProductById(Integer id);
	public ProductDto insertProduct(ProductDto productDto) throws CustomException;
	public ProductDto updateProduct(ProductDto productDto, Integer id) throws CustomException;
	public void deleteProduct(Integer id);

}
