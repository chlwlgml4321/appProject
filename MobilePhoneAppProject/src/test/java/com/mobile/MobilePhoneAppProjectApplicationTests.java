package com.mobile;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.domain.Adjustment;
import com.mobile.domain.Application;
import com.mobile.domain.Authority;
import com.mobile.domain.Banners;
import com.mobile.domain.CallingPlan;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.Installment;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.OfficeBoard;
import com.mobile.domain.OfficeNotice;
import com.mobile.domain.Point;
import com.mobile.domain.Products;
import com.mobile.domain.Recommendation;
import com.mobile.domain.Region;
import com.mobile.domain.Replies;
import com.mobile.domain.Review;
import com.mobile.domain.WiredGoods;
import com.mobile.repository.AdjustmentRepository;
import com.mobile.repository.ApplicationRepository;
import com.mobile.repository.AuthorityRepository;
import com.mobile.repository.BannersRepository;
import com.mobile.repository.CallingPlanRepository;
import com.mobile.repository.CardRepository;
import com.mobile.repository.CarrierRepository;
import com.mobile.repository.DeviceRepository;
import com.mobile.repository.InstallmentRepository;
import com.mobile.repository.MembersRepository;
import com.mobile.repository.NoticeRepository;
import com.mobile.repository.OfficeBoardRepository;
import com.mobile.repository.OfficeNoticeRepository;
import com.mobile.repository.OfficeRepository;
import com.mobile.repository.PointRepository;
import com.mobile.repository.ProductsRepository;
import com.mobile.repository.RepliesRepository;
import com.mobile.repository.ReviewRepository;
import com.mobile.repository.WiredGoodsRepository;
import com.mobile.service.ProductService;
import com.mobile.service.UserService;

@SpringBootTest
class MobilePhoneAppProjectApplicationTests {

	@Autowired
	MembersRepository memberRepo;
	@Autowired
	NoticeRepository noticeRepo;

	@Autowired CarrierRepository carrierRepo;

	@Autowired
	ProductService pService;

	@Autowired
	UserService uSerivce;

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	CallingPlanRepository callRepo;

	@Autowired
	OfficeRepository officeRepo;

	@Autowired
	InstallmentRepository installmentRepo;

	@Autowired
	NoticeRepository n;

	@Autowired
	CardRepository c;


	@Autowired
	DeviceRepository d;

	@Autowired
	PointRepository p;

	@Autowired
	ProductsRepository pr;

	@Autowired
	CallingPlanRepository cr;

	@Autowired
	WiredGoodsRepository wr;

	@Autowired
	ReviewRepository rr;

	@Autowired
	ApplicationRepository ar;

	@Autowired
	BannersRepository br;


	@Autowired
	AuthorityRepository aur;


	@Autowired
	DeviceRepository dr;
	
	@Autowired
	OfficeBoardRepository obr;
	
	@Autowired
	OfficeRepository or;
	
	@Autowired
	RepliesRepository rpr;
	
	@Autowired
	AdjustmentRepository adr;
	
	@Autowired
	OfficeNoticeRepository ofr;
	
	@Test
	void contextLoads() {

		
		Office office = or.findById(8L).orElse(null);
		
		Members member = new Members(null, office.getOfficeName(), office.getTel(), null, null, "ADMIN", office.getPassword(), 1, 1, null, office);
		
		memberRepo.save(member);
		
	}

}
