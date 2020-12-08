package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
