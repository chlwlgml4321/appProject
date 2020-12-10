package com.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	//index
	@RequestMapping("/index")
	public String index() {
		
		
		return "/admin/index";
	}
	
	
	@RequestMapping("/user")
	public String user() {
		
		
		return "/admin/user";
	}

}
