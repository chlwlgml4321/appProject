package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Carrier;


public interface CarrierRepository extends JpaRepository<Carrier, Long> {

}
