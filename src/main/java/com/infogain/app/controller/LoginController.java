package com.infogain.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infogain.app.authorization.JwtGenerator;
import com.infogain.app.authorization.JwtUser;
import com.infogain.app.authorization.LoginResponse;
import com.infogain.app.entity.User;
import com.infogain.app.service.LoginService;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private JwtGenerator jwtGenerator;
	
	Jedis jedis = new Jedis();
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody  JwtUser jwtUser)
	{
		HttpHeaders headers = new HttpHeaders();
		LoginResponse loginResponse = new LoginResponse();
					
				User user = new User();
				user = loginService.login(jwtUser.getEmail(),jwtUser.getPassword());
				if(user != null) {
				 
				if(jedis.get(user.getEmail())==null)
					//To check whether user is already logged in or not
				{	
					String token = jwtGenerator.generateToken(user);
					jedis.set(user.getEmail(),token);
					loginResponse.setToken(token);
					loginResponse.setStatus(HttpStatus.CREATED.toString());
				}
				else
				{
					loginResponse.setStatus(HttpStatus.UNAUTHORIZED.toString());
					loginResponse.setToken("Already logged in !:)");
				}
				
				}
		else {
					loginResponse.setStatus(HttpStatus.UNAUTHORIZED.toString());
					loginResponse.setToken("Please check your credentials");
				}
			
		
     
				return new ResponseEntity<>(loginResponse,headers, HttpStatus.OK);
	}
}
