package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.mobile.domain.Application;
import com.mobile.domain.Members;
import com.mobile.domain.OfficeBoard;
import com.mobile.domain.Replies;


public interface RepliesRepository extends JpaRepository<Replies, Long> {
	
	@Modifying
	@Query("delete from Replies r where r.officeBoard.officeBoardId = ?1")
    void deleteByOfficeBoardId(Long officeBoardId);
	

}
