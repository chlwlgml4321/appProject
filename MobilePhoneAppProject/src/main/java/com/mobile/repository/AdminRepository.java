package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Admin;
import com.mobile.domain.Application;
import com.mobile.domain.Office;


public interface AdminRepository extends JpaRepository<Admin, Long> {

	//tel 로 admin 가져오기 
	@Query("select a from Admin a where a.tel=?1")
	public Admin findByTel(String tel);
	
}
