package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Adjustment;
import com.mobile.domain.Office;
import com.mobile.domain.OfficeNotice;
import com.mobile.domain.Review;

public interface AdjustmentRepository extends JpaRepository<Adjustment, Long> {

	
	
	
}
