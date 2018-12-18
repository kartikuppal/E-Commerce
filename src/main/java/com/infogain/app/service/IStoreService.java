package com.infogain.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.InvalidInputException;

public interface IStoreService {
	public StoreDto insert(StoreDto storeDto) throws InvalidInputException;
	public List<StoreDto> displayAll();
	public StoreDto displayById(Integer id);
	public StoreDto update(StoreDto storeDto) throws InvalidInputException;
	public void delete(Integer id);
}
