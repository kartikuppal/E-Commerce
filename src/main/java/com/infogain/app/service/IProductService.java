package com.infogain.app.service;

import java.util.List;

import com.infogain.app.entity.Product;

public interface IProductService {
	public List<Product> displayAllProduct();
	public Product displayProductById(Integer id);
	public Product insertProduct(Product user) throws ProductException;
	public Product updateProduct(Product user, Integer id) throws ProductException;
	public void deleteProduct(Integer id);

}
