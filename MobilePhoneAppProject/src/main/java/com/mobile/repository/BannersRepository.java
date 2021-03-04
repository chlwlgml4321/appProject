package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Banners;



public interface BannersRepository extends JpaRepository<Banners, Long> {

	//마지막 device id 가져오기
	@Query(value = "SELECT next_val from seq_banner sb", nativeQuery = true)
    public int getNextValMySequenceInBanner();
}
