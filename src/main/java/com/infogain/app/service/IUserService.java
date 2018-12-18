package com.infogain.app.service;

import java.util.List;
import com.infogain.app.dto.UserDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;

interface IUserService {
	public Boolean login(String userName, String password, Integer id) throws CustomException;
	public List<UserDto> getAll();
	public UserDto getById(Integer id);
	public UserDto insert(UserDto userDto) throws InvalidInputException;
	public UserDto update(UserDto userDto) throws InvalidInputException;
	public void delete(Integer id);
}
