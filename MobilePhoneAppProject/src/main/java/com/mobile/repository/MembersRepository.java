package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

	//회원의 상태가 1인 회원 가져오기
	@Query("select m from Members m where m.state=1 or m.state=0")
	public List<Members> findActiveMember();
	
	//회원의 상태가 2인 회원 가져오기
	@Query("select m from Members m where m.state=2")
	public List<Members> findInactiveMember();
	
	@Query("select m from Members m where m.phone = ?1")
	public Members findByPhone(String phone);
	
	@Query("select m from Members m where m.phone = ?1 and m.password = ?2")
	public Members findByPhoneAndPwd(String phone, String password);
	
	//officeId 로 회원가져오기 
	@Query("select m from Members m where m.office.officeId = ?1")
	public List<Members> findByOffice(Long officeId);
}
