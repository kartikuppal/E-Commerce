package com.infogain.app.service;


import java.math.BigInteger;
import java.util.ArrayList;



import java.util.Iterator;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Store;

import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private IStoreRepo storeRepo;

	@Override
	public Boolean loginUser(String userName, String password) throws CustomException {
		User user = userRepo.findByEmail(userName);
		Boolean flag = false;
		if (user == null) {
			throw new CustomException("User Name does not exist");

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
	public User insertUserDto(UserDto userDto) throws CustomException {
		User user = new User();
		User existingUser = userRepo.findByEmail(userDto.getEmail());
		User existingMobileNumber = userRepo.findByMobileNumber(user.getMobileNumber());
		Integer addressLength = userDto.getAddress().length();
		Integer mobileNumberLength = userDto.getMobileNumber().toString().length();
		Integer postalCodeLength = userDto.getPostalCode().toString().length();
		Byte userStatus = userDto.getStatus();
		List<Integer> ids = new ArrayList<>();
		ids = userDto.getStoreId();
		User existingStore = userRepo.findById(ids);

		if (existingStore != null) {
			throw new CustomException("Store with this id already exists");
		}

		else if (existingUser != null) {
			throw new CustomException("Email already exist");
		}

		else if (existingMobileNumber != null) {
			throw new CustomException("Mobile number already exist");
		} else if (userStatus != 1 && userStatus != 0) {
			throw new CustomException("Status must Either 0 for Inactive or 1 for Active");
		}

		else if (addressLength <= 10) {
			throw new CustomException("Address length must be greater than 10 digits");
		} else if (mobileNumberLength != 10) {
			throw new CustomException("Mobile number must be of exact 10 digits");
		} else if (postalCodeLength != 6) {
			throw new CustomException("Postal code must be of exact 6 digits");

		}

		else {

			user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			user.setName(userDto.getName());
			user.setAddress(userDto.getAddress());
			user.setEmail(userDto.getEmail());
			user.setMobileNumber(userDto.getMobileNumber());
			user.setPostalCode(userDto.getPostalCode());
			user.setStatus(userDto.getStatus());

			List<Store> store = new ArrayList<>();

			store = storeRepo.findAllByIdIn(ids);
			System.out.println(store);
			user.setStore(store);

		}

		return userRepo.save(user);
	}

	@Override
	public User insertUser(User user) throws CustomException {

		User existingUser = userRepo.findByEmail(user.getEmail());
		User existingMobileNumber = userRepo.findByMobileNumber(user.getMobileNumber());
		
		Integer addressLength = user.getAddress().length();
		Integer mobileNumberLength = user.getMobileNumber().toString().length();
		Integer postalCodeLength = user.getPostalCode().toString().length();
		
		if (existingUser != null) {
			throw new CustomException("Email already exist");
		} else if (existingMobileNumber != null) {
			throw new CustomException("Mobile number already exist");
		} else {

			if (addressLength <= 10) {
				throw new CustomException("Address length must be greater than 10 digits");
			} else if (mobileNumberLength != 10) {
				throw new CustomException("Mobile number must be of exact 10 digits");
			} else if (postalCodeLength != 6) {
				throw new CustomException("Postal code must be of exact 6 digits");
			}
			else {
				user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
				user.setName(user.getName());
				user.setAddress(user.getAddress());
				user.setEmail(user.getEmail());
				user.setMobileNumber(user.getMobileNumber());
				user.setPostalCode(user.getPostalCode());
			}
		}
		return userRepo.save(user);
	}
	
	@Override
	public User updateUser(User userDetail, Integer id) throws CustomException {
		User existingMobileNumber = userRepo.findByMobileNumber(userDetail.getMobileNumber());
		User user = userRepo.findById(id).get();
		Integer passwordLength = userDetail.getPassword().length();
		Integer addressLength = userDetail.getAddress().length();
		Integer mobileNumberLength = userDetail.getMobileNumber().toString().length();
		Integer postalCodeLength = userDetail.getPostalCode().toString().length();

		if (passwordLength < 8 || passwordLength > 15) {
			throw new CustomException("Password length must be 8 to 15 digits");
		} else if (addressLength <= 10) {
			throw new CustomException("Address length must be greater than 10 digits");
		} else if (mobileNumberLength != 10) {
			throw new CustomException("Mobile number must be of exact 10 digits");
		} else if (existingMobileNumber != null) {
			throw new CustomException("Mobile number already exist");
		} else if (postalCodeLength != 6) {
			throw new CustomException("Postal code must be of exact 6 digits");

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
