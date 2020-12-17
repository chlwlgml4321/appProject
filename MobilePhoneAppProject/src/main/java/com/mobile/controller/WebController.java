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
public class WebController {
	
	@Autowired
	private UserService userService;
	
	
	
	//index
	@RequestMapping("/index")
	public String index() {
		
		
		return "/admin/index";
	}
	
	
	//멤버 전체보기 
	@RequestMapping("/user")
	public String user(Model model) {
		List<Members> members = userService.mamberSelectActivatedAll();
		
		model.addAttribute("members", members);
		
		return "/admin/user";
	}
	
	
	//승인대기중인 멤버 보기 
	@RequestMapping("/inactiveUser")
	public String inactiveUser(Model model) {
		System.out.println("wlsdlq");
		List<Members> members = userService.mamberSelectInactivatedAll();
		model.addAttribute("members",members);
		
		return "/admin/inactiveUser";
	}
			

	
	@RequestMapping("/memberInsert")
	public String memberInsert() {
		
		Members member= new Members(null, "이하", "01065534732", "강릉", null,"ABCD", "byeluv", 1, 2, null, null);
		
		userService.memberInsert(member);
		return null;
		
	}
	
	//멤버 state 바꾸기 
	@RequestMapping("/changeUserSate")
	@ResponseBody
	public String changeUserSate(Long id) {
		
		System.out.println("진입, id : " + id);
		
		Members member = new Members();
		member.setMemberId(id);
		
		userService.memberChangeState(id);
		
		
		
		return ""; 
	}
	
	//멤버 active 시키기
	@RequestMapping("/changeActive")
	@ResponseBody
	public String changeActive(Long id) {
		Members member = new Members();
		member.setMemberId(id);
		
		userService.memberStateAvtice(id);
		
		return "";
	}
	
	//공지사항 작성 폼으로 가기  
	@RequestMapping("/admin/noticeRegister")
	public void noticeForm() {
		
		
		
	}
	
	//공지사항 insert
	@RequestMapping("/noticeRegister")
	public String registerNotice(Notice notice, Model model) {
		System.out.println("진입");
		System.out.println(notice.getTitle());
		System.out.println(notice.getContents());
		
		List<Notice> notices =userService.noticeSelectAll();
		model.addAttribute("notice", notices);
		
		userService.noticeInsert(notice);
		

		return "redirect:/notice";
	}
	
	
	//수정페이지로 이동 
	@RequestMapping("/noticeInsert")
	public String noticeInsert(Notice notice) {
		System.out.println("##insert");
		
		//userService.noticeInsert(notice);
		
		return "/admin/noticeInsert";
		
	}
	
	//공지사항 전체보기
	@RequestMapping("/notice")
	public String notice(Model model) {
		
		List<Notice> notice= userService.noticeSelectAll();
		
		model.addAttribute("notice", notice);
		
		return "/admin/notice";
		
	}
	
	//공지사항 디테일
	@RequestMapping("/noticeDetail/{noticeId}")
	public ModelAndView noticeDetail(@PathVariable Long noticeId) {
	
		Notice notice = userService.noticeSelectById(noticeId);
		System.out.println("noticeDetail 진입");
		System.out.println(noticeId);
		return new ModelAndView("admin/noticeDetail","notice", notice);
	}
	

	//notice 글지우기 
	@RequestMapping("/deleteNotice")
	@ResponseBody
	public String deleteNotice(Long id) {
		
		System.out.println("id 진입 "+id );
		Notice notice = new Notice();
		notice.setNoticeId(id);
		userService.noticeDelete(id);
		return "redirect:/notice";
	}
	
	
	//notice 수정하기 
	@RequestMapping("/noticeUpdate")
	public String noticeUpdate( Notice notice) {
		
		System.out.println("title: "+ notice.getTitle());

		System.out.println("id: "+notice.getNoticeId());
		System.out.println("id: "+notice.getContents());
		userService.noticeUpdate(notice);
		
		return "/admin/noticeInsert";
	}
	
	
}