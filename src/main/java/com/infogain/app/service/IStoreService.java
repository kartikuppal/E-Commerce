package com.infogain.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.InvalidInputException;

public interface IStoreService {
	public StoreDto insertStore(@RequestBody @Valid StoreDto storeDto) throws InvalidInputException;
	public List<StoreDto> displayAllStore();
	public StoreDto displayStoreById(Integer id);
	public StoreDto updateStore(@RequestBody @Valid StoreDto storeDto) throws InvalidInputException;
	public void deleteStore(Integer id);
}
