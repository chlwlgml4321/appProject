package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Admin;
import com.mobile.domain.Application;
import com.mobile.domain.Authority;
import com.mobile.domain.Office;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	
}
