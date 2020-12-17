package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long> {

	
	//상태 조건에 맞는 신청서 가져오기
	@Query("select a from Application a where a.state=?1")
	public List<Application> findByState(Integer state);
	
	//멤버 아이디로 신청서 찾기
	@Query("select a from Application a where a.member.memberId=?1")
	public List<Application> findBymemberId(Long memberId);
}
