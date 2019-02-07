package com.infogain.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



import com.infogain.app.repository.IStoreRepo;

@SpringBootApplication
@EnableCaching
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
/*
{
    "name": "Mr. Anonymous",
    "email": "kartik.uppal@infogain.com",
    "address": "Batala road Amritsar",
    "postalCode": "143001",
    "mobileNumber": "9876543212"
    
    }
    
    userName
    password
    Authorization
    
    */