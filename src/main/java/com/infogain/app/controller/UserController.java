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
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/userActive/{id}")
	public String activeUser(@PathVariable(value = "id") Integer userId)
	{
		userService.activation(userId);
		return "Your Account is Activated !!!";
	}
	
	@GetMapping("/user")
	public List<UserDto> getAll() {
		return userService.getAll();
	}

	@GetMapping("/user/{id}")
	public UserDto getById(@PathVariable(value = "id") Integer userId, @RequestHeader(value = "userName") String userName,
			@RequestHeader(value = "password") String password) throws CustomException {
		UserDto userDto = new UserDto();
		Boolean loginSuccess = userService.login(userName, password,userId);
		
		if (loginSuccess == true) {
			userDto=userService.getById(userId);
		}
		else{
			throw new CustomException("Login Error");
		}
		return userDto;
	}

	@PostMapping("/user")
	public UserDto insert(@RequestBody @Valid UserDto userDto) throws InvalidInputException, CustomException {
		return userService.insert(userDto);
	}
	
	@PutMapping("/user")
	public UserDto update(@RequestBody @Valid UserDto userDto, @RequestHeader(value = "userName") String userName,
	@RequestHeader(value = "password") String password) throws CustomException {
	Integer id=userDto.getId();
	Boolean loginSuccess = userService.login(userName, password,id);
	if (loginSuccess == true) {
	userDto = userService.update(userDto);
	}
	else{
		throw new CustomException("Login Error");
	}
	return userDto;
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable(value = "id") Integer userId) {
		return userService.delete(userId);
	}
}
