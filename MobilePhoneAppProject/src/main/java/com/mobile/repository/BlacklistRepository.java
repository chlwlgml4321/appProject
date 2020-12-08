package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Blacklist;


public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {

}
