package com.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.domain.Application;
import com.mobile.domain.Banners;
import com.mobile.domain.CallingPlan;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.GuestProduct;
import com.mobile.domain.Installment;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Products;
import com.mobile.domain.Region;
import com.mobile.domain.Reservations;
import com.mobile.domain.Review;
import com.mobile.domain.SearchResults;
import com.mobile.domain.WiredGoods;
import com.mobile.service.ProductService;
import com.mobile.service.UserService;

@Controller
public class AppController implements AppControllerInterface {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@Override
	@ResponseBody
	@RequestMapping("/app/getAllNotice")
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
	@RequestMapping("/app/getNoticeById")
	@ResponseBody
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
	@RequestMapping("/app/getUserPoint")
	@ResponseBody
	public String getUserPoint(Long memberId) {
		
		int pointSum = 0;
		
		List<Point> list = userService.pointSelectUnusedPoint(memberId);
		
		if(list!=null) {
			for(Point obj : list) {
				System.out.println(obj.getPoint());
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
	@RequestMapping("/app/unusedPoint")
	@ResponseBody
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
	@RequestMapping("/app/usedPoint")
	@ResponseBody
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
	@RequestMapping("/app/userRegister")
	@ResponseBody
	public int userRegister(String name, String phone, String regions, String profileImg, String password,
			Integer isvisitor, Long officeId, String userContacts) {
		
		
		Office office = userService.officeSelectById(officeId);
		String memberCode = "";
		
		Members member = new Members(null, name, phone, regions, null, memberCode, password, isvisitor, null, null, office);
		
		return userService.memberInsert(member);
		
		
	}

	@Override
	@RequestMapping("/app/getUser")
	@ResponseBody
	public Members getUser(java.lang.Long id) {
		
		return userService.memberSelectById(id);
		
	}

	@Override
	@RequestMapping("/app/memberLogin")
	@ResponseBody
	public String login(String phoneNumber, String password) {
		
	 	
		
		Members member = userService.memberLogin(phoneNumber, password);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(member);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/userInfoUpdate")
	@ResponseBody
	public void userInfoUpdate(Members members) {
		
		userService.memberUpdate(members);
	}

	@Override
	@RequestMapping("/app/userDropout")
	@ResponseBody
	public void userDropout(java.lang.Long membersId) {
		
		
		
		
	}

	@Override
	@RequestMapping("/app/getAllCarrier")
	@ResponseBody
	public String getAllCarrier() {
		
		List<Carrier> list = productService.carrierSelectAll();
		
		
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
	@RequestMapping("/app/getCarrier")
	@ResponseBody
	public String getCarrier(java.lang.Long carrierId) {
		Carrier carrier = productService.carrierSelectById(carrierId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(carrier);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	@RequestMapping("/app/getAllCallingPlan")
	@ResponseBody
	public String getAllCallingPlan() {
		List<CallingPlan> list = productService.callingPlanSelectActivatedAll();
		
		
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
	@RequestMapping("/app/getCallingPlan")
	@ResponseBody
	public String getCallingPlan(Long callingPlanId) {
		
		System.out.println("c");
		CallingPlan callinPlan = productService.callingPlanSelectById(callingPlanId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(callinPlan);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getCallingPlanByCarrierId")
	@ResponseBody
	public String getCallingPlanByCarrierId(java.lang.Long carrierId) {
		
		List<CallingPlan> list = productService.callingPlanSelectByCarrierId(carrierId);
		
		
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
	@RequestMapping("/app/getAllRegion")
	@ResponseBody
	public String getAllRegion() {
		
		List<Region> list = userService.regionSelectAll();
		
		
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
	@RequestMapping("/app/getRegion")
	@ResponseBody
	public String getRegion(java.lang.Long regionId) {
		
		Region region = userService.regionSelectById(regionId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(region);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getAllOffice")
	@ResponseBody
	public String getAllOffice() {
		List<Office> list = userService.officeSelectActivatedAll();
		
		
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
	@RequestMapping("/app/getOffice")
	@ResponseBody
	public String getOffice(java.lang.Long officeId) {
		Office office = userService.officeSelectById(officeId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(office);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getOfficeByRegionId")
	@ResponseBody
	public String getOfficeByRegionId(java.lang.Long regionId) {
		List<Office> list = userService.officeSelectByRegionId(regionId);
		
		
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
	@RequestMapping("/app/getAllDevice")
	@ResponseBody
	public String getAllDevice() {

		List<Device> list = productService.deviceSelectAll();
		
		
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
	@RequestMapping("/app/getDevice")
	@ResponseBody
	public String getDevice(java.lang.Long deviceId) {
		
		Device device = productService.deviceSelectById(deviceId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(device);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getAllProduct")
	@ResponseBody
	public String getAllProduct() {
		List<Products> list = productService.productsSelectAll();
		
		
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
	@RequestMapping("/app/getProduct")
	@ResponseBody
	public String getProduct(java.lang.Long productId) {
		
		Products product = productService.productsSelectById(productId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(product);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/productSearch")
	@ResponseBody
	public String productSearch(java.lang.Long carrierId, Integer activationType, java.lang.Long deviceId,
			java.lang.Long officeId, int subcondition) {
		
		List<Products> list = productService.productsSearching(carrierId, activationType, deviceId, subcondition, officeId);
		
		System.out.println("list size : " + list.size());
		
		List<SearchResults> srList = new ArrayList<SearchResults>();
		
		for(Products p : list) {
			SearchResults sr = new SearchResults(p.getProductsId(), p.getDevice().getDeviceId(), p.getCarrier().getCarrierId(), p.getCallingPlan().getCallingPlanId(), p.getDevice().getDeviceName(), p.getDevice().getImage(), p.getCarrier().getCarrierName(), p.getCallingPlan().getPlanName(), p.getDevice().getPrice());
			
			srList.add(sr);
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(srList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getReccomendationProduct")
	@ResponseBody
	public String getReccomendationProduct() {
		
		List<Products> list = productService.productFindReccomendaion();
		
		
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
	@RequestMapping("/app/addApplication")
	@ResponseBody
	public void AddaddApplication(Long memberId, Long productId, Integer activationType, Integer purchaseType, Integer addtionalDiscount, Integer supportFundType, Integer isconnectWiredGoods, Integer monthlyInstallment,  Integer installmentFee, Integer installmentPrincipal, Integer cash, Integer monthlyCallingFee, Integer finalFee, Long installmentId, Long wiredGoodsId, Long cardId) {
		
		Members member = userService.memberSelectById(memberId);
		Products product = productService.productsSelectById(productId);
		Installment installment = productService.installmentSelectById(installmentId);
		WiredGoods wiredGoods = productService.wiredGoodsSelectById(wiredGoodsId);
		Card card = productService.cardSelectById(cardId);
		
		Application application = new Application(null, member, product, activationType, purchaseType, addtionalDiscount, supportFundType, isconnectWiredGoods, null, null, installmentFee, installmentPrincipal, cash, monthlyInstallment, monthlyCallingFee, finalFee, installment, wiredGoods, card);
		productService.applicationInsert(application);
		
	}

	@Override
	@RequestMapping("/app/getApplicationByUserId")
	@ResponseBody
	public String getApplicationByUserId(java.lang.Long userId) {
		
		
		
		List<Application> list = productService.applicationSelectByMemberId(userId);
		
		
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
	@RequestMapping("/app/getApplication")
	@ResponseBody
	public String getApplication(java.lang.Long applicationId) {

		Application application = productService.applicationSelectById(applicationId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(application);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getAllApplication")
	@ResponseBody
	public String getAllApplication() {
		List<Application> list = productService.applicationSelectAll();
		
		
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
	@RequestMapping("/app/getAllInstallment")
	@ResponseBody
	public String getAllInstallment() {
		List<Installment> list = productService.installmentSelectAll();
		
		
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
	@RequestMapping("/app/getInstallment")
	@ResponseBody
	public String getInstallment(java.lang.Long InstallmentId) {
		Installment installment = productService.installmentSelectById(InstallmentId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(installment);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getAllWiredGoods")
	@ResponseBody
	public String getAllWiredGoods() {
		List<WiredGoods> list = productService.wiredGoodsSelectAll();
		
		
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
	@RequestMapping("/app/getWiredGoods")
	@ResponseBody
	public String getWiredGoods(java.lang.Long wiredGoodsId) {
		WiredGoods wiredGoods = productService.wiredGoodsSelectById(wiredGoodsId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(wiredGoods);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getAllCard")
	@ResponseBody
	public String getAllCard() {
		
		List<Card> list = productService.cardSelectActivatedAll();
		
		
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
	@RequestMapping("/app/getCardId")
	@ResponseBody
	public String getCardId(java.lang.Long cardId) {
		Card card = productService.cardSelectById(cardId);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(card);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	@RequestMapping("/app/getCardByCarrierId")
	@ResponseBody
	public String getCardByCarrierId(java.lang.Long carrierId) {
		List<Card> list = productService.cardSelectByCarrierId(carrierId);
		
		
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
	@RequestMapping("/app/registerReview")
	@ResponseBody
	public void registerReview(Integer activationType, String content, Float rate, String reviewImg1, String reviewImg2, String reviewImg3, Long officeId, Long memberId, Long carrierId, Long deviceId) {
		
		
		Members member = userService.memberSelectById(memberId);
		Carrier carrier = productService.carrierSelectById(carrierId);
		Office office = userService.officeSelectById(officeId);
		Device device = productService.deviceSelectById(deviceId);
		
		Review review = new Review(null, member, office, device, carrier, reviewImg1, reviewImg2, reviewImg3, activationType, rate, content, null);
		
		userService.reviewInsert(review);
		
	}

	@Override
	@RequestMapping("/app/getAllReview")
	@ResponseBody
	public String getAllReview() {
		List<Review> list = userService.reviewSelectAll();
		
		
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
	@RequestMapping("/app/getReviewByMemberId")
	@ResponseBody
	public String getReviewByMemberId(java.lang.Long memberId) {
		
		List<Review> list = userService.reviewSelectByMemberId(memberId);
		
		
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
	@RequestMapping("/app/getAllGuestProduct")
	@ResponseBody
	public String getAllGuestProduct() {
		List<GuestProduct> list = productService.guestProductSelectAll();
		
		
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
	@RequestMapping("/app/getGuestProduct")
	@ResponseBody
	public String getGuestProduct(Long id) {
		GuestProduct guestProduct = productService.guestProductSelectById(id);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(guestProduct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	@RequestMapping("/app/getMainBanners")
	@ResponseBody
	public String getMainBanners() {
		
		List<Banners> list = productService.bannersSelectAll();
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	// 예약 현황 조회
	
	@Override
	@RequestMapping("/app/getReservations")
	@ResponseBody
	public String getReservations() {
		
		List<Application> appList = productService.applicationSelectAll();
		
		List<Reservations> list = new ArrayList<Reservations>();
		
		
		for(Application obj : appList ) {
			if(obj!=null) {
				
				
				Reservations res = new Reservations(obj.getRegDate(), obj.getMember().getName(), obj.getProduct().getDevice().getDeviceName(), obj.getState());
				list.add(res);
			} 
			
		}
		
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
	public String memberFiltering() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
	
	

	
	
	
}
