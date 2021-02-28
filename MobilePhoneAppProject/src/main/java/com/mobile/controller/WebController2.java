package com.mobile.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.domain.Application;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.PhoneBook;
import com.mobile.domain.Products;
import com.mobile.domain.Region;
import com.mobile.domain.WiredGoods;
import com.mobile.repository.ReviewRepository;
import com.mobile.service.BlackListService;
import com.mobile.service.ProductService;
import com.mobile.service.S3Service;
import com.mobile.service.UserService;



@Controller
public class WebController2 {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private S3Service s3Service;
	
	
	private BlackListService blackListService = BlackListService.getInstance();



	@Autowired
	private ReviewRepository rr;
	//login
	@RequestMapping("/login")
	public void login() {


		System.out.println("로그인");

	}

	//logout
	@RequestMapping("/logout")
	public void logout() {


		System.out.println("로그아웃");

	}

	///accessDenied
	//index
	@RequestMapping("/login/loginPage")
	public String loginPage() {


		return "/login/login";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied() {


		return "/accessDenied";
	}

	//image test
	@RequestMapping("/imageTest")
	public String imageTest() {


		System.out.println(rr.getNextValMySequence());

		return "/admin/imageTest";
	}

	//card
	@RequestMapping("/admin/card")
	public ModelAndView card() {

		List<Card> cards = productService.cardSelectAll();

		return new ModelAndView("/admin/card", "cards", cards);
	}

	//card register
	@RequestMapping("/admin/cardRegister")
	public ModelAndView cardRegister() {

		List<Carrier> carriers = productService.carrierSelectAll();

		return new ModelAndView("/admin/cardRegister", "carriers", carriers);
	}

	//card Insert
	@RequestMapping("/admin/cardForm")
	public String cardForm(Card card, Model model, Long carrierId, MultipartFile file) {

		Carrier carrier = productService.carrierSelectById(carrierId);

		List<Card> cards= productService.cardSelectAll();
		model.addAttribute("cards", cards);
		card.setCarrier(carrier);

		if(file==null) {
			System.out.println("file is null");
		} else {
			System.out.println("file is not null");
		}



		String imgPath = null;

		String cardImg = null;
		String ext = null;

		if(file!=null) {
			String strFileName = file.getOriginalFilename();
			int pos = strFileName.lastIndexOf( "." );
			ext = strFileName.substring( pos + 1 );

			cardImg = "null";
		}

		try {
			if(file!=null) {
				imgPath = s3Service.cardUpload(file);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}


		card.setCardImg(cardImg);
		
		productService.cardInsert(card, ext);

		return "redirect:/admin/card";
	}

	//card 디테일
	@RequestMapping("/admin/cardDetail/{cardId}")
	public String cardDetail(@PathVariable Long cardId, Model model) {

		Card card = productService.cardSelectById(cardId);
		System.out.println(cardId);
		System.out.println("##card update 진입");
		List<Carrier> carriers = productService.carrierSelectAll();
		model.addAttribute("carriers", carriers);
		model.addAttribute("card", card);


		return "/admin/cardUpdate";
	}


	//wiredGoods
	@RequestMapping("/admin/wiredGoods")
	public ModelAndView wiredGoods() {

		List<WiredGoods> wiredGoods = productService.wiredGoodsSelectAll();

		return new ModelAndView("/admin/wiredGoods", "wiredGoods", wiredGoods);
	}

	//card register
	@RequestMapping("/admin/wiredGoodsRegister")
	public ModelAndView wiredGoodsRegister() {

		List<Carrier> carriers = productService.carrierSelectAll();

		return new ModelAndView("/admin/wiredGoodsRegister", "carriers", carriers);
	}

	//wiredGoods Insert
	@RequestMapping("/admin/wiredGoodsForm")
	public String wiredGoodsForm(WiredGoods wiredGoods, Model model, Long carrierId, MultipartFile file) {

		Carrier carrier = productService.carrierSelectById(carrierId);

		List<WiredGoods> wiList= productService.wiredGoodsSelectAll();
		model.addAttribute("wiredGoods", wiList);
		wiredGoods.setCarrier(carrier);
		
		if(file==null) {
			System.out.println("file is null");
		} else {
			System.out.println("file is not null");
		}



		String imgPath = null;

		String wiredGoodsImg = null;
		String ext = null;

		if(file!=null) {
			String strFileName = file.getOriginalFilename();
			int pos = strFileName.lastIndexOf( "." );
			ext = strFileName.substring( pos + 1 );

			wiredGoodsImg = "null";
		}

		try {
			if(file!=null) {
				imgPath = s3Service.wiredGoodsUpload(file);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		wiredGoods.setWiredGoodsImg(wiredGoodsImg);

		
		productService.wiredGoodsInsert(wiredGoods, ext);

		return "redirect:/admin/wiredGoods";
	}

	//card 디테일
	@RequestMapping("/admin/wiredGoodsDetail/{wiredGoodsId}")
	public String wiredGoodsDetail(@PathVariable Long wiredGoodsId, Model model) {

		WiredGoods wiredGoods = productService.wiredGoodsSelectById(wiredGoodsId);

		List<Carrier> carriers = productService.carrierSelectAll();
		model.addAttribute("carriers", carriers);
		model.addAttribute("wiredGoods", wiredGoods);
		System.out.println(wiredGoodsId);
		System.out.println("진입함");
		return "/admin/wiredGoodsUpdate";
	}


	//application
	@RequestMapping("/common/application")
	public ModelAndView application() {

		List<Application> application = productService.applicationSelectAll();

		return new ModelAndView("/admin/application", "application", application);
	}

	//application register
	@RequestMapping("/common/applicationRegister")
	public String applicationRegister(Long productId, Model model) {


		Products products = productService.productsSelectById(productId);
		Long carrierId = products.getCarrier().getCarrierId();

		List<Carrier> carriers = productService.carrierSelectAll();
		List<WiredGoods> wiredGoods = productService.wiredGoodsSelectByCarrierId(carrierId);
		List<Card> cards = productService.cardSelectByCarrierId(carrierId); 

		model.addAttribute("carriers", carriers);
		model.addAttribute("products",products);

		model.addAttribute("cards",cards);
		model.addAttribute("wiredGoods",wiredGoods);


		return "/admin/applicationRegister";
	}

	//application Insert
	@RequestMapping("/common/applicationForm")
	public String applicationForm(Application application, Model model, Long wiredGoodsId, Long cardId,Long productId) {



		List<Application> apList = productService.applicationSelectAll();

		model.addAttribute("application", apList);


		if(productId!=null && productId!=0) {
			Products products = productService.productsSelectById(productId);
			application.setProduct(products);
		}

		if(wiredGoodsId!=null && wiredGoodsId!=0) {
			WiredGoods wiredGoods = productService.wiredGoodsSelectById(wiredGoodsId);
			application.setWiredGoods(wiredGoods);
		}

		if(cardId!=null && cardId!=0) {
			Card card = productService.cardSelectById(cardId);
			application.setCard(card);
		}

		productService.applicationInsert(application);

		return "redirect:/common/application";
	}

	//application 디테일
	@RequestMapping("/common/applicationDetail/{applicationId}")
	public String applicationDetail(@PathVariable Long applicationId, Model model) {

		Application application = productService.applicationSelectById(applicationId);

		model.addAttribute("application", application);

		System.out.println("진입함");
		return "admin/applicationUpdate";
	}



	@RequestMapping("/common/applicationChangeState")
	public String applicationChangeState(Long applicationId, Model model, Integer state) {



		List<Application> apList = productService.applicationSelectAll();

		if(state !=null) {
			Application application = productService.applicationSelectById(applicationId);
			application.setState(state);
			productService.applicationUpdate(application);
		}

		model.addAttribute("application", apList);

		return "admin/application";
	}



	
	@ResponseBody
	@RequestMapping("/app/phonebookTest/{memberId}")
	public String phonebookTest(@PathVariable Long memberId, @RequestBody String phonebooks) {
		System.out.println("진입 ...");

		Members member = new Members(memberId, "테스트 회원", "010223432422",null, null, "AAAAAAA", "1234", 0, 0, null, null);
		System.out.println(phonebooks);
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			PhoneBook[] phoneBooks = objectMapper.readValue(phonebooks, PhoneBook[].class);
			List<PhoneBook> langList = new ArrayList(Arrays.asList(phoneBooks));
			System.out.println(langList.size());
			
			for(PhoneBook pb :langList) {
				String str = blackListService.getByKey(pb.getTel().replaceAll("-", ""));
				if(str!=null) {
					System.out.println(str);
				}
			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "phonebookTest";
	}
	
	@ResponseBody
	@RequestMapping("/app/phonebookTest2")
	public void phonebookTest2(String key) {
		blackListService.printByKey(key);
		
	}
	
	@ResponseBody
	@RequestMapping("/app/phonebookTest3")
	public void phonebookTest3(String key, String value) {
		blackListService.insertblackListMap(key, value);
		
	}
	
	//필터링된 블랙리스트 정보 가져오기
	@ResponseBody
	@RequestMapping("/common/getBlacklistByMemberId")
	public String getBlacklistByMemberId(Long memberId) {
		
		System.out.println("호출");
		
		Members member = userService.memberSelectById(memberId);
		
		if(member.getBlakcList()==null || member.getBlakcList().equals("")) {
			return "통과";
		}
		
		return member.getBlakcList();
	}

	


}