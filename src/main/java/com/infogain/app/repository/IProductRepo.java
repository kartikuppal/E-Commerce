package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.app.entity.Product;
import com.infogain.app.entity.Store;
@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {
	void save(Store store);
}
