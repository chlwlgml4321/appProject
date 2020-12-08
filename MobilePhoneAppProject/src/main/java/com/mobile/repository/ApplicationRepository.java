package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
