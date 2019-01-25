package com.infogain.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.infogain.app.repository.IStoreRepo;
//@EnableJpaRepositories(repositoryFactoryBeanClass=IStoreRepo.class)
//@ComponentScan(basePackages = "com.infogain.app.controller")
@SpringBootApplication
@EnableCaching
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
