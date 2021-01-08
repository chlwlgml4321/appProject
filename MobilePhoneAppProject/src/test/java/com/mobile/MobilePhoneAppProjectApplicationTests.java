package com.mobile;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.domain.Application;
import com.mobile.domain.Banners;
import com.mobile.domain.CallingPlan;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.Installment;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Products;
import com.mobile.domain.Recommendation;
import com.mobile.domain.Region;
import com.mobile.domain.Review;
import com.mobile.domain.WiredGoods;
import com.mobile.repository.ApplicationRepository;
import com.mobile.repository.BannersRepository;
import com.mobile.repository.CallingPlanRepository;
import com.mobile.repository.CardRepository;
import com.mobile.repository.CarrierRepository;
import com.mobile.repository.DeviceRepository;
import com.mobile.repository.InstallmentRepository;
import com.mobile.repository.MembersRepository;
import com.mobile.repository.NoticeRepository;
import com.mobile.repository.OfficeRepository;
import com.mobile.repository.PointRepository;
import com.mobile.repository.ProductsRepository;
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
	

	@Test
	void contextLoads() {
		
		
		
		
//		for(int i = 0; i<30; i++){
//			
//			WiredGoods w  = new WiredGoods();
//			
//			wr.save(w);
//		}
//		

		
		
		
		Banners banners = new Banners(null, "https://phonestorimage.s3.ap-northeast-2.amazonaws.com/banner_img/photo.png", "Galaxy20 S20+", "4 days of discovery");

		
		br.save(banners);





	}

}
