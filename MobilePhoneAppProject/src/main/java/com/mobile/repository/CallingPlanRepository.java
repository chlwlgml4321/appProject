package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.mobile.domain.CallingPlan;

public interface CallingPlanRepository extends JpaRepository<CallingPlan, Long> {

	
	//상태가 활성화된 요금제만 가져오기
	@Query("select cp from CallingPlan cp where cp.state=1")
	public List<CallingPlan> findActivatedAll();
	
	
	//통신사로 요금제 가져오기
	@Query("select cp from CallingPlan cp where cp.carrier.carrierId=?1")
	public List<CallingPlan> findByCarrier(Long carrierId);
}
