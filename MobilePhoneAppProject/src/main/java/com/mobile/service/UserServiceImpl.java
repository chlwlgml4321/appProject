package com.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.domain.Blacklist;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Region;
import com.mobile.domain.Review;
import com.mobile.repository.BlacklistRepository;
import com.mobile.repository.MembersRepository;
import com.mobile.repository.NoticeRepository;
import com.mobile.repository.OfficeRepository;
import com.mobile.repository.PointRepository;
import com.mobile.repository.RegionRepository;
import com.mobile.repository.ReviewRepository;


@Service
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
		return membersRepo.findInactiveMember();
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
			
			membersRepo.save(m);
		}
		

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
			if(blacklist.getPhone()!=null) {
				black.setPhone(blacklist.getPhone());
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
	public void reviewInsert(Review review) {
		
		reviewRepo.save(review);

	}

	@Override
	public void reviewUpdate(Review review) {
		
		Review r= reviewRepo.findById(review.getReviewId()).orElse(null);
		
		if(r !=null) {
			if(review.getReviewImg1() !=null) {
				r.setReviewImg1(review.getReviewImg1());
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
			reviewRepo.save(r);
		}
		
		

	}

	@Override
	public void reviewDelete(Long reviewId) {
		
		reviewRepo.deleteById(reviewId);

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
	public void officeInsert(Office office) {
		
		officeRepo.save(office);

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
			if(office.getCode() !=null) {
				o.setCode(office.getCode());
			}
			if(office.getTel() !=null) {
				o.setTel(office.getTel());
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

	@Override
	public void pointInsert(Point point) {
		
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
	public void pointChangeState(Long pointId, Integer state) {
		
		Point point =pointRepo.findById(pointId).orElse(null);
		
		if(point !=null) {
			if(state==0) {
				point.setPointState(1);
			} else {
				point.setPointState(0);
			}
			
			pointRepo.save(point);
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

}
