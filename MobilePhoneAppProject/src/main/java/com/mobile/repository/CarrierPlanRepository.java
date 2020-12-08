package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Carrier;


public interface CarrierPlanRepository extends JpaRepository<Carrier, Long> {

}
