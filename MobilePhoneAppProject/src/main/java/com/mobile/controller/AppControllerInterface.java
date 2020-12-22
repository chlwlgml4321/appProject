package com.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobile.domain.Application;
import com.mobile.domain.Members;
import com.mobile.domain.Review;

@Controller
public interface AppControllerInterface {

	
	/**
	 * notice
	 * */
	//notice 전체 조회
	@RequestMapping("/app/getAllNotice")
	public String getAllNotice();
	
	//notice id로 조회
	@RequestMapping("/app/getNoticeById")
	public String getNoticeById(Long noticeId);
	
	/**
	 * point
	 * */
	//id로 가져온 point 합산
	@RequestMapping("/app/getUserPoint")
	public String getUserPoint(Long id);
	
	//id에 해당되는 미사용 포인트 조회
	@RequestMapping("/app/getUnusedPoint")
	public String unusedPoint(Long id);
	
	//id에 해당되는 사용 포인트 조회
	@RequestMapping("/app/getUsedPoint")
	public String usedPoint(Long id);
	
	
	
	
	/**
	 * members
	 * */
	//member 회원 가입( 성공 시 1, 실패 시 0)
	@RequestMapping("/app/userRegister")
	public void userRegister(String name, String phone, String regions, String profileImg, String password, Integer isvisitor, Long officeId, String userContacts);
	
	//member id로 조회
	@RequestMapping("/app/getUser")
	public Members getUser(Long id);
	
	//member 로그인(성공 시 1 , 승인 대기중으로 인한 실패 2, 인증오류로 인한 실패 3 )
	@RequestMapping("/app/login")
	public String login(String phoneNumber, String password);
	
	//member 정보 수정
	@RequestMapping("/app/userInfoUpdate")
	public void userInfoUpdate(Members members);
	
	//회원 탈퇴 
	@RequestMapping("/app/userDropout")
	public void userDropout(Long membersId);
		
	/**
	 * 통신사
	 * */
	//통신사 전체 조회
	@RequestMapping("/app/getAllCarrier")
	public String getAllCarrier();
	
	//통신사 id로 조회
	@RequestMapping("/app/getCarrier")
	public String getCarrier(Long carrierId);
	
	/**
	 * 요금제
	 * */
	//요금제 전체조회
	@RequestMapping("/app/getAllCallingPlan")
	public String getAllCallingPlan();
	
	
	//요금제 id로 조회
	@RequestMapping("/app/getCallingPlan")
	public String getCallingPlan(Long callingPlanId);
	
	//통신사로 요금제 조회
	@RequestMapping("/app/getCallingPlanByCarrierId")
	public String getCallingPlanByCarrierId(Long carrierId);
	
	/**
	 * 지역
	 * */
	//지역 전체조회
	@RequestMapping("/app/getAllRegion")
	public String getAllRegion();
	
	//지역 id로 조회
	@RequestMapping("/app/getRegion")
	public String getRegion(Long regionId);
	
	
	/**
	 * 지점
	 * */
	//지점 전체 조회
	@RequestMapping("/app/getAllOffice")
	public String getAllOffice();
	//지점 id로 조회
	@RequestMapping("/app/getOffice")
	public String getOffice(Long officeId);
	//지역 id로 조회
	@RequestMapping("/app/getOfficeByRegionId")
	public String getOfficeByRegionId(Long regionId);
	
	/**
	 * 기기
	 * */
	//기기 전체 조회
	@RequestMapping("/app/getAllDevice")
	public String getAllDevice();
	
	//기기 id로 조회
	@RequestMapping("/app/getDevice")
	public String getDevice(Long deviceId);
	
	/**
	 * 특가 상품
	 * */
	// 특가 상품 전체조회
	@RequestMapping("/app/getAllProduct")
	public String getAllProduct();
	
	// 특가 상품 id로 조회
	@RequestMapping("/app/getProduct")
	public String getProduct(Long productId);
	
	// 특가 상품을 조건에 맞게 검색(통신사, 기기변경, 모델명, 네트워크 타입), 지점
	@RequestMapping("/app/productSearch")
	public String productSearch(Long carrierId, Integer activtaionType, Long deviceId, Long officeId, int subcpndition);
	
	//추천 특가 상품 조회
	@RequestMapping("/app/getReccomendationProduct")
	public String getReccomendationProduct();
	
	/**
	 * 신청서 
	 * */
	
	//신청서 등록
	@RequestMapping("/app/addApplication")
	public void addApplication(Application application);
	
	//신청서 member id로 조회
	@RequestMapping("/app/getApplicationByUserId")
	public String getApplicationByUserId(Long userId);
	
	//신청서 application id로 조회
	@RequestMapping("/app/getApplication")
	public String getApplication(Long applicationId);
	
	//신청서 전체 조회
	@RequestMapping("/app/getAllApplication")
	public String getAllApplication();
	
	
	/**
	 * 할부 
	 * */
	
	//할부 전체 조회
	@RequestMapping("/app/getAllInstallment")
	public String getAllInstallment();
	//할부 id로 조회
	@RequestMapping("/app/getInstallment")
	public String getInstallment(Long InstallmentId);
	/**
	 * 유선 상품
	 * */
	// 유선 상품 전체 조회
	@RequestMapping("/app/getAllWiredGoods")
	public String getAllWiredGoods();
	
	// 유선 상품 id로 조회
	@RequestMapping("/app/getWiredGoods")
	public String getWiredGoods(Long wiredGoodsId);
	
	/**
	 * 할인 카드
	 * */
	// 할인카드 전체 조회
	@RequestMapping("/app/getAllCard")
	public String getAllCard();
	
	// 할인카드 card id로 조회
	@RequestMapping("/app/getCardId")
	public String getCardId(Long cardId);
	
	// 할인카드 통신사로 조회
	@RequestMapping("/app/getCardByCarrierId")
	public String getCardByCarrierId(Long carrierId);
	
	/**
	 * 리뷰
	 * */
	// 리뷰 등록
	@RequestMapping("/app/registerReview")
	public void registerReview(Review review);
	
	// 전체 리뷰 조회
	@RequestMapping("/app/getAllReview")
	public String getAllReview();
	
	// memembers id로 리뷰 조회
	@RequestMapping("/app/getReviewByMemberId")
	public String getReviewByMemberId(Long memberId);
	
	
	
	
	
	
}
