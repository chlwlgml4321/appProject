package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
