package com.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.domain.Application;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Region;
import com.mobile.domain.Review;
import com.mobile.service.ProductService;
import com.mobile.service.UserService;

@Controller
public class AppController implements AppControllerInterface {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@Override
	public String getAllNotice() {
		
		List<Notice> list = userService.noticeSelectAll();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String getNoticeById(java.lang.Long noticeId) {

		Notice notice = userService.noticeSelectById(noticeId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(notice);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String getUserPoint(Long memberId) {
		
		int pointSum = 0;
		
		List<Point> list = userService.pointSelectUnusedPoint(memberId);
		
		if(list!=null) {
			for(Point obj : list) {
				pointSum += obj.getPoint();
			}
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(pointSum);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String unusedPoint(Long memberId) {
		
		
		List<Point> list = userService.pointSelectUnusedPoint(memberId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public String usedPoint(Long memberId) {
		List<Point> list = userService.pointSelectUsedPoint(memberId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void userRegister(String name, String phone, String regions, String profileImg, String password,
			Integer isvisitor, Long officeId, String userContacts) {
		
		
		Office office = userService.officeSelectById(officeId);
		String memberCode = "";
		
		Members member = new Members(null, name, phone, regions, null, memberCode, password, isvisitor, null, null, office);
		
		userService.memberInsert(member);
		
		
	}

	@Override
	public Members getUser(java.lang.Long id) {
		
		return userService.memberSelectById(id);
		
	}

	@Override
	public int login(String phoneNumber, String password) {
		
	
		return userService.memberLogin(phoneNumber, password);
	}

	@Override
	public void userInfoUpdate(Members members) {
		
		userService.memberUpdate(members);
	}

	@Override
	public void userDropout(java.lang.Long membersId) {
		
		
		
	}

	@Override
	public String getAllCarrier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCarrier(java.lang.Long carrierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllCallingPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCallingPlan(java.lang.Long callingPlanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCallingPlanByCarrierId(java.lang.Long carrierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRegion(java.lang.Long regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllOffice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOffice(java.lang.Long officeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOfficeByRegionId(java.lang.Long regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDevice(java.lang.Long deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProduct(java.lang.Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String productSearch(java.lang.Long carrierId, Integer activtaionType, java.lang.Long deviceId,
			java.lang.Long officeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReccomendationProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addApplication(Application application) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getApplicationByUserId(java.lang.Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApplication(java.lang.Long applicationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllInstallment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstallment(java.lang.Long InstallmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllWiredGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWiredGoods(java.lang.Long wiredGoodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCardId(java.lang.Long cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCardByCarrierId(java.lang.Long carrierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerReview(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllReview() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReviewByMemberId(java.lang.Long memberId) {
		// TODO Auto-generated method stub
		
	}
	


	
	
	

	
	
}
