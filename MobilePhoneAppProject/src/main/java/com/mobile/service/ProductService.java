package com.mobile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobile.domain.Application;
import com.mobile.domain.CallingPlan;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.GuestProduct;
import com.mobile.domain.Installment;
import com.mobile.domain.Members;
import com.mobile.domain.Products;
import com.mobile.domain.WiredGoods;

@Service
public interface ProductService {

	/**
	 * Application, CallingPlan, Carrier, Device, MainSupportFind, MarketSupportFund, Products, Recommendation
	 * 
	 * */
	
	//Application table
	/**
	 * 신청서 전체 조회
	 * */
	public List<Application> applicationSelectAll();
	
	/**
	 * 상태에 따른 신청서 조회
	 * */
	public List<Application> applicationSelectByState(Integer state);
	
	/**
	 * member id로 신청서 조회
	 * */
	public List<Application> applicationSelectByMemberId(Long memberId);
	
	/**
	 * 신청서 아이디로 조회
	 * */
	public Application applicationSelectById(Long applicationId);
	

	/**
	 * 신청서 삽입 
	 * */
	public void applicationInsert(Application application);
	
	/**
	 * 신청서 정보 수정하기
	 * */
	public void applicationUpdate(Application application);
		

	//CallingPlan table
	/**
	 * 요금제 전체 조회
	 * */
	public List<CallingPlan> callingPlanSelectAll();
	
	/**
	 * 활성회된 요금제 전체 조회
	 * */
	public List<CallingPlan> callingPlanSelectActivatedAll();
	
	/**
	 * 통신사로 요금제 조회
	 * */
	public List<CallingPlan> callingPlanSelectByCarrierId(Long carrierId);

	/**
	 * 요금제 조회
	 * */
	public CallingPlan callingPlanSelectById(Long callingPlanId);
	
	/**
	 * 요금제 삽입 
	 * */
	public void callingPlanInsert(CallingPlan callingPlan);
	
	/**
	 * 요금제 정보 수정하기
	 * */
	public void callingPlanUpdate(CallingPlan callingPlan);
	
	/**
	 * 요금제 상태 삭제하기
	 * */
	public void callingPlanChangeState(Long callingPlanId);
	
	
	
	//Carrier table
	/**
	 * 통신사 전체 조회
	 * */
	public List<Carrier> carrierSelectAll();
	
	/**
	 * 통신사 아이디로 조회
	 * */
	public Carrier carrierSelectById(Long carrierId);

	/**
	 * 통신사 삽입 
	 * */
	public void carrierInsert(Carrier carrier);
	
	/**
	 * 통신사 수정하기
	 * */
	public void carrierUpdate(Carrier carrier);

	//Device table
	/**
	 * 기기 전체 조회
	 * */
	public List<Device> deviceSelectAll();
	
	/**
	 * 기기 아이디로 조회
	 * */
	public Device deviceSelectById(Long deviceId);

	/**
	 * 기기 삽입 
	 * */
	public void deviceInsert(Device device);
	
	/**
	 * 기기 수정하기
	 * */
	public void deviceUpdate(Device device);
	
	/**
	 * 기기 상태변경
	 * */
	public void deviceChangeState(Long deviceId);
	
	//Products table
	/**
	 * 상품 전체 조회
	 * */
	public List<Products> productsSelectAll();
	
	
	/**
	 * 상품 id로 조회
	 * */
	public Products productsSelectById(Long Id);
	
	/**
	 * 활성화된 상품만 조회
	 * */
	public List<Products> productsSelectActivatedAll();
	
	/**
	 * 조건에 맞게 조회
	 * type 1 : 5G
	 * type 2 : LTE
	 * type 3 : Recommendation Products
	 * */
	public List<Products> productsSearching(Long carrierId, Integer activationType, Long deviceId, Integer subcondition, Long officeId);
	
	
	
	/**
	 * 상품 삽입
	 * */
	public void productInsert(Products product);
	
	/**
	 * 상품 수정
	 * */
	public void productUpdate(Products product);
	
	
	/**
	 * 상품 상태변경
	 * */
	public void productChangeState(Long productsId);

	
	
	//Recommendation table
	
	
	//Installment Table
	/**
	 * 할부 전체 조회
	 * */
	public List<Installment> installmentSelectAll();
	
	/**
	 * 할부 id로 조회
	 * */
	public Installment installmentSelectById(Long installmentId);
	
	//Wired Goods Table
	/**
	 * 유선 상품 전체조회
	 * */
	public List<WiredGoods> wiredGoodsSelectAll();
	
	/**
	 * 활성화된 상품 전체조회
	 * */
	public List<WiredGoods> wiredGoodsSelectActivatedAll();
	
	/**
	 * 유선 상품 id로 조회
	 * */
	public WiredGoods wiredGoodsSelectById(Long wiredGoodId);
	
	/**
	 * 유선 상품 삽입
	 * */
	public void wiredGoodsInsert(WiredGoods wiredGoods);
	
	/**
	 * 유선 상품 수정
	 * */
	public void wiredGoodsUpdate(WiredGoods wiredGoods);
	
	/**
	 * 유선 상품 삭제
	 * state를 변경
	 * */
	public void wiredGoodsDelete(Long wiredGoodsId);
	
	//Card Table
	
	/**
	 * 할인 카드 전체 조회
	 * */
	public List<Card> cardSelectAll();

	
	/**
	 * 활성화된 카드 전체 조회
	 * */
	public List<Card> cardSelectActivatedAll();
	
	/**
	 * 카드 id로 조회
	 * */
	public Card cardSelectById(Long cardId);
	
	/**
	 * 카드 삽입
	 * */
	public void cardInsert(Card card);
	
	/**
	 * 카드 수정
	 * */
	public void cardUpdate(Card card);
	
	/**
	 * 카드 삭제
	 * */
	public void cardDelete(Long cardId);

	List<Products> productFindReccomendaion();

	List<Card> cardSelectByCarrierId(Long carrierId);
	
	
	//GuestProduct
	
	/**
	 * 방문 회원 상품 전체 조회
	 * */
	public List<GuestProduct> guestProductSelectAll(); 
	
	/**
	 * 방문 회원 상품 id로 조회
	 * */
	public GuestProduct guestProductSelectById(Long id);
	
	/**
	 * 방문 회원 상품 삽입
	 * */
	public void guestProductInsert(GuestProduct guestProduct);
	
	/**
	 * 방문 회원 상품 수정
	 * */
	public void guestProductUpdate(GuestProduct guestProduct);
	
	/**
	 * 방문 회원 상품 삭제
	 * */
	public void guestProductDelete(Long id);
	
	
	
}