package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IProductRepo;
import com.infogain.app.repository.IStoreRepo;

@Service
public class StoreService implements IStoreService {
	@Autowired
	private IStoreRepo storeRepo;
	
	public StoreDto EntityToDtoAssembler(Store store) {
		
		StoreDto storeDto = new StoreDto();
		storeDto.setId(store.getId());
		storeDto.setName(store.getName());
		storeDto.setAddress(store.getAddress());
		storeDto.setPostalCode(store.getPostalCode());
		storeDto.setContactNo(store.getContactNo());

		return storeDto;
	}
	
	public Store dtoToEntityAssembler(StoreDto storeDto) {

		Store store = new Store();
		store.setId(storeDto.getId());
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
	
	public StoreDto insertStore(@RequestBody StoreDto storeDto) throws CustomException {
		Store store = new Store();
		
		Store existingContactNo = storeRepo.findByContactNo(storeDto.getContactNo());
		
		if(existingContactNo == null) {
			Integer addressLength = storeDto.getAddress().length();
			Integer postalCodeLength = storeDto.getPostalCode().toString().length();
			Integer contactNoLength = storeDto.getContactNo().toString().length();
			
			if( addressLength > 10) {
				if( postalCodeLength == 6) {
					if( contactNoLength == 10) {
						store = dtoToEntityAssembler(storeDto);
					} else {
						throw new CustomException("Contact number must be of length 10");
						}
				} else {
					throw new CustomException("Postal Code must be of length 6");
					}
			} else {
				throw new CustomException("Address size must be greater than 10");
				}
			} else {
				throw new CustomException("Store with this contact number already exists");
				}
		
		storeRepo.save(store);
		
		return storeDto;
	}
	
	public List<StoreDto> displayAllStore() {
		
		List<Store> storeList = storeRepo.findAll();
		
		List<StoreDto> storeDtoList = new ArrayList<>();
		
		for(Store store: storeList) {
			StoreDto storeDto;
			
			storeDto = EntityToDtoAssembler(store);
			
			storeDtoList.add(storeDto);
		}
		return storeDtoList;
	}

	/* displaying values by id */

	public StoreDto displayStoreById(Integer id) {
		Store store = storeRepo.findById(id).get();
		
		StoreDto storeDto;
		
		storeDto = EntityToDtoAssembler(store);
		
		return storeDto;
	}

	/* updating values by id */

	public StoreDto updateStore(@RequestBody StoreDto storeDto, Integer id) throws CustomException {
		id = storeDto.getId();
		Store store = storeRepo.findById(id).get();

		Store ContactNo = storeRepo.findByContactNo(storeDto.getContactNo());

		if (ContactNo == null) {

			Integer addressLength = storeDto.getAddress().length();
			Integer postalCodeLength = storeDto.getPostalCode().toString().length();
			Integer contactNoLength = storeDto.getContactNo().toString().length();

			if (addressLength > 10) {
				if (postalCodeLength == 6) {
					if (contactNoLength == 10) {
						store = dtoToEntityAssembler(storeDto);
					} else {
						throw new CustomException("Contact number must be of length 10");
					}
				} else {
					throw new CustomException("Postal Code must be of length 6");
				}
			} else {
				throw new CustomException("Address size must be greater than 10");
			}
		} else {

			throw new CustomException("Store with this contact number already exists");
		}
		store = storeRepo.save(store);

		return storeDto;
	}

	/* deleting values by id */

	public void deleteStore(Integer id) {
		storeRepo.deleteById(id);
	}
}
