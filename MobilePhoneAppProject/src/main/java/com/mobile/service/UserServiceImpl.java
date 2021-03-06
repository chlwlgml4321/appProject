package com.mobile.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import com.mobile.domain.Authority;
import com.mobile.domain.Blacklist;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.OfficeBoard;
import com.mobile.domain.Point;
import com.mobile.domain.PointSaveLog;
import com.mobile.domain.PointUseLog;
import com.mobile.domain.Region;
import com.mobile.domain.Replies;
import com.mobile.domain.Review;
import com.mobile.repository.AuthorityRepository;
import com.mobile.repository.BlacklistRepository;
import com.mobile.repository.MembersRepository;
import com.mobile.repository.NoticeRepository;
import com.mobile.repository.OfficeBoardRepository;
import com.mobile.repository.OfficeRepository;
import com.mobile.repository.PointRepository;
import com.mobile.repository.PointSaveLogRepository;
import com.mobile.repository.PointUseLogRepository;
import com.mobile.repository.RegionRepository;
import com.mobile.repository.RepliesRepository;
import com.mobile.repository.ReviewRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	MembersRepository membersRepo;
	@Autowired
	BlacklistRepository blackListRepo;
	@Autowired
	NoticeRepository noticeRepo;
	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	RegionRepository regionRepo;
	@Autowired
	OfficeRepository officeRepo;
	@Autowired
	PointRepository pointRepo;
	
	@Autowired
	OfficeBoardRepository officeBoardRepo;
	
	@Autowired
	RepliesRepository repliesRepo;
	
	@Autowired
	AuthorityRepository authorityRepo;
	
	@Autowired
	PointSaveLogRepository pointSaveLogRepo;
	
	@Autowired
	PointUseLogRepository pointUseLogRepo;

	@Override
	public List<Members> memberSelectAll() {
		return membersRepo.findAll();
	}
	
	@Override
	public List<Members> mamberSelectActivatedAll() {
		return membersRepo.findActiveMember();
	}

	@Override
	public List<Members> mamberSelectInactivatedAll() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Office office = (Office) authentication.getPrincipal();

		if(office.getState()==2) {
			return membersRepo.findInactiveMember();
		} else {
			return membersRepo.findInActiveMemberByOfficeId(office.getOfficeId());
		}
		
	}

	@Override
	public Members memberSelectById(Long memberId) {

		return membersRepo.findById(memberId).orElse(null);
	}

	@Override
	public int memberInsert(Members member) {


		Members m = membersRepo.findByPhone(member.getPhone());

		if(m==null) {
			membersRepo.save(member);
			return 1;
		} else {
			System.out.println("phone number 중복");
			return 0;
		}



	}
	@Override 
	public Members memberLogin(String phone, String password) {


		//		Members m = membersRepo.findByPhoneAndPwd(phone, password);
		//		if(m==null) {
		//			return 3;
		//		} else {
		//			if(m.getState()==1) {
		//				return 1;
		//			} else {
		//				return 2;
		//			}
		//		}

		return membersRepo.findByPhoneAndPwd(phone, password);

	}


	@Override
	public void memberUpdate(Members member) {

		Members m = membersRepo.findById(member.getMemberId()).orElse(null);

		if(m!=null) {
			if(member.getIsVisitor() != null) {
				m.setIsVisitor(member.getIsVisitor());
			}

			if(member.getMemberCode()!=null) {
				m.setMemberCode(member.getMemberCode());
			}

			if(member.getName()!=null) {
				m.setName(member.getName());
			}

			if(member.getOffice()!=null) {
				m.setOffice(member.getOffice());
			}

			if(member.getPassword()!=null) {
				m.setPassword(member.getPassword());
			}

			if(member.getProfileImg()!=null) {
				m.setProfileImg(member.getProfileImg());
			}

			if(member.getRegions()!=null) {
				m.setRegions(member.getRegions());
			}

			if(member.getIsAgreement()!=null){
				m.setIsAgreement(member.getIsAgreement());
			}
			
			membersRepo.save(m);
		}


	}

	@Override
	public List<Members> mamberSelectInactivatedByOfficeId(Long officeId){
		
		return membersRepo.findInActiveMemberByOfficeId(officeId);
	}
	
	@Override
	public void memberChangeState(Long memberId) {
		Members member = membersRepo.findById(memberId).orElse(null);
		int state;

		if(member !=null) {
			state = member.getState();

			if(state == 0) {
				member.setState(1);
			} else {
				member.setState(0);
			}
			membersRepo.save(member);
		}
	}

	@Override
	public void memberStateAvtice(Long memberId) {
		Members member = membersRepo.findById(memberId).orElse(null);
		int state;

		if(member !=null) {
			state= member.getState();

			if(state==2) {
				member.setState(1);
			}
			membersRepo.save(member);
		}

	}

	@Override
	public List<Members> selectByOffice(Long officeId) {

		return membersRepo.findByOffice(officeId);
	}

	@Override
	public List<Blacklist> blacklistSelectAll() {

		return blackListRepo.findAll();
	}

	@Override
	public Blacklist blacklistSelectById(Long blacklistId) {

		return blackListRepo.findById(blacklistId).orElse(null);
	}

	@Override
	public void blacklistInsert(Blacklist blacklist) {

		blackListRepo.save(blacklist);

	}

	@Override
	public void blacklistUpdate(Blacklist blacklist) {
		Blacklist black= blackListRepo.findById(blacklist.getBlacklistId()).orElse(null);

		if(black !=null) {
			if(blacklist.getTel()!=null) {
				black.setTel(blacklist.getTel());
			}
			blackListRepo.save(black);
		}

	}

	@Override
	public void blacklistDelete(Long blacklistId) {

		blackListRepo.deleteById(blacklistId);

	}

	@Override
	public List<Notice> noticeSelectAll() {

		return noticeRepo.findAll();
	}

	@Override
	public Notice noticeSelectById(Long noticeId) {

		return noticeRepo.findById(noticeId).orElse(null);
	}

	@Override
	public void noticeInsert(Notice notice) {

		noticeRepo.save(notice);

	}

	@Override
	public void noticeUpdate(Notice notice) {

		Notice n= noticeRepo.findById(notice.getNoticeId()).orElse(null);

		if(n !=null) {
			if(notice.getTitle() != null) {
				n.setTitle(notice.getTitle());
			}
			if(notice.getContents() != null) {
				n.setContents(notice.getContents());
			}
			if(notice.getRegDate() !=null) {
				n.setRegDate(notice.getRegDate());
			}
			noticeRepo.save(n);
		}


	}

	@Override
	public void noticeDelete(Long noticeId) {

		noticeRepo.deleteById(noticeId);
	}

	@Override
	public List<Review> reviewSelectAll() {

		return reviewRepo.findAll();
	}

	@Override
	public Review reviewSelectById(Long reviewId) {

		return reviewRepo.findById(reviewId).orElse(null) ;
	}

	@Override
	public List<Review> reviewSelectByMemberId(Long memberId) {

		return reviewRepo.findByMemberId(memberId);
	}

	@Override
	public Integer reviewInsert(Review review) {

		if(review.getReviewImg1()!= null) {


			if(!review.getReviewImg1().equals("null")) {
				review.setReviewImg1(null);
			} else {

				int seq = reviewRepo.getNextValMySequence();
				String fileName = "review_image_"+ seq;

				String url = "https://phonestorimage.s3.ap-northeast-2.amazonaws.com/" +  fileName + "."+ review.getReviewImg2();


				review.setReviewImg1(url);
				review.setReviewImg2(null);
			}
		} else {
			review.setReviewImg2(null);
		}
		
		Review rv = reviewRepo.save(review);
		
		if(rv!=null) {
			return 1;
		} else {
			return 0;
		}
		 

	}

	@Override
	public Integer reviewUpdate(Review review) {

		
		if(review.getReviewImg1()!= null) {


			if(!review.getReviewImg1().equals("null")) {
				review.setReviewImg1(null);
			} else {

				
				String fileName = "review_image_"+ review.getReviewId();

				String url = "https://phonestorimage.s3.ap-northeast-2.amazonaws.com/" +  fileName + "."+ review.getReviewImg2();


				review.setReviewImg1(url);
				review.setReviewImg2(null);
			}
		} else {
			review.setReviewImg2(null);
		}
		
		try {
			
		
		Review r= reviewRepo.findById(review.getReviewId()).orElse(null);

		if(r !=null) {
			
			if(review.getReviewImg1()!=null) {
				r.setReviewImg1(review.getReviewImg1());
			}
			
			if(review.getCarrier()!=null) {
				r.setCarrier(review.getCarrier());
			}
			if(review.getOffice()!=null) {
				r.setOffice(review.getOffice());
			}
			if(review.getDevice()!=null) {
				r.setDevice(review.getDevice());
			}
			
			if(review.getReviewImg2() !=null) {
				r.setReviewImg2(review.getReviewImg2());
			}
			if(review.getReviewImg3() !=null) {
				r.setReviewImg3(review.getReviewImg3());
			}
			if(review.getActivationType() !=null) {
				r.setActivationType(review.getActivationType());
			}
			if(review.getRate() !=null) {
				r.setRate(review.getRate());
			}
			if(review.getContent() !=null) {
				r.setContent(review.getContent());
			}
			if(review.getRegDate() !=null) {
				r.setRegDate(review.getRegDate());
			}
			
			r.setUpdateCnt(r.getUpdateCnt()+1);
			reviewRepo.save(r);
		}
		
		} catch(Exception e) {
			return 0;
		}
		
		return 1;



	}

	@Override
	public void reviewDelete(Long reviewId) {

		reviewRepo.deleteById(reviewId);

	}

	@Override
	public List<Review> reviewSelectByOfficeId(Long officeId) {

		return reviewRepo.findByOffice(officeId);
	}

	@Override
	public List<Region> regionSelectAll() {

		return regionRepo.findAll();
	}

	@Override
	public Region regionSelectById(Long regionId) {

		return regionRepo.findById(regionId).orElse(null);
	}

	@Override
	public void regionInsert(Region region) {

		regionRepo.save(region);

	}

	@Override
	public void regionUpdate(Region region) {

		Region r= regionRepo.findById(region.getRegionId()).orElse(null);

		if(r !=null) {
			if(region.getRegionName() !=null) {
				r.setRegionName(region.getRegionName());
			}
			regionRepo.save(r);
		}


	}

	@Override
	public void regionDelete(Long regionId) {

		regionRepo.deleteById(regionId);

	}

	@Override
	public List<Office> officeSelectAll() {

		return officeRepo.findAll();
	}

	@Override
	public List<Office> officeSelectActivatedAll() {

		return officeRepo.findByState();
	}

	@Override
	public List<Office> officeSelectByRegionId(Long regionId) {

		return officeRepo.findByRegionId(regionId);
	}

	@Override
	public Office officeSelectById(Long officeId) {

		return officeRepo.findById(officeId).orElse(null);
	}
	
	@Override
	public Office officeSelectByTel(String tel) {
		
		return officeRepo.findByTel(tel);
	}

	@Override
	@Transactional
	public void officeInsert(Office office) {

		officeRepo.save(office);
		
		Office of = officeRepo.findByTel(office.getTel()); 

		Authority authority = new Authority(null, "0", office.getTel(),of.getOfficeId());
		authorityRepo.save(authority);

	}
	
	@Override
	public void authorityInsert(Office office) {
	
		//Office of = officeRepo.findByTel(office.getTel());
		
	}

	@Override
	public void officeUpdate(Office office) {

		Office o = officeRepo.findById(office.getOfficeId()).orElse(null);

		if(o !=null) {
			if(office.getOfficeName() !=null) {
				o.setOfficeName(office.getOfficeName());
			}
			if(office.getAddress() !=null) {
				o.setAddress(office.getAddress());
			}
			if(office.getPassword() !=null) {
				o.setCode(office.getPassword());
			}
			if(office.getTel() !=null) {
				o.setTel(office.getTel());
			} 
			if(office.getUrl()!=null) {
				o.setUrl(office.getUrl());
			}
			officeRepo.save(o);
		}


	}


	@Override
	public void officeChangeState(Long officeId) {

		Office o =officeRepo.findById(officeId).orElse(null);
		int state;

		if(o !=null) {
			state = o.getState();

			if(state ==0) {
				o.setState(1);
			} else {
				o.setState(0);
			}
			officeRepo.save(o);
		}

	}

	@Override
	public List<Point> pointSelectAll() {

		return pointRepo.findAll();
	}

	@Override
	public List<Point> pointSelectByMemberId(Long memberId) {

		return pointRepo.findByMemberId(memberId);
	}

	@Override
	public Point pointSelectById(Long pointId) {

		return pointRepo.findById(pointId).orElse(null);
	}

	@Transactional
	@Override
	public void pointInsert(Point point) {

		pointSaveLogRepo.save(new PointSaveLog(null, null, point.getPoint(), point));
		
		pointRepo.save(point);
	}

	@Override
	public void pointUpdate(Point point) {

		Point p =pointRepo.findById(point.getPointId()).orElse(null);

		if(p !=null) {
			if(point.getPointName() !=null) {
				p.setPointName(point.getPointName());
			}
			if(point.getPoint() !=null) {
				p.setPoint(point.getPoint());
			}

			pointRepo.save(p);
		}

	}

	@Override
	public List<Point> pointSelectUnusedPoint(Long memberId) {

		return pointRepo.findByUnusedPoint(memberId);
	}

	@Override
	public List<Point> pointSelectUsedPoint(Long memberId) {

		return pointRepo.findByUnusedPoint(memberId);
	}
	
	
	@Override
	public List<PointUseLog> pointUseLogSelectAll() {

		return pointUseLogRepo.findAll();
	}

	@Override
	public PointUseLog pointUseLogSelectById(Long id) {

		return pointUseLogRepo.findById(id).orElse(null);
	}

	@Override
	public List<PointUseLog> pointUseLogSelectByMemberId(Long memberId) {

		return pointUseLogRepo.findByMemberId(memberId);
	}

	@Override
	public void pointUserLogInsert(PointUseLog pointUseLog) {
		pointUseLogRepo.save(pointUseLog);
		
	}

	@Override
	public List<PointSaveLog> pointSaveLogSelectAll() {
		
		return pointSaveLogRepo.findAll();
	}

	@Override
	public PointSaveLog pointSaveLogSelectById(Long id) {

		return pointSaveLogRepo.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public void pointDelete(Long pointId) {
		
		
		pointUseLogRepo.deleteByPointId(pointId);
		pointSaveLogRepo.deleteByPointId(pointId);
		pointRepo.deleteById(pointId);
		
		
	}

	@Override
	public List<PointSaveLog> pointSaveLogSelectByMemberId(Long memberId) {

		return pointSaveLogRepo.findByMemberId(memberId);
	}

	@Override
	public void pointSaveLogInsert(PointSaveLog pointSaveLog) {
		
		pointSaveLogRepo.save(pointSaveLog);
	}
	

	@Override
	public Members memberSelectByPhone(String phone) {
		return membersRepo.findByPhone(phone);
	}

	@Override
	public List<OfficeBoard> officeBoardSelectAll() {
		return officeBoardRepo.findAll();
	}

	@Override
	public OfficeBoard officeBoardSelectById(Long officeBoardId) {
		
		return officeBoardRepo.findById(officeBoardId).orElse(null);
	}

	@Override
	public void officeBoardInsert(OfficeBoard officeBoard) {
		
		officeBoardRepo.save(officeBoard);
	}

	@Override
	public void officeBoardUpdate(OfficeBoard officeBoard) {
		
		OfficeBoard ob = officeBoardRepo.findById(officeBoard.getOfficeBoardId()).orElse(null);
		
		if (officeBoard.getContent()!=null) {
			ob.setContent(officeBoard.getContent());
		}
		
		if(officeBoard.getReadNum()!=null) {
			ob.setReadNum(officeBoard.getReadNum());
		}
		
		if(officeBoard.getTitle()!=null) {
			ob.setTitle(officeBoard.getTitle());
		}
		
		officeBoardRepo.save(ob);
		
	}

	@Override
	@Transactional
	public void officeBoardDelete(Long officeBoardId) {
		
		
		repliesRepo.deleteByOfficeBoardId(officeBoardId);
		
	
		
		officeBoardRepo.deleteById(officeBoardId);
	}

	@Override
	public void replyInsert(Replies replies) {
		repliesRepo.save(replies);
		
	}

	@Override
	public void replyDelete(Long repliesId) {
		repliesRepo.deleteById(repliesId);
		
	}



	
	

}
