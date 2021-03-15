package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Device;


public interface DeviceRepository extends JpaRepository<Device, Long> {

	
	//마지막 device id 가져오기
		@Query(value = "SELECT next_val from seq_device sd limit 1", nativeQuery = true)
	    public int getNextValMySequenceInDevice();
}
