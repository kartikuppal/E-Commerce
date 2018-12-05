package com.infogain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.app.entity.Product;

public interface IProductRepo extends JpaRepository<Product, Integer>{

}
