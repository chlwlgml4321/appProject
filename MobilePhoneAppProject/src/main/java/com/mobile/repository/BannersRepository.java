package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Banners;
import com.mobile.domain.Blacklist;


public interface BannersRepository extends JpaRepository<Banners, Long> {

}
