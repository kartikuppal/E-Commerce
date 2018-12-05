package com.infogain.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.Product;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IStoreRepo;

@Service
public class StoreService implements IStoreService {
	@Autowired
	IStoreRepo storeRepo;
	
	/*inserting values*/
	
	@SuppressWarnings("unchecked")
	public Store insertStore(Store store) throws CustomException {
		Store existingContactNo = storeRepo.findByContactNo(store.getContactNo());
		
		if(existingContactNo == null) {
			
			Integer addressLength = store.getAddress().length();
			Integer postalCodeLength = store.getPostalCode().toString().length();
			Integer contactNoLength = store.getContactNo().toString().length();
			
			if( addressLength > 10) {
				if( postalCodeLength == 6) {
					if( contactNoLength == 10) {
						store.setName(store.getName());
						store.setAddress(store.getAddress());
						store.setPostalCode(store.getPostalCode());
						store.setContactNo(store.getContactNo());
						
						/*adding products in store*/
						
						store.getProduct().forEach((product)->{product.setStore((List<Store>) store);});
					}
					else {
						throw new CustomException("Contact number must be of length 10");
					}
				}
				else {
					throw new CustomException("Postal Code must be of length 6");
				}
			}
			else {
				throw new CustomException("Address size must be greater than 10");
			}
		} else {
			
			throw new CustomException("Store with this contact number already exists");
		}
		return storeRepo.save(store);
	}
	
	/*displaying values*/
	
	public List<Store> displayStore() {
		return storeRepo.findAll();
	}
	
	/*displaying values by id*/
	
	public Store displayStoreById(Integer id) {
		Store store = storeRepo.findById(id).get();
		return store;
		
	}
	
	/*updating values by id*/
	
	public Store updateStore(Store updatedStore, Integer id) throws CustomException {
		
		Store store = storeRepo.findById(id).get();
		
		Store ContactNo = storeRepo.findByContactNo(updatedStore.getContactNo());
		
		if(ContactNo == null) {
			
			Integer addressLength = updatedStore.getAddress().length();
			Integer postalCodeLength = updatedStore.getPostalCode().toString().length();
			Integer contactNoLength = updatedStore.getContactNo().toString().length();
			
			if( addressLength > 10) {
				if( postalCodeLength == 6) {
					if( contactNoLength == 10) {
						store.setName(updatedStore.getName());
						store.setAddress(updatedStore.getAddress());
						store.setPostalCode(updatedStore.getPostalCode());
						store.setContactNo(updatedStore.getContactNo());
					}
					else {
						throw new CustomException("Contact number must be of length 10");
					}
				}
				else {
					throw new CustomException("Postal Code must be of length 6");
				}
			}
			else {
				throw new CustomException("Address size must be greater than 10");
			}
		} else {
			
			throw new CustomException("Store with this contact number already exists");
		}
		store = storeRepo.save(store);
		
		return store;
	}
	
	/*deleting values by id*/
	
	public void deleteStore(Integer id) {
		storeRepo.deleteById(id);
	}
}
