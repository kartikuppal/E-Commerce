package com.infogain.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;

public interface IStoreService {
	public StoreDto insertStore(@RequestBody StoreDto storeDto) throws InvalidInputException;
	public List<StoreDto> displayAllStore();
	public StoreDto displayStoreById(Integer id);
	public StoreDto updateStore(StoreDto storeDto, Integer id) throws InvalidInputException;
	public void deleteStore(Integer id);
}
