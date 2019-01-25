package com.infogain.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/api")
public class LogoutController {

	Jedis jedis = new Jedis();
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request)
	{
		String token =request.getHeader("Authorization");
		jedis.del(token);
		return new ResponseEntity<>("Successfully Logged out", HttpStatus.OK);
		
		
	}
}
