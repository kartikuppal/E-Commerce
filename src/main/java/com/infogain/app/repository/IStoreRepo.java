package com.infogain.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;

public interface IStoreRepo extends JpaRepository<Store, Integer>{

	public Store findByContactNo(BigInteger contactNo);
	public List<Store> findAllByIdIn(List<Integer> ids);
	//public List<Store> findAllByStoreId(List<Integer> storeId);

	public void save(StoreDto storeDto);
	
}
