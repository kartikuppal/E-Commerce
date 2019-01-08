package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IStoreRepo;

@Service
public class StoreServiceImpl implements IStoreService {
	@Autowired
	private IStoreRepo storeRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class.getName());

	public StoreDto entityToDtoAssembler(StoreDto storeDto, Store store) {
		storeDto.setId(store.getId());
		storeDto.setName(store.getName());
		storeDto.setAddress(store.getAddress());
		storeDto.setPostalCode(store.getPostalCode());
		storeDto.setContactNo(store.getContactNo());

		return storeDto;
	}
	
	public Store dtoToEntityAssembler(StoreDto storeDto, Store store) {
		store.setName(storeDto.getName());
		store.setAddress(storeDto.getAddress());
		store.setPostalCode(storeDto.getPostalCode());
		store.setContactNo(storeDto.getContactNo());

		return store;
	}

	/*inserting value*/
	
	public StoreDto insert(StoreDto storeDto) throws CustomException {
		if(storeDto.getId() == null) {
			try {
				Store store = new Store();
				store = dtoToEntityAssembler(storeDto, store);
				storeRepo.save(store);
				storeDto.setId(store.getId());
			} catch (Exception e) {
				throw new CustomException(404,"contact number must be unique");
			}
		} else {
			throw new CustomException(404,"you are not allowed to enter ids");
		}
		return storeDto;
	}
	
	/*displaying all values*/
	
	public List<StoreDto> displayAll() {
		
		List<Store> storeList = storeRepo.findAll();
		List<StoreDto> storeDtoList = new ArrayList<>();
		
		for(Store store: storeList) {
			StoreDto storeDto = new StoreDto();
			storeDto = entityToDtoAssembler(storeDto, store);
			storeDtoList.add(storeDto);
			
			logger.info("display>>>>>>>>>>>>");
		}
		return storeDtoList;
	}

	/* displaying value by id */

	public StoreDto displayById(Integer id) {
		Store store = storeRepo.findById(id).get();
		StoreDto storeDto = new StoreDto();;
		storeDto = entityToDtoAssembler(storeDto, store);
		return storeDto;
	}

	/* updating value by id */

	public StoreDto update(StoreDto storeDto) throws InvalidInputException {
		try {
			Integer id = storeDto.getId();
			Store store = storeRepo.findById(id).get();
			store = dtoToEntityAssembler(storeDto, store);
			store = storeRepo.save(store);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return storeDto;
	}

	/* deleting value by id */

	public void delete(Integer id) {
		storeRepo.deleteById(id);
	}
}
