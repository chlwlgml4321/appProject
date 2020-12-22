package com.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobile.domain.CallingPlan;
import com.mobile.domain.Carrier;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Region;
import com.mobile.service.ProductService;
import com.mobile.service.UserService;



@Controller
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
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
	
	
	//regionInsert 들어가기 
	@RequestMapping("/regionInsert")
	public String regionInsert() {
		return "/admin/regionInsert";
	}
	
	
	
	//regionInsert
	@RequestMapping("/regionForm")
	public String regionForm(Region region, Model model) {
		System.out.println("##regionInsert");
		System.out.println(region.getRegionName());
		System.out.println(region.getRegionId());
		
		List<Region> regions= userService.regionSelectAll();
		model.addAttribute("region", regions);
		userService.regionInsert(region);
		
		return "redirect:/region";
	}
	
	
	//지역 전체보기
		@RequestMapping("/region")
		public String region(Model model) {
			
			List<Region> region= userService.regionSelectAll();
			
			model.addAttribute("region", region);
			
			return "/admin/region";
			
		}
		
		//region 글지우기 
		@RequestMapping("/deleteRegion")
		@ResponseBody
		public String deleteRegion(Long id) {
			
			System.out.println("id 진입 "+id );
			Region region = new Region();
			region.setRegionId(id);
			userService.regionDelete(id);
			return "redirect:/region";
		}
		
		//region 디테일
		@RequestMapping("/regionDetail/{regionId}")
		public ModelAndView regionDetail(@PathVariable Long regionId) {
		
			Region region = userService.regionSelectById(regionId);
			System.out.println("regionDetail 진입");
			System.out.println(regionId);
			return new ModelAndView("admin/regionUpdate","region", region);
		}
		
		
		//region 수정하기 
		@RequestMapping("/regionUpdate")
		public String regionUpdate(Region region, Model model) {
			
			System.out.println(region.getRegionName());
			userService.regionUpdate(region);

			List<Region> regions= userService.regionSelectAll();
			
			model.addAttribute("region", regions);
			
			return "/admin/region";
		}
		

		@RequestMapping("/officeRegister")
		public String register(Model model) {
			System.out.println("##officeregister");
			List<Region> region= userService.regionSelectAll();
			model.addAttribute("region",region);
			return "/admin/officeRegister";
			
		}

	
		@RequestMapping("/officeForm")
		public String officeForm(Office office, Model model, Long regionId) {
			System.out.println("##officeInsert");
			System.out.println("id: "+office.getOfficeId());
			System.out.println(office.getAddress());
			System.out.println(office.getOfficeName());
			System.out.println("code: "+ office.getCode());
			System.out.println(office.getTel());
			
			List<Office> offices = userService.officeSelectAll();
			
			model.addAttribute("office", offices);
			
			Region region= userService.regionSelectById(regionId);
			office.setRegion(region);
			userService.officeInsert(office);
			return "redirect:/office";
			
		}
		
		//office selectALL
		@RequestMapping("/office")
		public String office(Model model) {
			
			List<Office> office = userService.officeSelectAll();
			model.addAttribute("office", office);
			
			return "/admin/office";
		}
		
	
		
		//officeState 바꾸기 
		@RequestMapping("/changeOfficeState")
		@ResponseBody
		public String changeOfficeState(Long id) {
			
			Office office= new Office();
			office.setOfficeId(id);
			userService.officeChangeState(id);
			return "";
		}
		
		//office 디테일
		@RequestMapping("/officeDetail/{officeId}")
		public ModelAndView officeDetail(@PathVariable Long officeId) {
				
			Office office = userService.officeSelectById(officeId);
			System.out.println("officeDetail 진입");
			System.out.println(officeId);
			return new ModelAndView("admin/officeUpdate","office", office);
		}
		
		
		//office 수정하기 
		@RequestMapping("/officeUpdate/{officeId}")
		public String officeUpdate(@PathVariable Long officeId, Office office, Model model) {
			System.out.println("##officeUpdate");
			System.out.println(office.getOfficeId());
			System.out.println(office.getAddress());
			System.out.println(office.getOfficeName());
			userService.officeUpdate(office);
			List<Office> offices= userService.officeSelectAll();
					
			model.addAttribute("office", offices);
					
			return "/admin/office";
		}
		
		//callingPlan 
		@RequestMapping("/callingPlan")
			public String callingPlan(Model model) {
				
			List<CallingPlan> callingPlan= productService.callingPlanSelectAll();
			model.addAttribute("callingPlan", callingPlan);
			return "/admin/callingPlan";
		}

		//callingPlanDetail
		@RequestMapping("/callingPlanDetail/{callingPlanId}")
		public ModelAndView callingDetail(@PathVariable Long callingPlanId, Long carrierId, Model model) {
			
			CallingPlan callingPlan= productService.callingPlanSelectById(callingPlanId);
			System.out.println("##callingDetail");
			System.out.println(callingPlanId);
			//Carrier carrier= productService.carrierSelectById(carrierId);
			Carrier carrier= new Carrier();
			model.addAttribute(carrier);
			//callingPlan.setCarrier(carrier);
			return new ModelAndView("/admin/callingPlanUpdate", "callingPlan", callingPlan);
		}
		
		@RequestMapping("/callingPlanRegister")
		public String callRegister(Model model) {
			System.out.println("callRegister 진입");
			List<Carrier> carrier= productService.carrierSelectAll();
			model.addAttribute("carrier",carrier);
			return "/admin/callingPlanRegister";
			
		}

		
		//요금제 등록 
		@RequestMapping("/callingPlanForm")
		public String callingPlanForm(CallingPlan callingPlan, Model model, Long carrierId) {
			
			List<CallingPlan> callingPlans = productService.callingPlanSelectAll();
			
			model.addAttribute("callingPlan", callingPlans);
			
			Carrier carrier= productService.carrierSelectById(carrierId);
			callingPlan.setCarrier(carrier);
			productService.callingPlanInsert(callingPlan);
			
			return "redirect:/callingPlan";
			
		}
		
		//CallingPlanSate 바꾸기 
		@RequestMapping("/changeCallingPlanSate")
		@ResponseBody
		public String changeCallingPlanSate(Long id) {
					
			CallingPlan callingPlan= new CallingPlan();
			callingPlan.setCallingPlanId(id);
			productService.callingPlanChangeState(id);
			return "";
		}
		
		//callingPlanUpdate 수정하기 
		@RequestMapping("/callingPlanUpdate/{callingPlanId}")
		public String callingPlanUpdate(@PathVariable Long callingPlanId, CallingPlan callingPlan, Model model) {
			System.out.println("##callingPlanUpdate");
			productService.callingPlanUpdate(callingPlan);
			List<CallingPlan> callingPlans= productService.callingPlanSelectAll();
			
			model.addAttribute("callingPlan", callingPlans);
							
			return "/admin/callingPlan";
		}
		
}