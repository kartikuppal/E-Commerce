package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IProductRepo;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductRepo productRepo;

	public Product dtoToEntityAssembler(ProductDto productDto, Product product) {
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setManufacturingDate(productDto.getManufacturingDate());
		product.setPrice(productDto.getPrice());
		product.setSize(productDto.getSize());
		product.setRating(productDto.getRating());
		product.setWeight(productDto.getWeight());
		return product;
	}

	public ProductDto entityToDto(ProductDto productDto, Product product) {
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setManufacturingDate(product.getManufacturingDate());
		productDto.setPrice(product.getPrice());
		productDto.setSize(product.getSize());
		productDto.setRating(product.getRating());
		productDto.setWeight(product.getWeight());
		return productDto;
	}

	@Override
	public List<ProductDto> displayAllProduct() {
		List<Product> product = productRepo.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		ProductDto productDto = new ProductDto();
		for (Product p : product) {
			productDto = entityToDto(productDto, p);
			productDtos.add(productDto);
		}

		return productDtos;

	}

	@Override
	public ProductDto displayProductById(Integer id) {
		Product product = productRepo.findById(id).get();
		ProductDto productDto = new ProductDto();
		productDto = entityToDto(productDto, product);
		return productDto;
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) throws CustomException {
		Product product = new Product();
		if (productDto.getPrice() < 0) {
			throw new CustomException("Price cannot be negative");
		} else if (productDto.getWeight() < 0) {
			throw new CustomException("Weight cannot be negative");
		} else if (productDto.getRating() < 0 || productDto.getRating() > 10) {
			throw new CustomException("Rating can be given between 0 to 10 only");
		}

		else {

			product = dtoToEntityAssembler(productDto, product);
		}
		productRepo.save(product);
		productDto.setId(product.getId());
		return productDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer id) throws CustomException {
		Product product = productRepo.findById(id).get();
		if (productDto.getPrice() < 0) {
			throw new CustomException("Price cannot be negative");
		} else if (productDto.getWeight() < 0) {
			throw new CustomException("Weight cannot be negative");
		} else if (productDto.getRating() < 0 || productDto.getRating() > 10) {
			throw new CustomException("Rating can be given between 0 to 10 only");
		} else {
			product = dtoToEntityAssembler(productDto, product);
		}
		productRepo.save(product);
		return productDto;

	}

	@Override
	public void deleteProduct(Integer id) {

		productRepo.deleteById(id);

	}

}
