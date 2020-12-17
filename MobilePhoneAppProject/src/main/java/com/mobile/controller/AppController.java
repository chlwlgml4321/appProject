package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.domain.Application;
import com.mobile.domain.Members;
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
		
		return null;
	}

	@Override
	public String getNoticeById(java.lang.Long noticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserPoint(java.lang.Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unusedPoint(java.lang.Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String usedPoint(java.lang.Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userRegister(String name, String phone, java.lang.Long regionId, String profileImg, String password,
			Integer isvisitor, java.lang.Long officeId, String userContacts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUser(java.lang.Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String login(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userInfoUpdate(Members members) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userDropout(java.lang.Long membersId) {
		// TODO Auto-generated method stub
		
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
