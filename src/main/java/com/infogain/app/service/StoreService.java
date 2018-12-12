package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IStoreRepo;

@Service
public class StoreService implements IStoreService {
	@Autowired
	private IStoreRepo storeRepo;
	
	public StoreDto EntityToDtoAssembler(StoreDto storeDto, Store store) {
		
		//StoreDto storeDto = new StoreDto();
		storeDto.setId(store.getId());
		storeDto.setName(store.getName());
		storeDto.setAddress(store.getAddress());
		storeDto.setPostalCode(store.getPostalCode());
		storeDto.setContactNo(store.getContactNo());

		return storeDto;
	}
	
	public Store dtoToEntityAssembler(StoreDto storeDto, Store store) {

		//Store store = new Store();
		store.setName(storeDto.getName());
		store.setAddress(storeDto.getAddress());
		store.setPostalCode(storeDto.getPostalCode());
		store.setContactNo(storeDto.getContactNo());

		return store;
	}

	/*inserting values*/
	
	/*public StoreDto insertStore(@RequestBody StoreDto storeDto) throws CustomException {
		Store store = new Store();
		
		store = dtoToEntityAssembler(storeDto);
		
		storeRepo.save(store);
		
		return storeDto;
	}*/
	
	public StoreDto insertStore(@RequestBody @Valid StoreDto storeDto) throws InvalidInputException {
		try {
			Store store = new Store();
			store = dtoToEntityAssembler(storeDto, store);
			storeRepo.save(store);
			storeDto.setId(store.getId());
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return storeDto;
	}
	
	/*displaying all values*/
	
	public List<StoreDto> displayAllStore() {
		
		List<Store> storeList = storeRepo.findAll();
		List<StoreDto> storeDtoList = new ArrayList<>();
		
		for(Store store: storeList) {
			StoreDto storeDto = new StoreDto();
			storeDto = EntityToDtoAssembler(storeDto, store);
			storeDtoList.add(storeDto);
		}
		return storeDtoList;
	}

	/* displaying values by id */

	public StoreDto displayStoreById(Integer id) {
		Store store = storeRepo.findById(id).get();
		StoreDto storeDto = new StoreDto();;
		storeDto = EntityToDtoAssembler(storeDto, store);
		
		return storeDto;
	}

	/* updating values by id */

	public StoreDto updateStore(@RequestBody StoreDto storeDto, Integer id) throws InvalidInputException {
		try {
			id = storeDto.getId();
			Store store = storeRepo.findById(id).get();
			store = dtoToEntityAssembler(storeDto, store);
			store = storeRepo.save(store);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return storeDto;
	}

	/* deleting values by id */

	public void deleteStore(Integer id) {
		storeRepo.deleteById(id);
	}
}
