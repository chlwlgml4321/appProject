package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Office;
import com.mobile.domain.OfficeNotice;
import com.mobile.domain.Review;

public interface OfficeNoticeRepository extends JpaRepository<OfficeNotice, Long> {

	
	//regionId 로 office 가져오기 
	@Query("select ofn from OfficeNotice ofn where ofn.office.officeId=?1")
	public List<OfficeNotice> findByOfficenId(Long officeId);
	
}
