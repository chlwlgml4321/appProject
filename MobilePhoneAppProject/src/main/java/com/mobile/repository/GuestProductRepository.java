package com.mobile.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.GuestProduct;

public interface GuestProductRepository extends JpaRepository<GuestProduct, Long> {

	
}
