package com.infogain.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infogain.app.entity.User;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IUserRepo;
@Service
public class LoginService {
	
	@Autowired
	IUserRepo userRepo;
	@Autowired
	UserServiceImpl userService;
	
	public User login(String userName, String password)throws InvalidInputException
	{
		User user = new User();
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
		return user;
		
	}

}
