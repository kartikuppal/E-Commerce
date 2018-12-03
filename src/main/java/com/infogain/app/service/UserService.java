package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.User;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserService userService;
	@Autowired
	private IUserRepo userRepo;
	

	@Override
	public Boolean loginUser(String userName, String password)throws UserException {
		User user = userRepo.findByEmail(userName);
		Boolean flag=false;
		if (user == null) {
			throw new UserException("User Name does not exist");
			
		}
		
		else {
			if(userName.equals(user.getEmail())&&password.equals(user.getPassword()))
			{
				flag=true;
			}
		}
		return flag;
		
	}
	
	@Override
	public List<User> displayAllUsers() {
		List<User> user =  userRepo.findAll();
		return  user;
	}
	
	@Override
	public User displayUserById(Integer id) {
		User user = userRepo.findById(id).get();
		return user;
	}
	
	
	@Override
	public User insertUser(User user) {
		
		user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
		user.setName(user.getName());
		user.setAddress(user.getAddress());
		user.setEmail(user.getEmail());
		user.setMobileNumber(user.getMobileNumber());
		user.setPostalCode(user.getPostalCode());
		return userRepo.save(user);
	}
	
	@Override
	public User updateUser(User user, Integer id) {
		user = userRepo.findById(id).get();
		user.setPassword(user.getPassword());
		user.setName(user.getName());
		user.setAddress(user.getAddress());
		user.setEmail(user.getEmail());
		user.setMobileNumber(user.getMobileNumber());
		user.setPostalCode(user.getPostalCode());
		user=userRepo.save(user);
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
		
	}

	

}
