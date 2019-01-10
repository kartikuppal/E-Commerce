package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.Product;
import com.infogain.app.entity.Store;

public interface IProductRepo extends JpaRepository<Product, Integer> {
	void save(Store store);
}
