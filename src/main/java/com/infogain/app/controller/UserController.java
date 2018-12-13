package com.infogain.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Store;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IUserRepo;
import com.infogain.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	IUserRepo userRepo;

	@GetMapping("/user")
	public List<UserDto> displayAllUsers() {
		return userService.getAllUsers();

	}

	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable(value = "id") Integer userId, @RequestHeader(value = "userName") String userName,
			@RequestHeader(value = "password") String password) throws CustomException {
		Boolean loginSuccess = userService.loginUser(userName, password,userId);
		UserDto userDto = new UserDto();
		if (loginSuccess == true) {
			userDto=userService.getUserById(userId);
		}
		else{
			throw new CustomException("Login Error");
		}
		return userDto;

	}

	@PostMapping("/user")
	public UserDto userInsert(@RequestBody UserDto userDto) throws InvalidInputException {
		return userService.insertUser(userDto);
	}

	/*@PutMapping("/user")
	public UserDto updateUser(@RequestBody @Valid UserDto userDto, @RequestHeader(value = "userName") String userName,
			@RequestHeader(value = "password") String password) throws InvalidInputException {
		try {
			Integer id=userDto.getId();
			Boolean loginSuccess = userService.loginUser(userName, password,id);
			if (loginSuccess == true) {
				userDto = userService.updateUser(userDto);
			}
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return userDto;
	}*/
	
	@PutMapping("/user")
	public UserDto updateUser(@RequestBody @Valid UserDto userDto, @RequestHeader(value = "userName") String userName,
	@RequestHeader(value = "password") String password) throws CustomException {
	Integer id=userDto.getId();
	Boolean loginSuccess = userService.loginUser(userName, password,id);
	if (loginSuccess == true) {
	userDto = userService.updateUser(userDto);
	}
	return userDto;
	}
	
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable(value = "id") Integer userId) {
		userService.deleteUser(userId);
	}
}
