package com.infogain.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.service.StoreService;

@RestController
@RequestMapping("/api")
public class StoreController {
	@Autowired
	StoreService storeService;
	
	@Autowired
	IStoreRepo storeRepo;
	
	@PostMapping("/store")
	public StoreDto insertStore(@RequestBody StoreDto storeDto) throws CustomException {
		return storeService.insertStore(storeDto);
	}
	
	@GetMapping("/store")
	public List<StoreDto> displayAllStores(@RequestBody StoreDto storeDto) {
		return storeService.displayAllStore();
	}
	
	@GetMapping("/store/{id}")
	public StoreDto displayStoreById(@PathVariable(value = "id") Integer storeId) {
		return storeService.displayStoreById(storeId);
	}
	
	@PutMapping("/store")
	public StoreDto updateStore(@RequestBody StoreDto storeDto, Integer storeId) throws CustomException {
		return storeService.updateStore(storeDto, storeId);
	}
	
	@DeleteMapping("/store/{id}")
	public void deleteStore(@PathVariable(value = "id") Integer storeId) {
		storeService.deleteStore(storeId);
	}
}
