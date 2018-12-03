package com.infogain.app.controller;

import java.util.List;

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

import com.infogain.app.entity.User;
import com.infogain.app.repository.IUserRepo;
import com.infogain.app.service.UserException;
import com.infogain.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	IUserRepo userRepo;

	 @RequestMapping(path = "/demo")
	    public String index() {

	        return "index";
	    }    
	
	@RequestMapping("/login")
	public void loginUser(@RequestHeader(value = "UserName") String userName,
			@RequestHeader(value = "Password") String password) throws UserException {
		Boolean flag = userService.loginUser(userName, password);
		System.out.println(flag);
		
		
	}

	@GetMapping("/user")
	public List<User> displayAllUsers(@RequestBody User user) {
		return userService.displayAllUsers();

	}

	@GetMapping("/user/{id}")
	public User displayUserById(@PathVariable(value = "id") Integer userId) {
		return userService.displayUserById(userId);

	}

	@PostMapping("/user")
	public User userInsert(@RequestBody User user) throws UserException {
		return userService.insertUser(user);

	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable(value = "id") Integer userId) {
		return userService.updateUser(user, userId);

	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable(value = "id") Integer userId) {
		userService.deleteUser(userId);
	}

}
