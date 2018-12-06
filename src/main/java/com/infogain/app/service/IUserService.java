package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;

interface IUserService {

	public Boolean loginUser(String email, String password)throws CustomException;
	public List<User> displayAllUsers();
	public User displayUserById(Integer id);
	public User insertUserDto(UserDto userDto) throws CustomException;
	public User insertUser(User user) throws  CustomException;
	public User updateUser(User user, Integer id) throws CustomException;
	public void deleteUser(Integer id);

	
}
