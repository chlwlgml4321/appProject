package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Members;
import com.mobile.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	
	
	//memberId 로 review 가져오기 
	@Query("select r from Review r where r.member.memberId=?1")
	public List<Review> findByMemberId(Long memberId);
}
