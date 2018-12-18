package com.infogain.app.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.service.StoreServiceImpl;

@RestController
@RequestMapping("/api")
public class StoreController {
	@Autowired
	StoreServiceImpl storeService;
	@Autowired
	IStoreRepo storeRepo;
	
	@PostMapping("/store")
	public StoreDto insertStore(@RequestBody @Valid StoreDto storeDto) throws InvalidInputException {
		return storeService.insert(storeDto);
	}
	
	@GetMapping("/store")
	public List<StoreDto> displayAllStores(@RequestBody StoreDto storeDto) {
		return storeService.displayAll();
	}
	
	@GetMapping("/store/{id}")
	public StoreDto displayStoreById(@PathVariable(value = "id") Integer storeId) {
		return storeService.displayById(storeId);
	}
	
	@PutMapping("/store")
	public StoreDto updateStore(@RequestBody StoreDto storeDto) throws InvalidInputException {
		return storeService.update(storeDto);
	}
	
	@DeleteMapping("/store/{id}")
	public void deleteStore(@PathVariable(value = "id") Integer storeId) {
		storeService.delete(storeId);
	}
}
