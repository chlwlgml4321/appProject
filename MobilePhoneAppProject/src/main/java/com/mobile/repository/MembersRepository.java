package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

	//회원의 상태가 1인 회원 가져오기
	@Query("select m from Members m where state=1")
	public List<Members> findActiveMember();
}
