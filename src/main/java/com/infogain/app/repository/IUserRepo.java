package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer>
{
	public User findByEmail(String email);

}
