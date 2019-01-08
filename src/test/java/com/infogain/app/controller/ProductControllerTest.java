package com.infogain.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.app.dto.ProductDto;
import com.infogain.app.service.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = ProductController.class, secure = false)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductServiceImpl productService;
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	@Test
	public void create() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setName("soap");
		productDto.setPrice(120.4);
		//productDto.setManufacturingDate(2019-02-12);
		productDto.setWeight((float) 50.0);
		productDto.setSize("M");
		productDto.setRating((byte) 5);
		
		String inputInJson = this.mapToJson(productDto);
		
		Mockito.when(productService.insert(Mockito.any(ProductDto.class))).thenReturn(productDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/product")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	@Test
	public void create2() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(null);
		productDto.setName(null);
		productDto.setPrice(null);
		productDto.setManufacturingDate(null);
		productDto.setWeight(null);
		productDto.setSize(null);
		productDto.setRating(null);
		
		String inputInJson = this.mapToJson(productDto);
		
		Mockito.when(productService.insert(Mockito.any(ProductDto.class))).thenReturn(productDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/product")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getAll() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setName("soap");
		productDto.setPrice(120.4);
		//productDto.setManufacturingDate(2019-02-12);
		productDto.setWeight((float) 50.0);
		productDto.setSize("M");
		productDto.setRating((byte) 5);
		
		List<ProductDto> productDtoList = new ArrayList<>();
		productDtoList.add(productDto);
		
		String expectedJson = this.mapToJson(productDtoList);
		
		Mockito.when(productService.displayAll()).thenReturn(productDtoList);
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders
						.get("/api/product")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	/*display by id*/
	
	@Test
	public void getById() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setName("soap");
		productDto.setPrice(120.4);
		//productDto.setManufacturingDate(2019-02-12);
		productDto.setWeight((float) 50.0);
		productDto.setSize("M");
		productDto.setRating((byte) 5);
		
		Mockito.when(productService.displayById(Mockito.anyInt())).thenReturn(productDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/product/1")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(productDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	@Test
	public void getById2() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setName("soap");
		productDto.setPrice(120.4);
		//productDto.setManufacturingDate(2019-02-12);
		productDto.setWeight((float) 50.0);
		productDto.setSize("M");
		productDto.setRating((byte) 5);
		
		Mockito.when(productService.displayById(Mockito.anyInt())).thenReturn(productDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/product/a")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(productDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	@Test
	public void getById3() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setName("soap");
		productDto.setPrice(120.4);
		//productDto.setManufacturingDate(2019-02-12);
		productDto.setWeight((float) 50.0);
		productDto.setSize("M");
		productDto.setRating((byte) 5);
		
		Mockito.when(productService.displayById(Mockito.anyInt())).thenReturn(productDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/product/")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(productDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
}
