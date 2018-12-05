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
	public Store insertStore(@RequestBody Store store) throws CustomException {
		return storeService.insertStore(store);
	}
	
	@GetMapping("/store")
	public List<Store> displayAllStores(@RequestBody Store store) {
		return storeService.displayStore();
	}
	
	@GetMapping("/store/{id}")
	public Store displayStoreById(@PathVariable(value = "id") Integer storeId) {
		return storeService.displayStoreById(storeId);
	}
	
	@PutMapping("/store/{id}")
	public Store updateStore(@RequestBody Store store, @PathVariable(value = "id") Integer storeId) throws CustomException {
		return storeService.updateStore(store, storeId);
	}

	@DeleteMapping("/store/{id}")
	public void deleteStore(@PathVariable(value = "id") Integer storeId) {
		storeService.deleteStore(storeId);
	}
}
