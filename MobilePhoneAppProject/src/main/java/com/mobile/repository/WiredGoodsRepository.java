package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Card;
import com.mobile.domain.Members;
import com.mobile.domain.Review;
import com.mobile.domain.WiredGoods;

public interface WiredGoodsRepository extends JpaRepository<WiredGoods, Long> {

	


	@Query("select w from WiredGoods w where w.carrier.carrierId=?1")
	public List<WiredGoods> findByCarrier(Long carrierId);
}
