package com.infogain.app.service;

import java.util.List;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;

public interface IStoreService {
	public Store insertStore(StoreDto storeDto) throws CustomException;
	public List<Store> displayStore();
	public Store displayStoreById(Integer id);
	public Store updateStore(Store updatedStore, Integer id) throws CustomException;
	public void deleteStore(Integer id);
}
