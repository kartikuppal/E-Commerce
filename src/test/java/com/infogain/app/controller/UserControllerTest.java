package com.infogain.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.app.dto.UserDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserServiceImpl userService;
	
	@Test
	public void create() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("anil");
		userDto.setEmail("anil@gmail.com");
		userDto.setPassword("sdf1sfsdf2");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236547895");
		userDto.setPostalCode("123654");
		userDto.setStatus((byte) 0);
		
		
		String inputInJson = this.mapToJson(userDto);
		
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/user")
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
		UserDto userDto = new UserDto();
		userDto.setId(null);
		userDto.setName(null);
		userDto.setEmail(null);
		userDto.setPassword(null);
		userDto.setAddress(null);
		userDto.setMobileNumber(null);
		userDto.setPostalCode(null);
		userDto.setStatus(null);
		
		
		String inputInJson = this.mapToJson(userDto);
		
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/user")
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
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("anil");
		userDto.setEmail("anim");
		userDto.setPassword("hj");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236yu547895");
		userDto.setPostalCode("1236yu54");
		userDto.setStatus((byte) 0);
		
		
		String inputInJson = this.mapToJson(userDto);
		
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/user")
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
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("anil");
		userDto.setEmail("anil@gmail.com");
		userDto.setPassword("sdf1sfsdf2");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236547895");
		userDto.setPostalCode("123654");
		userDto.setStatus((byte) 0);
		
		List<UserDto> userList = new ArrayList<>();
		userList.add(userDto);
		
		String expectedJson = this.mapToJson(userList);
		
		Mockito.when(userService.getAll()).thenReturn(userList);
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders
						.get("/api/user")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	public void getById() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("anil");
		userDto.setEmail("anil@gmail.com");
		userDto.setPassword("sdf1sfsdf2");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236547895");
		userDto.setPostalCode("123654");
		userDto.setStatus((byte) 0);
		
		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(userDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/user/1")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String expectedJson = this.mapToJson(userDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
