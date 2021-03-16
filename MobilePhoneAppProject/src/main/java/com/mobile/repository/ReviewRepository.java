package com.mobile.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Members;
import com.mobile.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	
	@Override
	@Query("select r from Review r order by r.reviewId DESC")
	public List<Review> findAll();
	
	//memberId 로 review 가져오기 
	@Query("select r from Review r where r.member.memberId=?1 order by r.reviewId DESC")
	public List<Review> findByMemberId(Long memberId);
	
	//officeId 로 review 가져오기 
	@Query("select r from Review r where r.office.officeId= ?1")
	public List<Review> findByOffice(Long officeId);
	
	//마지막 리뷰 id 가져오기
	@Query(value = "SELECT next_val from seq_review sr limit 1", nativeQuery = true)
    public int getNextValMySequence();

}
