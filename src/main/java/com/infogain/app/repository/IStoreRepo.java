package com.infogain.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.app.dto.StoreDto;

import com.infogain.app.entity.Store;
@Repository
public interface IStoreRepo extends JpaRepository<Store, Integer>{
	Store findByContactNo(String contactNo);
	List<Store> findAllByIdIn(List<Integer> ids);
	void save(StoreDto storeDto);
	//Object findOne(int i);
}
