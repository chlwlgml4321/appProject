package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {

}
