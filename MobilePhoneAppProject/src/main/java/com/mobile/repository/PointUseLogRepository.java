package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Point;
import com.mobile.domain.PointUseLog;

public interface PointUseLogRepository extends JpaRepository<PointUseLog, Long> {

	
	
	//memberId 로 point 가져오기 
	@Query("select pu from PointUseLog pu where pu.point.member.memberId=?1")
	public List<PointUseLog> findByMemberId(Long memberId);
	
	
	@Modifying
	@Query("delete from PointUseLog pu where pu.point.pointId=?1")
	public void deleteByPointId(Long pointId);
	
	
		
}
