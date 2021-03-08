package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

	
	
	//memberId 로 point 가져오기 
	@Query("select p from Point p where p.member.memberId=?1")
	public List<Point> findByMemberId(Long memberId);
	
	
	//미사용 포인트 가져오기 
	@Query("select p from Point p where p.member.memberId=?1 and p.point > 0")
	public List<Point> findByUnusedPoint(Long memberId);
	
		
}
