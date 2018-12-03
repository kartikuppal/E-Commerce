package com.infogain.app.service;

import java.math.BigInteger;
import java.util.List;

import com.infogain.app.entity.User;

interface IUserService {

	public Boolean loginUser(String email, String password)throws UserException;
	public List<User> displayAllUsers();
	public User displayUserById(Integer id);
	public User insertUser(User user) throws UserException;
	public User updateUser(User user, Integer id);
	public void deleteUser(Integer id);
}
