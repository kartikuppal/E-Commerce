package com.infogain.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableJpaRepositories(repositoryFactoryBeanClass=IStoreRepo.class)
//@ComponentScan(basePackages = "com.infogain.app.controller")
@SpringBootApplication
@EnableCaching
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
