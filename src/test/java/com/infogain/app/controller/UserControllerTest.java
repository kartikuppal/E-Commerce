package com.infogain.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.app.dto.UserDto;
import com.infogain.app.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserServiceImpl userService;

	@Test
	public void testGetAll() {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setAddress("address hhhhhh");
		userDto.setEmail("email");
		userDto.setMobileNumber("9874335512");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");

	}

	@Test
	public void testGetById() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("harshit");
		userDto.setEmail("ejgu");
		userDto.setAddress("sxdhcgdhc");
		userDto.setMobileNumber("15787635487");
		userDto.setPostalCode("57841254");

		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(userDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("api/user/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(userDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void testCreate() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		userDto.setName("User");
		userDto.setAddress("address hhhhhh");
		userDto.setEmail("emai5@mail.com");
		userDto.setMobileNumber("9974696969");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");
		String inputInJson = this.mapToJson(userDto);
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user").accept(MediaType.APPLICATION_JSON)
										.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
