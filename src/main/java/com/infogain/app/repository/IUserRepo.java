package com.infogain.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.Store;
import com.infogain.app.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer>
{
	public User findByEmail(String email);
	public User findByMobileNumber(BigInteger mobileNumber);
	public User findById(List<Integer> ids);


}
