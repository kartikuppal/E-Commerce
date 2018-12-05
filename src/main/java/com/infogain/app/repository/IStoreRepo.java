package com.infogain.app.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.Store;

public interface IStoreRepo extends JpaRepository<Store, Integer>{

	public Store findByContactNo(BigInteger contactNo);
	
}
