package com.infogain.app.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
import com.infogain.app.dto.UserDto;
import com.infogain.app.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

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

	}

	@Test
	public void testGetById() throws Exception {
		UserDto userDto = new UserDto();
		setEntity(userDto);

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
		setEntity(userDto);
		String inputInJson = this.mapToJson(userDto);
		Mockito.when(userService.insert(Mockito.any(UserDto.class))).thenReturn(userDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}*/

/*	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}*/

}
