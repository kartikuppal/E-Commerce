package com.infogain.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IUserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserServiceImpl userService;
	@MockBean
	private IUserRepo userRepo;

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

	@Test
	public void getAllTest() {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		User user = new User();
		user.setId(1);
		user = userService.dtoToEntityAssembler(userDto, user);

		List<User> userList = new ArrayList<>();
		userList.add(user);

		Mockito.when(userRepo.findAll()).thenReturn(userList);
		assertEquals(1, userList.size());

	}

	@Test
	public void getByIdTest() {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		User user = new User();
		user.setId(1);
		user = userService.dtoToEntityAssembler(userDto, user);
		System.out.println("ok1\nUser iss "+user);
		Mockito.when(userRepo.findById(1).get()).thenReturn(user);
		System.out.println("ok2\nUser iss "+user);
		assertThat(1).isEqualTo(user.getId());
	}

	@Test
	public void insertTest() {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		User user = new User();
		user = userService.dtoToEntityAssembler(userDto, user);
		user.setId(1);
		Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
		assertThat(1).isEqualTo(user.getId());
	}

	@Test(expected = InvalidInputException.class)
	public void incorrectInsertTest() {
		UserDto userDto = new UserDto();
		userDto = setInCorrectValues(userDto);
		User user = new User();
		user = userService.dtoToEntityAssembler(userDto, user);
		user.setId(1);
		Mockito.when(userRepo.save(Mockito.any(User.class))).thenThrow(InvalidInputException.class);

	}

	@Test
	public void updateTest() {
		UserDto userDto = new UserDto();
		userDto = setCorrectValues(userDto);
		User user = new User();
		user = userService.dtoToEntityAssembler(userDto, user);
		user.setId(1);

	}

}
