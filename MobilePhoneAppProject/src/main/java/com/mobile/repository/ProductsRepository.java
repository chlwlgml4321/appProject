package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	
	//상태가 활성화된 요금제만 가져오기
	@Query("select p from Products p where p.state=1")
	public List<Products> findActivatedAll();
	
	@Query("select p from Products p where p.activationType=?1 and p.carrier.carrierId=?2 and p.device.deviceId=?3 and p.office.officeId=?4 and p.callingPlan.networkType=?5")
	public List<Products> searching(Integer activationType, Long carrierId, Long deviceId, Long officeId, Integer subcondition);
	
	@Query("select p from Products p where p.activationType=?1 and p.carrier.carrierId=?2 and p.device.deviceId=?3 and p.office.officeId=?4 and p.isReccomendationProducts=1")
	public List<Products> searchingRecoomendation(Integer activationType, Long carrierId, Long deviceId, Long officeId, Integer subcondition);
}
