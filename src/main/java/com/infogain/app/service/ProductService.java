package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IProductRepo;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductRepo productRepo;
	
	public ProductDto entityToDtoAssembler(ProductDto productDto, Product product) {
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setManufacturingDate(product.getManufacturingDate());
		productDto.setPrice(product.getPrice());
		productDto.setSize(product.getSize());
		productDto.setRating(product.getRating());
		productDto.setWeight(product.getWeight());
		
		return productDto;
	}
	
	public Product dtoToEntityAssembler(ProductDto productDto, Product product) {
		product.setName(productDto.getName());
		product.setManufacturingDate(productDto.getManufacturingDate());
		product.setPrice(productDto.getPrice());
		product.setSize(productDto.getSize());
		product.setRating(productDto.getRating());
		product.setWeight(productDto.getWeight());
		
		return product;
	}
	
	public ProductDto insertProduct(@RequestBody @Valid ProductDto productDto) throws InvalidInputException {
		try {
			Product product = new Product();
			product = dtoToEntityAssembler(productDto, product);
			productRepo.save(product);
			productDto.setId(product.getId());
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return productDto;
	}
	
	public List<ProductDto> displayAllProduct() {
		List<Product> productList = productRepo.findAll();
		List<ProductDto> productDtoList = new ArrayList<>();
		
		for (Product product : productList) {
			ProductDto productDto = new ProductDto();
			productDto = entityToDtoAssembler(productDto, product);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}
	
	public ProductDto displayProductById(Integer id) {
		Product product = productRepo.findById(id).get();
		ProductDto productDto = new ProductDto();
		productDto = entityToDtoAssembler(productDto, product);
		return productDto;
	}
	
	public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto) throws InvalidInputException {
		try {
			Integer id = productDto.getId();
			Product product = productRepo.findById(id).get();
			product = dtoToEntityAssembler(productDto, product);
			productRepo.save(product);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return productDto;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
	}
}
