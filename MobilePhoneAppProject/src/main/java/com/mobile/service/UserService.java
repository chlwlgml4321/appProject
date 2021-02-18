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

@Service
public interface UserService {
	
	/***
	 * Members, Blacklist, Notice, Review, Region, Office, Point 
	 * 
	 * */
	
	
	//members table
	/**
	 * 회원 전체 조회
	 * */
	public List<Members> memberSelectAll();
	
	/**
	 * 활성화된 회원 전체 조회
	 * */
	public List<Members> mamberSelectActivatedAll();
	
	/**
	 * 비활성화된 회원 전체 조회
	 * */
	public List<Members> mamberSelectInactivatedAll();
	
	/**
	 * 회원 조회
	 * */
	public Members memberSelectById(Long memberId);
	
	/**
	 * phone로 멤버 조회
	 * */
	public Members memberSelectByPhone(String phone);
	
	/**
	 * 회원 officeId 로 조회하기 
	 */
	public List<Members> selectByOffice(Long officeId);

	/**
	 * 회원 가입하기
	 * @return 
	 * */
	public int memberInsert(Members member);
	
	/**
	 * 회원 정보 수정하기
	 * */
	public void memberUpdate(Members member);
	
	/**
	 * 회원 상태 변경하기
	 * */
	public void memberChangeState(Long memberId);
	
	
	/**
	 * 회원 상태 2에서 1로 변경하기 
	 */
	public void memberStateAvtice(Long memberId);
	
	/**
	 * 회원 로그인
	 * */
	Members memberLogin(String phoneNumber, String password);
	
	//Blacklist table
	/**
	 * 블랙리스트 전체 조회
	 * */
	public List<Blacklist> blacklistSelectAll();
	
	/**
	 * 블랙리스트 조회
	 * */
	public Blacklist blacklistSelectById(Long blacklistId);
	
	/**
	 * 블랙리스트 추가
	 * */
	public void blacklistInsert(Blacklist blacklist);
	
	/**
	 * 블래리스트 정보 수정하기
	 * */
	public void blacklistUpdate(Blacklist blacklist);
	
	/**
	 * 블랙리스트 삭제
	 * */
	public void blacklistDelete(Long blacklistId);
	
	
	//Notice table
	/**
	 * 공지사항 전체 조회
	 * */
	public List<Notice> noticeSelectAll();
	
	
	/**
	 * 공지사항 조회
	 * */
	public Notice noticeSelectById(Long noticeId);
	

	/**
	 * 공지사항 추가
	 * */
	public void noticeInsert(Notice notice);
	
	/**
	 * 공지사항 정보 수정하기
	 * */
	public void noticeUpdate(Notice notice);
	
	/**
	 * 공지사항 삭제
	 * */
	public void noticeDelete(Long noticeId);
	
	//Review table
	/**
	 * 리뷰 전체 조회
	 * */
	public List<Review> reviewSelectAll();
	
	
	/**
	 * 리뷰 조회
	 * */
	public Review reviewSelectById(Long reviewId);
	
	/**
	 * 작성자 아이디로 리뷰 조회
	 * */
	public List<Review> reviewSelectByMemberId(Long memberId);
	
	/**
	 * officeId 리뷰조회 
	 */
	public List<Review> reviewSelectByOfficeId(Long officeId);

	/**
	 * 리뷰 추가
	 * @return 
	 * */
	public Integer reviewInsert(Review review);
	
	/**
	 * 리뷰 정보 수정하기
	 * */
	public Integer reviewUpdate(Review review);
	
	/**
	 * 리뷰 삭제
	 * */
	public void reviewDelete(Long reviewId);

	//Region table
	/**
	 * 지역 전체 조회
	 * */
	public List<Region> regionSelectAll();
	
	
	/**
	 * 지역 아이디로 조회
	 * */
	public Region regionSelectById(Long regionId);

	/**
	 * 지점 번호로 조회
	 * */
	public Office officeSelectByTel(String tel);
	/**
	 * 지역 추가
	 * */
	public void regionInsert(Region region);
	
	/**
	 * 지역 정보 수정하기
	 * */
	public void regionUpdate(Region region);
	
	/**
	 * 지역 삭제
	 * */
	public void regionDelete(Long regionId);
	
	//Office table
	/**
	 * 지점 전체 조회
	 * */
	public List<Office> officeSelectAll();
	
	/**
	 * 활성화 지점 전체 조회
	 * */
	public List<Office> officeSelectActivatedAll();
	
	/**
	 * 지역 아이디로 지점 조회
	 * */
	public List<Office> officeSelectByRegionId(Long regionId);
	
	/**
	 * 지점 아이디로 조회
	 * */
	public Office officeSelectById(Long officeId);

	/**
	 * 지점 추가
	 * */
	public void officeInsert(Office office);
	
	/**
	 * 지점 정보 수정하기
	 * */
	public void officeUpdate(Office office);
	
	/**
	 * 지점 상태변경
	 * */
	public void officeChangeState(Long officeId);
	
	//Point table
	/**
	 * 포인트 전체 조회
	 * */
	public List<Point> pointSelectAll();
	
	/**
	 * 회원 아이디로 포인트 조회
	 * */
	public List<Point> pointSelectByMemberId(Long memberId);
	
	/**
	 * 포인트 아이디로 조회
	 * */
	public Point pointSelectById(Long pointId);

	/**
	 * 포인트 추가(새로운 포인트)
	 * */
	public void pointInsert(Point point);
	
	/**
	 * 포인트 정보 수정하기
	 * */
	public void pointUpdate(Point point);
	
	/**
	 * 포인트 상태변경
	 * */
	public void pointChangeState(Long pointId, Integer state);
	
	
	/**
	 * 미사용 포인트 회원 아이디로 조회
	 * */
	public List<Point> pointSelectUnusedPoint(Long memberId);
	
	/**
	 * 사용 포인트 회원 아이디로 조회
	 * */
	public List<Point> pointSelectUsedPoint(Long memberId);


	

}
