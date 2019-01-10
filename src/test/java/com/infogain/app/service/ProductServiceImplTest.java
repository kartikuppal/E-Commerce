package com.infogain.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infogain.app.dto.ProductDto;
import com.infogain.app.entity.Product;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IProductRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	@Autowired
	private ProductServiceImpl productService;
	@MockBean
	private  IProductRepo productRepo;
	
	@Test
	public void insert() throws CustomException {
		ProductDto productDto = new ProductDto();
		//productDto.setId(1);
		productDto.setName("soap");
		//productDto.setManufacturingDate(2015-08-02);
		productDto.setPrice(200.0);
		productDto.setSize("S");
		productDto.setRating((byte) 4);
		productDto.setWeight(200.0f);
		
		Product product = new Product();
		product = productService.dtoToEntityAssembler(productDto, product);
		
	    Mockito.when(productRepo.save(product)).thenReturn(product);
	    assertThat(productService.insert(productDto)).isEqualTo(productDto);
	}
	
	/*@Test
	public void getAll() {
		Product product = new Product();
		//product.setId(1);
		product.setName("soap");
		//product.setManufacturingDate();
		product.setPrice(200.0);
		product.setSize("S");
		product.setRating((byte) 4);
		product.setWeight(200.0f);
		
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		
		List<ProductDto> productDtoList = new ArrayList<>();
		
		for(Product products : productList) {
			ProductDto productDto = new ProductDto();
			productDto = productService.entityToDtoAssembler(productDto, products);
			productDtoList.add(productDto);
			}
		
		Mockito.when(productRepo.findAll()).thenReturn(productList);
		//assertThat(storeService.displayAll(),is(storeDtoList));
		//assertThat(1,is(storeDtoList.get(0)));
	}*/
}
