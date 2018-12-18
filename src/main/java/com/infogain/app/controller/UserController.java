package com.infogain.app.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.infogain.app.repository.IUserRepo;
import com.infogain.app.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private IUserRepo userRepo;
	@Autowired
	JavaMailSender mailSender;
	

	/* @RequestMapping("/sendMail")
	    public String sendMail() {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);

	        try {
	            helper.setTo("kartikuppal25@gmail.com");
	            helper.setText("Greetings :)");
	            helper.setSubject("Mail From Spring Boot");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        }
	        mailSender.send(message);
	        return "Mail Sent Success!";
	    }*/

	
	@GetMapping("/activateAccount/{id}")
	public String activeUser(@PathVariable(value = "id") Integer userId)
	{
		userService.activation(userId);
		return "Your Account is Activated !!!";
		
	}
	
	@GetMapping("/user")
	public List<UserDto> displayAll() {
		return userService.getAll();

	}
	


	@GetMapping("/user/{id}")
	public UserDto getById(@PathVariable(value = "id") Integer userId, @RequestHeader(value = "userName") String userName,
			@RequestHeader(value = "password") String password) throws CustomException {
		Boolean loginSuccess = userService.login(userName, password,userId);
		UserDto userDto = new UserDto();
		if (loginSuccess == true) {
			userDto=userService.getById(userId);
		}
		else{
			throw new CustomException("Login Error");
		}
		return userDto;

	}

	@PostMapping("/user")
	public UserDto insert(@RequestBody @Valid UserDto userDto) throws InvalidInputException {
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
	return userDto;
	}
	
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable(value = "id") Integer userId) {
		userService.delete(userId);
	}
}
