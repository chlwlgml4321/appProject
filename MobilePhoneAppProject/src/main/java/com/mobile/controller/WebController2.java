package com.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.service.UserService;



@Controller
public class WebController2 {

	@Autowired
	private UserService userService;



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
	public String card() {
		
		
		return "/admin/imageTest";
	}
	

}