package com.infogain.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.Product;
import com.infogain.app.entity.User;
import com.infogain.app.repository.IProductRepo;

@Service
public class ProductService implements IProductService{

	@Autowired
	IProductRepo productRepo;
	
	@Override
	public List<Product> displayAllProduct() {
		List<Product> product = productRepo.findAll();
		return product;
		
	}

	@Override
	public Product displayProductById(Integer id) {
		Product product = productRepo.findById(id).get();
		return product;
	}

	@Override
	public Product insertProduct(Product product) throws ProductException {
				
		if(product.getPrice()<0)
		{
			throw new ProductException("Price cannot be negative");
		}
		else if(product.getWeight()<0)
		{
			throw new ProductException("Weight cannot be negative");
		}
		else if(product.getRating()<0 || product.getRating()>10)
		{
			throw new ProductException("Rating can be given between 0 to 10 only");
		}
		
		else{
		
		product.setName(product.getName());
		product.setPrice(product.getPrice());
		product.setManufacturingDate(product.getManufacturingDate());
		product.setWeight(product.getWeight());
		product.setSize(product.getSize());
		product.setRating(product.getRating());
		}
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product productDetail, Integer id) throws ProductException {
		Product product = productRepo.findById(id).get();
		if(productDetail.getPrice()<0)
		{
			throw new ProductException("Price cannot be negative");
		}
		else if(productDetail.getWeight()<0)
		{
			throw new ProductException("Weight cannot be negative");
		}
		else if(productDetail.getRating()<0 || productDetail.getRating()>10)
		{
			throw new ProductException("Rating can be given between 0 to 10 only");
		}
		
		else{
		
		
		product.setName(productDetail.getName());
		product.setPrice(productDetail.getPrice());
		product.setManufacturingDate(productDetail.getManufacturingDate());
		product.setWeight(productDetail.getWeight());
		product.setSize(productDetail.getSize());
		product.setRating(productDetail.getRating());
		}
		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
	
		productRepo.deleteById(id);
		
	}
	

}
