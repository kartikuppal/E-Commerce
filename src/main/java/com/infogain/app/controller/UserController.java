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
import com.infogain.app.repository.IUserRepo;
import com.infogain.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	IUserRepo userRepo;
  
	
	/*@RequestMapping("/login")
	public User loginUser(@RequestHeader(value = "UserName") String userName,
			@RequestHeader(value = "Password") String password) throws CustomException {
		Boolean flag = userService.loginUser(userName, password);
		User user=new User();
		if(flag==true)
		{
			user = userRepo.findByEmail(userName);
		}
		System.out.println(user);
		return user;
		
	}*/
/*	
	@PostMapping("/login")
	public Boolean loginUser(@RequestBody UserDto userDto) throws CustomException
	{
		String userName = userDto.getEmail();
		String password = userDto.getPassword();
		Boolean loginSuccess = userService.loginUser(userName, password);
		return loginSuccess;
		
	}*/
	

/*	@RequestMapping("/login")
	public Boolean loginUser(@RequestHeader(value = "UserName") String userName,
			@RequestHeader(value = "Password") String password) throws CustomException {
		Boolean loginSuccess = userService.loginUser(userName, password);
		return loginSuccess;
		
	}*/
	
	@GetMapping("/user")
	public List<UserDto> displayAllUsers() {
		return userService.getAllUsers();

	}
	
	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable(value = "id") Integer userId) {
		return userService.getUserById(userId);

	}
	
	@PostMapping("/user")
	public UserDto userInsert(@RequestBody UserDto userDto) throws CustomException {
		
		return userService.insertUser(userDto);
	}
	
	@PutMapping("/user")
	public UserDto updateUser(@RequestBody UserDto userDto, @RequestHeader(value = "userName") String userName,
			@RequestHeader(value = "password") String password) throws CustomException {
		Boolean loginSuccess = userService.loginUser(userName, password);
		if(loginSuccess==true){
		userDto= userService.updateUser(userDto);
		}
		else
		{
			throw new CustomException("login unsuccessfull");
		}
		return userDto;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable(value = "id") Integer userId) {
		userService.deleteUser(userId);
	}

	/*

	




*/
}
