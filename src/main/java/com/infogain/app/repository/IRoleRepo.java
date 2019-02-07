package com.infogain.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.app.entity.Role;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Integer>  {
	
	List<Role> findByIdIn(List<Integer> id);
	Role findByName(String name);
}
