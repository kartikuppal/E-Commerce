package com.infogain.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.app.entity.User;
import com.infogain.app.repository.IUserRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IUserRepo userRepo;

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	@Test
	public void testActivation() {
		fail("Not yet implemented");
	}

	@Test
	public void testForgetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntityToDtoAssembler() {
		fail("Not yet implemented");
	}

	@Test
	public void testDtoToEntityAssembler() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() throws Exception {
		User user = new User();
		List<User> userList = new ArrayList<>();
		user.setId(1);
		user.setAddress("address hhhhhh");
		user.setEmail("email@gmail.com");
		user.setName("name");
		user.setMobileNumber("9874563210");
		user.setStatus((byte) 1);
		user.setPostalCode("143001");
		user.setPassword("user1234");
		userList.add(user);
		System.out.println("okokokokokookokok");
		String inputInJson = this.mapToJson(user);
		Mockito.when(userRepo.findAll()).thenReturn(userList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		System.out.println("okokokokokookokok\n"+inputInJson);
		System.out.println("okokokokokookokok\n"+outputInJson);
		assertThat(outputInJson).isEqualTo(inputInJson);
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
