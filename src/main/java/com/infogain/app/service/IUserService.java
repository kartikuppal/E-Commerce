package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;

interface IUserService {

	public Boolean login(String userName,String password,Integer id)throws CustomException;
	public List<UserDto> getAll();
	public UserDto getById(Integer id);
	public UserDto insert(UserDto userDto) throws  CustomException;
	public UserDto update(UserDto userDto) throws CustomException;
	public void delete(Integer id);

	
}
