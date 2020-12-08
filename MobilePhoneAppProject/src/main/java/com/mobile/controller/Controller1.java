package com.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	
	//index
	@RequestMapping("/index")
	public String index() {
		
		
		System.out.println("진입하였음");
		
		
		return "/admin/index";
	}

}
