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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.app.dto.UserDto;
import com.infogain.app.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = UserController.class, secure = false)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserServiceImpl userService;

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	public UserDto setCorrectValues(UserDto userDto) {
		userDto.setId(1);
		userDto.setAddress("address hhhhhh");
		userDto.setEmail("email@gmail.com");
		userDto.setName("name");
		userDto.setMobileNumber("9874563210");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");
		return userDto;
	}

	public UserDto setInCorrectValues(UserDto userDto) {
		userDto.setId(1);
		userDto.setAddress("hhh");
		userDto.setEmail("email");
		userDto.setName("name");
		userDto.setMobileNumber("987456320");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");
		return userDto;
	}

	@Test()
	public void create() throws Exception {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		System.out.println(userDto);
		String inputInJson = this.mapToJson(userDto);
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
		// Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenThrow(new
		// InvalidInputException());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void createWithIncorrectFormat() throws Exception {
		UserDto userDto = new UserDto();
		userDto = setInCorrectValues(userDto);
		System.out.println(userDto);
		String inputInJson = null;
		inputInJson = this.mapToJson(userDto);
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
		// Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenThrow(new
		// InvalidInputException());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void getAll() throws Exception {
		
		
		List<UserDto> userList = new ArrayList<>();
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		userList.add(userDto);

		String inputInJson = this.mapToJson(userList);
		Mockito.when(userService.getAll()).thenReturn(userList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
	}

	@Test
	public void getById() throws Exception {

		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);

		String inputInJson = this.mapToJson(userDto);

		HttpHeaders headers = new HttpHeaders();
		headers.add("userName", "email@.com");
		headers.add("password", "user1234");
		Mockito.when(userService.login(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(true);
		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(userDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.headers(headers)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
	}

	@Test
	public void update() throws Exception {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);

		String inputInJson = this.mapToJson(userDto);

		Mockito.when(userService.login(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(true);
		Mockito.when(userService.update(Mockito.any(UserDto.class))).thenReturn(userDto);

		HttpHeaders headers = new HttpHeaders();
		headers.add("userName", "email@gmail.com");
		headers.add("password", "user1234");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/1")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.headers(headers)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);

	}

	@Test
	public void delete() {
		Mockito.when(userService.delete(Mockito.anyInt())).thenReturn("User Deleted");

	}

}
