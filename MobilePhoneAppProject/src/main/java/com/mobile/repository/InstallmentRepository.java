package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Installment;
import com.mobile.domain.Members;
import com.mobile.domain.Review;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {

	
	
	

}
