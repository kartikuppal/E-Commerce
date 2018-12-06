package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Product;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IProductRepo;
import com.infogain.app.repository.IStoreRepo;

@Service
public class StoreService implements IStoreService {
	@Autowired
	private IStoreRepo storeRepo;
	
	@Autowired
	private IProductRepo productRepo;
	
	//private 
	/*inserting values*/
	
	public Store insertStore(@RequestBody StoreDto storeDto) throws CustomException {
		
		Store store = new Store();
		
		Store existingContactNo = storeRepo.findByContactNo(storeDto.getContactNo());
		
		if(existingContactNo == null) {
			
			Integer addressLength = storeDto.getAddress().length();
			Integer postalCodeLength = storeDto.getPostalCode().toString().length();
			Integer contactNoLength = storeDto.getContactNo().toString().length();
			
			if( addressLength > 10) {
				if( postalCodeLength == 6) {
					if( contactNoLength == 10) {
						store.setName(storeDto.getName());
						store.setAddress(storeDto.getAddress());
						store.setPostalCode(storeDto.getPostalCode());
						store.setContactNo(storeDto.getContactNo());
						
						/*adding products in store*/
						
						//List <Product> product = 
						//store.getProduct().forEach((product)->{product.setStore((List<Store>) store);});
						
						List<Product> productList = new ArrayList<>();
						
						for (int i = 0; i < storeDto.getProductId().size(); i++) {
							Integer productId = storeDto.getProductId().get(i);
							 Product product = productRepo.findById(productId).get();
							 productList.add(product);
							 
							 /*System.out.println(roleID+"id");
							 System.out.println(roles+"aaaa");
							 System.out.println(user+"bbbb");*/
							 
							 }
						store.setProduct(productList);
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
