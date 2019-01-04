package com.infogain.app.repository;

<<<<<<< HEAD
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infogain.app.dto.StoreDto;
=======
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369

import com.infogain.app.entity.Store;

public interface IStoreRepo extends JpaRepository<Store, Integer>{
<<<<<<< HEAD
	Store findByContactNo(String contactNo);
	List<Store> findAllByIdIn(List<Integer> ids);
	void save(StoreDto storeDto);
=======

	public Store findByContactNo(BigInteger contactNo);
	
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
}
