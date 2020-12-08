package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

}
