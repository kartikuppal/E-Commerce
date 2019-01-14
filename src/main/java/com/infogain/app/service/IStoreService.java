package com.infogain.app.service;

import java.util.List;
import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
public interface IStoreService {
	StoreDto insert(StoreDto storeDto) throws InvalidInputException, CustomException;
	List<StoreDto> displayAll();
	StoreDto displayById(Integer id);
	StoreDto update(StoreDto storeDto) throws InvalidInputException;
	void delete(Integer id);
}
