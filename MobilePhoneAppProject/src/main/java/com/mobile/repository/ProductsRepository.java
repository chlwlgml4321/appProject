package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	
	//상태가 활성화된 요금제만 가져오기
	@Query("select p from Products p where p.state=1")
	public List<Products> findActivatedAll();
}
