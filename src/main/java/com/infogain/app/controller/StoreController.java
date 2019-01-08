package com.infogain.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.service.StoreServiceImpl;

@RestController
@RequestMapping("/api")
public class StoreController {
	@Autowired
	private StoreServiceImpl storeService;
	
	@PostMapping("/store")
	public StoreDto insert(@RequestBody @Valid StoreDto storeDto) throws CustomException {
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
	}
}
