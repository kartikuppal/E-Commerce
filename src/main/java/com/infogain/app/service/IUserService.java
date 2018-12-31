package com.infogain.app.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;

interface IUserService {
	void activation(Integer id);
	String sendMail(String userName, String password, String name, Integer id) throws UnsupportedEncodingException;
	Boolean login(String userName, String password, Integer id) throws CustomException;
	List<UserDto> getAll();
	UserDto getById(Integer id);
	UserDto insert(UserDto userDto) throws InvalidInputException, CustomException;
	UserDto update(UserDto userDto) throws InvalidInputException;
	String delete(Integer id);
	UserDto entityToDtoAssembler(UserDto userDto, User user);
	User dtoToEntityAssembler(UserDto userDto, User user);
}
