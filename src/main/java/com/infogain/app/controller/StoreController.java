package com.infogain.app.controller;

import java.util.List;

<<<<<<< HEAD
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.StoreServiceImpl;
=======
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.service.StoreService;
>>>>>>> 7dd7faed42c06206121171f492f4016151683369

@RestController
@RequestMapping("/api")
public class StoreController {
	@Autowired
<<<<<<< HEAD
	private StoreServiceImpl storeService;
	
	@PostMapping("/store")
	public StoreDto insert(@RequestBody @Valid StoreDto storeDto) throws InvalidInputException, CustomException {
		return storeService.insert(storeDto);
	}
	
	@GetMapping(value = "/store")
	public List<StoreDto> getAll() {
		return storeService.displayAll();
	}
	
	@GetMapping(value = "/store/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StoreDto getById(@PathVariable(value = "id") Integer storeId) {
		return storeService.displayById(storeId);
	}
	
	@PutMapping("/store")
	public StoreDto update(@RequestBody StoreDto storeDto) throws InvalidInputException {
		return storeService.update(storeDto);
	}
	
	@DeleteMapping("/store/{id}")
	public void delete(@PathVariable(value = "id") Integer storeId) {
		storeService.delete(storeId);
=======
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
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	}
}
