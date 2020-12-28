package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.GuestProduct;
import com.mobile.domain.Recommendation;

public interface GuestProductRepository extends JpaRepository<GuestProduct, Long> {

}
