package com.mobile.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mobile.domain.CallingPlan;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.GuestProduct;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Products;
import com.mobile.domain.Region;
import com.mobile.domain.Review;
import com.mobile.repository.ReviewRepository;
import com.mobile.service.ProductService;
import com.mobile.service.S3Service;
import com.mobile.service.UserService;



@Controller
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private S3Service s3Service;
	
	//index
	@RequestMapping("/index")
	public String index() {
		
		
		return "/admin/index";
	}
	
	
	//멤버 전체보기 
	@RequestMapping("/common/user")
	public String user(Model model, Principal principal) {
		List<Members> members = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Office office = (Office) authentication.getPrincipal();
		
		if(office.getState()==2) {
			members = userService.mamberSelectActivatedAll();
		} else {
			members = userService.selectByOffice(office.getOfficeId());
		}
		model.addAttribute("members", members);
		
		return "/admin/user";
	}
	
	
	//승인대기중인 멤버 보기 
	@RequestMapping("/common/inactiveUser")
	public String inactiveUser(Model model) {
		System.out.println("wlsdlq");
		List<Members> members = userService.mamberSelectInactivatedAll();
		model.addAttribute("members",members);
		
		return "/admin/inactiveUser";
	}
			

	
//	@RequestMapping("/memberInsert")
//	public String memberInsert() {
//		
//		Members member= new Members(null, "이하", "01065534732", "강릉", null,"ABCD", "byeluv", 1, 2, null, null);
//		
//		userService.memberInsert(member);
//		return null;
//		
//	}
	
	//멤버 state 바꾸기 
	@RequestMapping("/common/changeUserSate")
	@ResponseBody
	public String changeUserSate(Long id) {
		
		System.out.println("진입, id : " + id);
		
		Members member = new Members();
		member.setMemberId(id);
		
		userService.memberChangeState(id);
		
		
		
		return ""; 
	}
	
	//멤버 active 시키기
	@RequestMapping("/common/changeActive")
	@ResponseBody
	public String changeActive(Long id) {
		Members member = new Members();
		member.setMemberId(id);
		
		userService.memberStateAvtice(id);
		
		return "";
	}
	
	//공지사항 작성 폼으로 가기  
//	@RequestMapping("/admin/noticeRegister")
//	public void noticeForm() {
//		
//		
//		
//	}
	
	//공지사항 insert
	@RequestMapping("/admin/noticeRegister")
	public String registerNotice(Notice notice, Model model) {
		System.out.println("진입");
		System.out.println(notice.getTitle());
		System.out.println(notice.getContents());
		
		List<Notice> notices =userService.noticeSelectAll();
		model.addAttribute("notice", notices);
		
		userService.noticeInsert(notice);
		

		return "redirect:/admin/notice";
	}
	
	
	//수정페이지로 이동 
	@RequestMapping("/admin/noticeInsert")
	public String noticeInsert(Notice notice) {
		System.out.println("##insert");
		
		//userService.noticeInsert(notice);
		
		return "/admin/noticeInsert";
		
	}
	
	//공지사항 전체보기
	@RequestMapping("/admin/notice")
	public String notice(Model model) {
		
		List<Notice> notice= userService.noticeSelectAll();
		
		model.addAttribute("notice", notice);
		
		return "/admin/notice";
		
	}
	
	//공지사항 디테일
	@RequestMapping("/admin/noticeDetail/{noticeId}")
	public ModelAndView noticeDetail(@PathVariable Long noticeId) {
	
		Notice notice = userService.noticeSelectById(noticeId);
		System.out.println("noticeDetail 진입");
		System.out.println(noticeId);
		return new ModelAndView("admin/noticeDetail","notice", notice);
	}
	

	//notice 글지우기 
	@RequestMapping("/admin/deleteNotice")
	@ResponseBody
	public String deleteNotice(Long id) {
		
		System.out.println("id 진입 "+id );
		Notice notice = new Notice();
		notice.setNoticeId(id);
		userService.noticeDelete(id);
		return "redirect:/admin/notice";
	}
	
	
	//notice 수정하기 
	@RequestMapping("/admin/noticeUpdate")
	public String noticeUpdate( Notice notice) {
		
		System.out.println("title: "+ notice.getTitle());

		System.out.println("id: "+notice.getNoticeId());
		System.out.println("id: "+notice.getContents());
		userService.noticeUpdate(notice);
		
		return "/admin/noticeInsert";
	}
	
	
	//regionInsert 들어가기 
	@RequestMapping("/admin/regionInsert")
	public String regionInsert() {
		return "/admin/regionInsert";
	}
	
	
	
	//regionInsert
	@RequestMapping("/admin/regionForm")
	public String regionForm(Region region, Model model) {
		System.out.println("##regionInsert");
		System.out.println(region.getRegionName());
		System.out.println(region.getRegionId());
		
		List<Region> regions= userService.regionSelectAll();
		model.addAttribute("region", regions);
		userService.regionInsert(region);
		
		return "redirect:/admin/region";
	}
	
	
	//지역 전체보기
		@RequestMapping("/admin/region")
		public String region(Model model) {
			
			List<Region> region= userService.regionSelectAll();
			
			model.addAttribute("region", region);
			
			return "/admin/region";
			
		}
		
		//region 글지우기 
		@RequestMapping("/admin/deleteRegion")
		@ResponseBody
		public String deleteRegion(Long id) {
			
			System.out.println("id 진입 "+id );
			Region region = new Region();
			region.setRegionId(id);
			userService.regionDelete(id);
			return "redirect:/admin/region";
		}
		
		//region 디테일
		@RequestMapping("/admin/regionDetail/{regionId}")
		public ModelAndView regionDetail(@PathVariable Long regionId) {
		
			Region region = userService.regionSelectById(regionId);
			System.out.println("regionDetail 진입");
			System.out.println(regionId);
			return new ModelAndView("admin/regionUpdate","region", region);
		}
		
		
		//region 수정하기 
		@RequestMapping("/admin/regionUpdate")
		public String regionUpdate(Region region, Model model) {
			
			System.out.println(region.getRegionName());
			userService.regionUpdate(region);

			List<Region> regions= userService.regionSelectAll();
			
			model.addAttribute("region", regions);
			
			return "/admin/region";
		}
		

		@RequestMapping("/admin/officeRegister")
		public String register(Model model) {
			System.out.println("##officeregister");
			List<Region> region= userService.regionSelectAll();
			model.addAttribute("region",region);
			return "/admin/officeRegister";
			
		}

		@RequestMapping("/admin/officeForm")
		public String officeForm(Office office, Model model, Long regionId) {
			System.out.println("##officeInsert");
			System.out.println("id: "+office.getOfficeId());
			System.out.println(office.getAddress());
			System.out.println(office.getOfficeName());
			System.out.println("code: "+ office.getCode());
			System.out.println(office.getTel());
			
			List<Office> offices = userService.officeSelectAll();
			System.out.println(office.getPassword());
			model.addAttribute("office", offices);
			Region region= userService.regionSelectById(regionId);
			office.setRegion(region);
			userService.officeInsert(office);
			return "redirect:/admin/office";
			
		}
		
		//office selectALL
		@RequestMapping("/admin/office")
		public String office(Model model) {
			
			List<Office> office = userService.officeSelectAll();
			model.addAttribute("office", office);
			
			return "/admin/office";
		}
		
	
		
		//officeState 바꾸기 
		@RequestMapping("/admin/changeOfficeState")
		@ResponseBody
		public String changeOfficeState(Long id) {
			
			Office office= new Office();
			office.setOfficeId(id);
			userService.officeChangeState(id);
			return "";
		}
		
		//office 디테일
		@RequestMapping("/admin/officeDetail/{officeId}")
		public ModelAndView officeDetail(@PathVariable Long officeId, Model model) {
				
			Office office = userService.officeSelectById(officeId);
			System.out.println("officeDetail 진입");
			System.out.println(officeId);
			
			List<Region> regions= userService.regionSelectAll();
			
			
			model.addAttribute("regions", regions);
			
			return new ModelAndView("admin/officeUpdate","office", office);
		}
		
		
		//office 수정하기 
		@RequestMapping("/admin/officeUpdate/{officeId}")
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
		@RequestMapping("/admin/callingPlan")
			public String callingPlan(Model model) {
				
			List<CallingPlan> callingPlan= productService.callingPlanSelectAll();
			model.addAttribute("callingPlan", callingPlan);
			return "/admin/callingPlan";
		}

		//callingPlanDetail
		@RequestMapping("/admin/callingPlanDetail/{callingPlanId}")
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
		
		@RequestMapping("/admin/callingPlanRegister")
		public String callRegister(Model model) {
			System.out.println("callRegister 진입");
			List<Carrier> carrier= productService.carrierSelectAll();
			model.addAttribute("carrier",carrier);
			return "/admin/callingPlanRegister";
			
		}

		
		//요금제 등록 
		@RequestMapping("/admin/callingPlanForm")
		public String callingPlanForm(CallingPlan callingPlan, Model model, Long carrierId) {
			
			List<CallingPlan> callingPlans = productService.callingPlanSelectAll();
			
			model.addAttribute("callingPlan", callingPlans);
			
			Carrier carrier= productService.carrierSelectById(carrierId);
			callingPlan.setCarrier(carrier);
			productService.callingPlanInsert(callingPlan);
			
			return "redirect:/admin/callingPlan";
			
		}
		
		//CallingPlanSate 바꾸기 
		@RequestMapping("/admin/changeCallingPlanSate")
		@ResponseBody
		public String changeCallingPlanSate(Long id) {
					
			CallingPlan callingPlan= new CallingPlan();
			callingPlan.setCallingPlanId(id);
			productService.callingPlanChangeState(id);
			return "";
		}
		
		//callingPlanUpdate 수정하기 
		@RequestMapping("/admin/callingPlanUpdate/{callingPlanId}")
		public String callingPlanUpdate(@PathVariable Long callingPlanId, CallingPlan callingPlan, Model model) {
			System.out.println("##callingPlanUpdate");
			productService.callingPlanUpdate(callingPlan);
			List<CallingPlan> callingPlans= productService.callingPlanSelectAll();
			
			model.addAttribute("callingPlan", callingPlans);
							
			return "/admin/callingPlan";
		}
		
		
		@RequestMapping("/admin/device")
		public String device(Model model) {
			
			List<Device> device = productService.deviceSelectAll();
			model.addAttribute("device", device);
			return "/admin/device";
		}
		
		//deviceRegister 진입
		@RequestMapping("/admin/deviceRegister")
		public String deviceRegister(Model model) {
			System.out.println("deviceRegister 진입");
			
			return "/admin/deviceRegister";
			
		}

		
		//device 등록 
		@Transactional
		@RequestMapping("/admin/deviceForm")
		public String deviceForm(Device device, MultipartFile file , Model model) {
			
			System.out.println(device.getDeviceName());
			System.out.println(device.getImage());
			
			if(file==null) {
				System.out.println("file is null");
			} else {
				System.out.println("file is not null");
			}
			
			
			
			String imgPath = null;

			String deviceImg = null;
			String ext = null;

			if(file!=null) {
				String strFileName = file.getOriginalFilename();
				int pos = strFileName.lastIndexOf( "." );
				ext = strFileName.substring( pos + 1 );

				deviceImg = "null";
			}
			
			try {
				if(file!=null) {
					imgPath = s3Service.deviceUpload(file);
				}

			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
			device.setImage(deviceImg);
			
			productService.deviceInsert(device, ext);
			
			List<Device> devices = productService.deviceSelectAll();
			
			model.addAttribute("device", devices);
			
			return "redirect:/admin/device";
			
		}
		
		//deviceDetail
		@RequestMapping("/admin/deviceDetail/{deviceId}")
		public ModelAndView deviceDetail(@PathVariable Long deviceId,MultipartFile file, Model model) {
					
			Device device= productService.deviceSelectById(deviceId);
			System.out.println("##deviceDetail");
			System.out.println(deviceId);
			
			return new ModelAndView("/admin/deviceUpdate", "device", device);
		}
				
		
		
		//DeviceState 바꾸기 
		@RequestMapping("/admin/changeDeviceState")
		@ResponseBody
		public String changeDeviceSate(Long id) {
							
			Device device= new Device();
			device.setDeviceId(id);
			productService.deviceChangeState(id);
			return "";
		}
		
		@RequestMapping("/common/products")
		public String product(Model model) {
			
			List<Products> products = productService.productsSelectAll();
			model.addAttribute("products", products);
			return "/admin/products";
		}
		
		
		//productRegister 진입
		@RequestMapping("/common/productRegister")
		public String productRegister(Model model) {
			System.out.println("productRegister 진입");
			
			List<Carrier> carrier= productService.carrierSelectAll();
			model.addAttribute("carrier",carrier);	
			
			List<CallingPlan> callingPlan = productService.callingPlanSelectAll();
			model.addAttribute("callingPlan", callingPlan);
			
			List<Device> device = productService.deviceSelectAll();
			model.addAttribute("device", device);
			
			List<Office> office = userService.officeSelectAll();
			model.addAttribute("office", office);
			
			return "/admin/productRegister";
					
		}

		//product 등록 
		@RequestMapping("/common/productForm")
		public String productForm(Products products, Model model, Long carrierId, Long callingPlanId, Long officeId, Long deviceId) {
			List<Products> product = productService.productsSelectAll();
			
			model.addAttribute("products", products);
			
			Carrier carrier= productService.carrierSelectById(carrierId);
			products.setCarrier(carrier);
			
			CallingPlan callingPlan=productService.callingPlanSelectById(callingPlanId);
			products.setCallingPlan(callingPlan);
			
			Office office = userService.officeSelectById(officeId);
			products.setOffice(office);
			
			Device device= productService.deviceSelectById(deviceId);
			products.setDevice(device);
			
			productService.productInsert(products);
			
			return "redirect:/common/products";	
		}	
		
		
		//productDetail
		@RequestMapping("/common/productDetail/{productsId}")
		public ModelAndView productDetail(@PathVariable Long productsId, Model model) {
			// 상품아이디로 상품을 조회해서 디테일에 뿌려주는 기능임 	
			
			Products products= productService.productsSelectById(productsId);
			System.out.println("##productDetail");
			
			
			List<CallingPlan> callingPlans= productService.callingPlanSelectAll();
			List<Office> offices= userService.officeSelectAll();
			List<Device> devices= productService.deviceSelectAll();
			
			
			model.addAttribute("callingPlans", callingPlans);
			model.addAttribute("offices", offices);
			model.addAttribute("devices", devices);
			
			return new ModelAndView("/admin/productUpdate", "products", products);
		}
		
		//product 수정하기 
		@RequestMapping("/common/productUpdate/{productsId}")
		public String productUpdate(@PathVariable Long productsId,  Products products, Model model) {
			
			// 수정해서 - 새로운 디비를update 치고  -> 새로운 데이터를 이용해서 화면으로 보여주는 로직  
			System.out.println("##productUpdate");
			productService.productUpdate(products);
			List<Products> product = productService.productsSelectAll();
			
			model.addAttribute("products", products);	
			
			return "/admin/products";
		}
			
		//ProductSate 바꾸기 
		@RequestMapping("/common/changeProductSate")
		@ResponseBody
		public String changeProductSate(Long id) {
									
			Products products=new Products();
			products.setProductsId(id);
			System.out.println("비활성화");
			productService.productChangeState(id);
			return "";
		}
		
		
		//memberId에 해당하는 point목록으로 가기 
		@RequestMapping("/admin/point/{memberId}")
		public String point(@PathVariable Long memberId, Point point, Model model) {
			
			List<Point> points= userService.pointSelectByMemberId(memberId);
			Members member= userService.memberSelectById(memberId);
			System.out.println("이름: "+member.getName());
			
			System.out.println("//memberId에 해당하는 point목록으로 가기 ");
			model.addAttribute("members", member);
			model.addAttribute("points", points);
			return "/admin/point";
		}
		
		@RequestMapping("/admin/review")
		public String review(Model model) {
			
			List<Review> review = userService.reviewSelectAll();
			model.addAttribute("review", review);
			return "/admin/review";
		}
	
		//review delete
		@RequestMapping("/admin/changeDelete")
		@ResponseBody
		public String changeDelete(Long id) {
			
			userService.reviewDelete(id);
			return "";
		}
		
		
		//review 디테일
		@RequestMapping("/admin/reviewDetail/{reviewId}")
		public ModelAndView reviewDetail(@PathVariable Long reviewId) {
		
			Review review= userService.reviewSelectById(reviewId);
			System.out.println("##reviewDetail");
			
			return new ModelAndView("admin/reviewDetail","review", review);
		}
		
		//guestProduct 
		@RequestMapping("/admin/guestProduct")
		public String guestProduct(Model model) {
			
			List<GuestProduct> guestProduct= productService.guestProductSelectAll();
			model.addAttribute("guestProduct", guestProduct);
			return "/admin/guestProduct";
		}
		
		
		//guestProductDetail  수정할때 화면 
		@RequestMapping("/admin/guestProductDetail/{guestProductId}")
		public ModelAndView guestProductDetail(@PathVariable Long guestProductId, Model model) {
			
			// 상품아이디로 상품을 조회해서 디테일에 뿌려주는 기능임 	
			GuestProduct guestProducts= productService.guestProductSelectById(guestProductId);
			System.out.println("##guestProductsDetail");
			System.out.println(guestProducts);
			
			List<CallingPlan> callingPlans= productService.callingPlanSelectAll();
			List<Office> offices= userService.officeSelectAll();
			List<Device> devices= productService.deviceSelectAll();
			
			
			model.addAttribute("callingPlans", callingPlans);
			model.addAttribute("offices", offices);
			model.addAttribute("devices", devices);
			
			return new ModelAndView("/admin/guestProductUpdate", "guestProducts", guestProducts);
		}
		
		//guestProductUpdate수정하기 
		@RequestMapping("/admin/guestProductUpdate/{guestProductId}")
		public String guestProductUpdate(@PathVariable Long guestProductId,  GuestProduct guestProducts, Model model) {
			
			// 수정해서 - 새로운 디비를update 치고  -> 새로운 데이터를 이용해서 화면으로 보여주는 로직  
			System.out.println("##guestProductUpdate");
			productService.guestProductUpdate(guestProducts);
			
			List<GuestProduct> guestProduct = productService.guestProductSelectAll();
			
			model.addAttribute("guestProducts", guestProducts);	
			
			return "/admin/guestProduct";
		}
		
		

		//guestProductRegister 진입
		@RequestMapping("/admin/guestProductRegister")
		public String guestProductRegister(Model model) {
			System.out.println("guestProductRegister 진입");
			
			List<Carrier> carrier= productService.carrierSelectAll();
			model.addAttribute("carrier",carrier);	
			
			List<CallingPlan> callingPlan = productService.callingPlanSelectAll();
			model.addAttribute("callingPlan", callingPlan);
			
			List<Device> device = productService.deviceSelectAll();
			model.addAttribute("device", device);
			
			List<Office> office = userService.officeSelectAll();
			model.addAttribute("office", office);
			
			return "/admin/guestProductRegister";
					
		}

		//GuestProduct 등록 
		@RequestMapping("/admin/guestProductForm")
		public String guestProductForm(GuestProduct guestProduct, Model model, Long carrierId, Long callingPlanId, Long officeId, Long deviceId) {
			List<GuestProduct> guestProducts= productService.guestProductSelectAll();
			
			model.addAttribute("guestProducts", guestProducts);
			
			Carrier carrier= productService.carrierSelectById(carrierId);
			guestProduct.setCarrier(carrier);
			
			CallingPlan callingPlan=productService.callingPlanSelectById(callingPlanId);
			guestProduct.setCallingPlan(callingPlan);
			
			Office office = userService.officeSelectById(officeId);
			guestProduct.setOffice(office);
			
			Device device= productService.deviceSelectById(deviceId);
			guestProduct.setDevice(device);
			
			productService.guestProductInsert(guestProduct);
			
			return "redirect:/admin/guestProduct";	
		}	

		//guestProduct 지우기 
		@RequestMapping("/admin/deleteGusetProduct")
		@ResponseBody
		public String deleteGusetProduct(Long id) {
			
			System.out.println("id 진입 "+id );
			GuestProduct guestProduct = new GuestProduct();
			guestProduct.setGuestProductId(id);
			productService.guestProductDelete(id);
			
			return "redirect:/admin/guestProduct";
		}
		
		

		//officeId에 해당하는 멤버 전체보기 
		@RequestMapping("/officeUser")
		public String officeUser(Model model, Long officeId) {
			List<Members> members = userService.selectByOffice(1L);
			
			model.addAttribute("members", members);
			
			return "/admin/officeUser";
		}
		

		//officeId에 해당하는 product 보기 
		@RequestMapping("/officeProducts")
		public String officeProduct(Model model) {
			
			List<Products> products = productService.productSelectOfficeId(1L);
			model.addAttribute("products", products);
			return "/admin/officeProducts";
		}
		
		@RequestMapping("/officeReview")
		public String officeReview(Model model) {
			
			List<Review> review = userService.reviewSelectByOfficeId(1L);
			model.addAttribute("review", review);
			return "/admin/officeReview";
		}
		
		
	
}