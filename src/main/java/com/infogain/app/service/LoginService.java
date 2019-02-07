package com.infogain.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IUserRepo;

@Service
public class LoginService {
	
	@Autowired
	IUserRepo userRepo;
	@Autowired
	UserServiceImpl userService;
	
	public UserDto login(String userName, String password)throws InvalidInputException
	{
		User user = new User();
		UserDto userDto = new UserDto();
		user = userRepo.findByEmail(userName);
		if(user!=null)
		{
			if(!user.getPassword().equals(password))
			{
				throw new InvalidInputException(401,"Password is incorrect");
			}
		}
		else
		{
			throw new InvalidInputException(401,"UserName does not exist");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("E dd-MMMM-YYYY HH:mm:ss zzz");
		Date date = new Date();
		user.setLastLogin(dateFormat.format(date));
		userRepo.save(user);
		userDto = userService.entityToDtoAssembler(userDto, user);
		return userDto;
		
	}

}
