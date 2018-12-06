package com.infogain.app.service;

import java.util.List;

import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;

public interface IProductService {
	public List<Product> displayAllProduct();
	public Product displayProductById(Integer id);
	public Product insertProduct(Product user) throws CustomException;
	public Product updateProduct(Product user, Integer id) throws CustomException;
	public void deleteProduct(Integer id);

}
