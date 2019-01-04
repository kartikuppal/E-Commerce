package com.infogain.app.controller;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;

=======
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
<<<<<<< HEAD
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
=======
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2
import com.infogain.app.dto.UserDto;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
<<<<<<< HEAD
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserServiceImpl userService;
	
	@Test
	public void create() throws Exception {
=======

	@InjectMocks
	UserController userController;
	
	@Mock
	private UserServiceImpl userService;
	
	@Captor
	 private ArgumentCaptor<Integer> intCaptor;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	public UserDto setEntity(UserDto userDto) {
		userDto.setId(1);
		userDto.setName("name");
		userDto.setAddress("addressasjgg");
		userDto.setEmail("email@gmail.com");
		userDto.setMobileNumber("9874563210");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");
		return userDto;
	}
	
	@Test
	public void testGetAll(){
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2
		UserDto userDto = new UserDto();
		userDto=setEntity(userDto);
		List<UserDto> userDtos = new ArrayList<>();
		userDtos.add(userDto);
		List<UserDto> list = (List<UserDto>) Mockito.when(userService.getAll()).thenReturn(userDtos);
		 for (UserDto userInfo: list)
		 {
	        assertEquals(userInfo.getId(), userDto.getId());
	        assertEquals(userInfo.getAddress(), userDto.getAddress());
	        assertEquals(userInfo.getEmail(), userDto.getEmail());
	        assertEquals(userInfo.getName(), userDto.getName());
	        assertEquals(userInfo.getMobileNumber(), userDto.getMobileNumber());
	        assertEquals(userInfo.getPostalCode(), userDto.getPostalCode());
	        assertEquals(userInfo.getPassword(), userDto.getPassword());
	      }
		 System.out.println(list);
	}
	
	@Test
	public void testActiveUser(){
		int userId = 1;
		userController.activeUser(userId);
		Mockito.verify(userService,new Times(1)).activation(intCaptor.capture());
		int userIDCapture = intCaptor.getValue();
		assertEquals(userId, userIDCapture);
		
	}
		 @Test
		 public void testGetById()
		 {
			 UserDto userDto =  new UserDto();
			 Integer id = 1;
			 setEntity(userDto);
			 //userController.getById(u, userName, password)
			 
			 
		 }
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@MockBean
	private UserServiceImpl userService;

	public UserDto setEntity(UserDto userDto) {
		userDto.setId(1);
<<<<<<< HEAD
		userDto.setName("anil");
		userDto.setEmail("anil@gmail.com");
		userDto.setPassword("sdf1sfsdf2");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236547895");
		userDto.setPostalCode("123654");
		userDto.setStatus((byte) 0);
		
		
		String inputInJson = this.mapToJson(userDto);
		
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
=======
		userDto.setName("name");
		userDto.setAddress("addressasjgg");
		userDto.setEmail("email@gmail.com");
		userDto.setMobileNumber("9874563210");
		userDto.setStatus((byte) 1);
		userDto.setPostalCode("143001");
		userDto.setPassword("user1234");
		return userDto;
	}

	@Test
	public void testGetAll() {
		UserDto userDto = new UserDto();
		setEntity(userDto); 
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2

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
<<<<<<< HEAD
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
=======
		setEntity(userDto);

		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(userDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("api/user/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(userDto);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2
	}
	@Test
	public void create3() throws Exception {
		UserDto userDto = new UserDto();
<<<<<<< HEAD
		userDto.setId(1);
		userDto.setName("anil");
		userDto.setEmail("anim");
		userDto.setPassword("hj");
		userDto.setAddress("noida india");
		userDto.setMobileNumber("1236yu547895");
		userDto.setPostalCode("1236yu54");
		userDto.setStatus((byte) 0);
		
		
=======
		setEntity(userDto);
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2
		String inputInJson = this.mapToJson(userDto);
		
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
<<<<<<< HEAD

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
	
	
=======
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}*/
>>>>>>> 3527a99e52c228c709581cf8ab33609f44391dc2

/*	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}*/

}
