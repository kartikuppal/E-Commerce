package com.infogain.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.entity.Store;
import com.infogain.app.exception.CustomException;
import com.infogain.app.repository.IStoreRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StoreServiceImplTest {
	@Autowired
	private StoreServiceImpl storeService;
	@MockBean
	private  IStoreRepo storeRepo;
	
	@Test
	public void insert() throws CustomException {
		StoreDto storeDto = new StoreDto();
		//storeDto.setId(1);
		storeDto.setName("anil");
		storeDto.setAddress("amritsar india");
		storeDto.setPostalCode("123654");
		storeDto.setContactNo("7896541236");
		
		Store store = new Store();
		store = storeService.dtoToEntityAssembler(storeDto, store);
		
	    Mockito.when(storeRepo.save(store)).thenReturn(store);
	    assertThat(storeService.insert(storeDto)).isEqualTo(storeDto);
	}
	
	@Test
	public void getAll() {
		Store store = new Store();
		store.setId(1);
		store.setName("anil");
		store.setAddress("amritsar india");
		store.setPostalCode("123654");
		store.setContactNo("7896541236");
		
		List<Store> storeList = new ArrayList<>();
		storeList.add(store);
		
		List<StoreDto> storeDtoList = new ArrayList<>();
		
		for(Store stores: storeList) {
			StoreDto storeDto = new StoreDto();
			storeDto = storeService.entityToDtoAssembler(storeDto, stores);
			storeDtoList.add(storeDto);
			}
		
		Mockito.when(storeRepo.findAll()).thenReturn(storeList);
		//assertThat(storeService.displayAll(),is(storeDtoList));
		//assertThat(1,is(storeDtoList.get(0)));
	}
	
	@Test
	public void update(){
		StoreDto storeDto = new StoreDto();
		storeDto.setId(1);
		storeDto.setName("anil");
		storeDto.setAddress("amritsar india");
		storeDto.setPostalCode("123654");
		storeDto.setContactNo("7896541236");
		
		Store store = new Store();
		store = storeService.dtoToEntityAssembler(storeDto, store);
		
		Mockito.when(storeRepo.findById(1).get()).thenReturn(store);
		//Mockito.when(storeRepo.findOne(1)).thenReturn(store);
		
		store.setAddress("india noida");
		Mockito.when(storeRepo.save(store)).thenReturn(store);
		
		assertThat(storeService.update(storeDto)).isEqualTo(storeDto);
		
	}
}
