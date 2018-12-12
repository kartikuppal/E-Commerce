package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;

interface IUserService {

	public Boolean loginUser(String userName,String password,Integer id)throws CustomException;
	public List<UserDto> getAllUsers();
	public UserDto getUserById(Integer id);
	public UserDto insertUser(UserDto userDto) throws  CustomException;
	public UserDto updateUser(UserDto userDto) throws CustomException;
	public void deleteUser(Integer id);

	
}
