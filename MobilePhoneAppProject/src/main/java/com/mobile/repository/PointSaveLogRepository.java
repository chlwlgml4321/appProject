package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Point;
import com.mobile.domain.PointSaveLog;
import com.mobile.domain.PointUseLog;

public interface PointSaveLogRepository extends JpaRepository<PointSaveLog, Long> {

	
	
	//memberId 로 point 가져오기 
	@Query("select ps from PointSaveLog ps where ps.point.member.memberId=?1")
	public List<PointSaveLog> findByMemberId(Long memberId);
	
	
	

	@Modifying
	@Query("delete from PointSaveLog ps where ps.point.pointId = ?1")
	void deleteByPointId(Long pointId);
	
	
	
		
}
