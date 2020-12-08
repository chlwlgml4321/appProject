package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Office;
import com.mobile.domain.Review;

public interface OfficeRepository extends JpaRepository<Office, Long> {

	
	
	//regionId 로 office 가져오기 
	@Query("select o from Office o where o.region.regionId=?1")
	public List<Office> findByRegionId(Long regionId);
	
	//officeState 가 1인것만 가져오기 
	@Query("select o from Office o where o.state=1")
	public List<Office> findByState();
	
}
