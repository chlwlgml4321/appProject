package com.mobile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.repository.MembersRepository;
import com.mobile.repository.NoticeRepository;
import com.mobile.service.UserService;

@SpringBootTest
class MobilePhoneAppProjectApplicationTests {

	@Autowired
	MembersRepository memberRepo;
	@Autowired
	NoticeRepository noticeRepo;
	
	@Test
	void contextLoads() {
		Members member= new Members(null, "설현", "2233333", "서울시", null,"ABCD", "jiheelove", 1, 2, null, null);
		memberRepo.save(member);
//		Notice notice= new Notice(null, "링피트", "운동된다", null);
//		noticeRepo.save(notice);
	}
	
	
	

}
