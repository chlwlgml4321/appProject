package com.mobile.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.GuestProduct;

public interface GuestProductRepository extends JpaRepository<GuestProduct, Long> {


	@Query("select p from GuestProduct p where p.activationType=?1 and p.carrier.carrierId=?2 and p.device.deviceId=?3 and p.callingPlan.networkType=?4")
	public List<GuestProduct> searching(Integer activationType, Long carrierId, Long deviceId, Integer subcondition);
	
	@Query("select p from GuestProduct p where p.activationType=?1 and p.carrier.carrierId=?2 and p.device.deviceId=?3 and p.isReccomendationProducts=1")
	public List<GuestProduct> searchingRecoomendation(Integer activationType, Long carrierId, Long deviceId, Integer subcondition);
}
