package com.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobile.domain.Application;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Products;
import com.mobile.domain.Region;
import com.mobile.domain.WiredGoods;
import com.mobile.service.ProductService;
import com.mobile.service.UserService;



@Controller
public class WebController2 {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;



	//index
	@RequestMapping("/loginPage")
	public String loginPage() {


		return "/admin/login";
	}

	//image test
	@RequestMapping("/imageTest")
	public String imageTest() {


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
	public String cardForm(Card card, Model model, Long carrierId) {
		System.out.println("##regionInsert");

		Carrier carrier = productService.carrierSelectById(carrierId);

		List<Card> cards= productService.cardSelectAll();
		model.addAttribute("cards", cards);
		card.setCarrier(carrier);
		productService.cardInsert(card);

		return "redirect:/admin/card";
	}

	//card 디테일
	@RequestMapping("/cardDetail/{cardId}")
	public String cardDetail(@PathVariable Long cardId, Model model) {

		Card card = productService.cardSelectById(cardId);
		System.out.println(cardId);
		System.out.println("##card update 진입");
		List<Carrier> carriers = productService.carrierSelectAll();
		model.addAttribute("carriers", carriers);
		model.addAttribute("card", card);
		
		
		return "admin/cardUpdate";
	}
	
	
	//wiredGoods
	@RequestMapping("/wiredGoods")
	public ModelAndView wiredGoods() {

		List<WiredGoods> wiredGoods = productService.wiredGoodsSelectAll();
	
		return new ModelAndView("/admin/wiredGoods", "wiredGoods", wiredGoods);
	}
	
	//card register
	@RequestMapping("/wiredGoodsRegister")
	public ModelAndView wiredGoodsRegister() {

		List<Carrier> carriers = productService.carrierSelectAll();

		return new ModelAndView("/admin/wiredGoodsRegister", "carriers", carriers);
	}
	
	//wiredGoods Insert
	@RequestMapping("/wiredGoodsForm")
	public String wiredGoodsForm(WiredGoods wiredGoods, Model model, Long carrierId) {
	
		Carrier carrier = productService.carrierSelectById(carrierId);

		List<WiredGoods> wiList= productService.wiredGoodsSelectAll();
		model.addAttribute("wiredGoods", wiredGoods);
		wiredGoods.setCarrier(carrier);
		productService.wiredGoodsInsert(wiredGoods);

		return "redirect:/wiredGoods";
	}
	
	//card 디테일
	@RequestMapping("/wiredGoodsDetail/{wiredGoodsId}")
	public String wiredGoodsDetail(@PathVariable Long wiredGoodsId, Model model) {

		WiredGoods wiredGoods = productService.wiredGoodsSelectById(wiredGoodsId);
		
		List<Carrier> carriers = productService.carrierSelectAll();
		model.addAttribute("carriers", carriers);
		model.addAttribute("wiredGoods", wiredGoods);
		System.out.println(wiredGoodsId);
		System.out.println("진입함");
		return "admin/wiredGoodsUpdate";
	}
	
	
	//application
	@RequestMapping("/application")
	public ModelAndView application() {

		List<Application> application = productService.applicationSelectAll();
	
		return new ModelAndView("/admin/application", "application", application);
	}
	
	//application register
	@RequestMapping("/applicationRegister")
	public String applicationRegister(Long productId, Model model) {

	
		Products products = productService.productsSelectById(productId);
		
		List<Carrier> carriers = productService.carrierSelectAll();
		
		
		model.addAttribute("carriers", carriers);
		model.addAttribute("products",products);
		
		return "/admin/applicationRegister";
	}
	
	//application Insert
	@RequestMapping("/applicationForm")
	public String applicationForm(WiredGoods wiredGoods, Model model, Long carrierId) {
	
		Carrier carrier = productService.carrierSelectById(carrierId);

		List<WiredGoods> wiList= productService.wiredGoodsSelectAll();
		model.addAttribute("wiredGoods", wiredGoods);
		wiredGoods.setCarrier(carrier);
		productService.wiredGoodsInsert(wiredGoods);

		return "redirect:/application";
	}
	
	//application 디테일
	@RequestMapping("/applicationDetail/{applicationId}")
	public String applicationDetail(@PathVariable Long applicationId, Model model) {
		
		Application application = productService.applicationSelectById(applicationId);
		
		model.addAttribute("application", application);
		
		System.out.println("진입함");
		return "admin/applicationUpdate";
	}
	
	
	
	
	
	


}