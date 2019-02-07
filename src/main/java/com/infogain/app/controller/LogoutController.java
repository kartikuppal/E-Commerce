package com.infogain.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.UserDto;
import com.infogain.app.security.JwtTokenDecoder;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/api")
public class LogoutController {

	@Autowired
	JwtTokenDecoder tokenDecoder;
	Jedis jedis = new Jedis();
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request)
	{
		String token =request.getHeader("Authorization");
		UserDto userDto = tokenDecoder.decode(token);
		jedis.del(userDto.getEmail());
		return new ResponseEntity<>("Successfully Logged out", HttpStatus.OK);
		
		
	}
}
