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
import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.service.StoreServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = StoreController.class, secure = false)
public class StoreControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StoreServiceImpl storeService;
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	@Test
	public void create() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("anil");
		storeDto.setAddress("amritsar india");
		storeDto.setPostalCode("123654");
		storeDto.setContactNo("7896541236");
		
		String inputInJson = this.mapToJson(storeDto);
		
		Mockito.when(storeService.insert(Mockito.any(StoreDto.class))).thenReturn(storeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/store")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	@Test(expected = CustomException.class)
	public void create2() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(null);
		storeDto.setName(null);
		storeDto.setAddress(null);
		storeDto.setPostalCode(null);
		storeDto.setContactNo(null);
		
		String inputInJson = this.mapToJson(storeDto);
		
		//Mockito.when(storeService.insert(Mockito.any(StoreDto.class))).thenReturn(storeDto);
		Mockito.when(storeService.insert(Mockito.any(StoreDto.class))).thenThrow(new CustomException(404,"contact number must be unique"));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/store")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	@Test
	public void create3() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("ansdgfweil");
		storeDto.setAddress("ia");
		storeDto.setPostalCode("1dfsg23654");
		storeDto.setContactNo("78965sdfgfsdgfsdgfd");
		
		String inputInJson = this.mapToJson(storeDto);
		
		Mockito.when(storeService.insert(Mockito.any(StoreDto.class))).thenReturn(storeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/store")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/*display*/
	
	@Test
	public void getAll() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("anil");
		storeDto.setAddress("amritsar india");
		storeDto.setPostalCode("123654");
		storeDto.setContactNo("7896541236");
		
		List<StoreDto> storeDtoList = new ArrayList<>();
		storeDtoList.add(storeDto);
		
		String expectedJson = this.mapToJson(storeDtoList);
		
		Mockito.when(storeService.displayAll()).thenReturn(storeDtoList);
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders
						.get("/api/store")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	/*display by id*/
	
	@Test
	public void getById() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("ansdgfweil");
		storeDto.setAddress("ia");
		storeDto.setPostalCode("1dfsg23654");
		storeDto.setContactNo("78965sdfgfsdgfsdgfd");
		
		Mockito.when(storeService.displayById(Mockito.anyInt())).thenReturn(storeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/store/1")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(storeDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	@Test
	public void getById2() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("ansdgfweil");
		storeDto.setAddress("ia");
		storeDto.setPostalCode("1dfsg23654");
		storeDto.setContactNo("78965sdfgfsdgfsdgfd");
		
		Mockito.when(storeService.displayById(Mockito.anyInt())).thenReturn(storeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/store/a")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(storeDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	@Test
	public void getById3() throws Exception {
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("ansdgfweil");
		storeDto.setAddress("ia");
		storeDto.setPostalCode("1dfsg23654");
		storeDto.setContactNo("78965sdfgfsdgfsdgfd");
		
		Mockito.when(storeService.displayById(Mockito.anyInt())).thenReturn(storeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/store/")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(storeDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
}
