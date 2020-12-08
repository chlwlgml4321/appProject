package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Device;


public interface DeviceRepository extends JpaRepository<Device, Long> {

}
