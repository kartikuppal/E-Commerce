package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User save(UserDto userDto);
}
