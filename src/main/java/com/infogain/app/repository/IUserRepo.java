package com.infogain.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User save(UserDto userDto);
	User findByForgetPasswordToken(String token);
	
/*	@Query("SELECT u FROM User u WHERE u.status = 1")
	List<User> getActiveUsers();*/
	
	@Query(value = "SELECT * FROM USER u WHERE u.status = 1",  nativeQuery = true)
	List<User> getActiveUsers();
	
	@Query("SELECT name FROM User u WHERE u.status = 1")
	List<String> getActiveUsersName();
	
}
