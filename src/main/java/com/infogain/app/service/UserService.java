package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepo userRepo;

	@Override
	public Boolean loginUser(String userName, String password) throws UserException {
		User user = userRepo.findByEmail(userName);
		Boolean flag = false;
		if (user == null) {
			throw new UserException("User Name does not exist");

		}

		else {
			if (userName.equals(user.getEmail()) && password.equals(user.getPassword())) {
				flag = true;
			}
		}
		return flag;

	}

	@Override
	public List<User> displayAllUsers() {
		List<User> user = userRepo.findAll();
		return user;
	}

	@Override
	public User displayUserById(Integer id) {
		User user = userRepo.findById(id).get();
		return user;
	}

	@Override
	public User insertUser(User user) throws UserException {

		User existingUser = userRepo.findByEmail(user.getEmail());
		Integer addressLength = user.getAddress().length();	
		Integer mobileNumberLength = user.getMobileNumber().toString().length();
		Integer postalCodeLength = user.getPostalCode().toString().length();

		if (existingUser == null) {

			if (addressLength <= 10) {
				throw new UserException("Address length must be greater than 10 digits");
			}
			else if (mobileNumberLength != 10) {
				throw new UserException("Mobile number must be of exact 10 digits");
			}
			else if(postalCodeLength != 6){
				throw new UserException("Postal code must be of exact 6 digits");
				
			}

			else {
				user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
				user.setName(user.getName());
				user.setAddress(user.getAddress());
				user.setEmail(user.getEmail());
				user.setMobileNumber(user.getMobileNumber());
				user.setPostalCode(user.getPostalCode());

			}
		} else {
			throw new UserException("Email already exists");
		}
		return userRepo.save(user);
	}
	
	

	@Override
	public User updateUser(User userDetail, Integer id) throws UserException {
		User user = userRepo.findById(id).get();
		Integer passwordLength = userDetail.getPassword().length();
		Integer addressLength = userDetail.getAddress().length();	
		Integer mobileNumberLength = userDetail.getMobileNumber().toString().length();
		Integer postalCodeLength = userDetail.getPostalCode().toString().length();
		System.out.println(passwordLength);

		if(passwordLength<8 || passwordLength>15)
		{
			throw new UserException("Password length must be 8 to 15 digits");
		}
		else if (addressLength <= 10) {
			throw new UserException("Address length must be greater than 10 digits");
		}
		else if (mobileNumberLength != 10) {
			throw new UserException("Mobile number must be of exact 10 digits");
		}
		else if(postalCodeLength != 6){
			throw new UserException("Postal code must be of exact 6 digits");
			
		}
		
		 else {
			user.setPassword(userDetail.getPassword());
			user.setName(userDetail.getName());
			user.setAddress(userDetail.getAddress());
			user.setMobileNumber(userDetail.getMobileNumber());
			user.setPostalCode(userDetail.getPostalCode());
			userRepo.save(user);
		}
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);

	}



}
