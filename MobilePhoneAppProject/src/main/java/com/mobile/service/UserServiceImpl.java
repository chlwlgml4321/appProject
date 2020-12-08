package com.mobile.service;

import java.util.List;

import com.mobile.domain.Blacklist;
import com.mobile.domain.Members;
import com.mobile.domain.Notice;
import com.mobile.domain.Office;
import com.mobile.domain.Point;
import com.mobile.domain.Region;
import com.mobile.domain.Review;

public class UserServiceImpl implements UserService {

	@Override
	public List<Members> memberSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Members> mamberSelectActivatedAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Members memberSelectById(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberInsert(Members member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberUpdate(Members member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberChangeState(Long memberId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Blacklist> blacklistSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blacklist blacklistSelectById(Long blacklistId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void blacklistInsert(Blacklist blacklist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void blacklistUpdate(Blacklist blacklist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void blacklistDelete(Long blacklistId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Notice> noticeSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice noticeSelectById(Long noticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void noticeInsert(Notice notice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void noticeUpdate(Notice notice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void noticeDelete(Long noticeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Review> reviewSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review reviewSelectById(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> reviewSelectByMemberId(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reviewInsert(Review review) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reviewUpdate(Review review) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reviewDelete(Long reviewId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Region> regionSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region regionSelectById(Long regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regionInsert(Region region) {
		// TODO Auto-generated method stub

	}

	@Override
	public void regionUpdate(Region region) {
		// TODO Auto-generated method stub

	}

	@Override
	public void regionDelete(Long regionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Office> officeSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> officeSelectActivatedAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> officeSelectByRegionId(Long regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Office officeSelectById(Long officeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void officeInsert(Office office) {
		// TODO Auto-generated method stub

	}

	@Override
	public void officeUpdate(Office office) {
		// TODO Auto-generated method stub

	}

	@Override
	public void officeChangeState(Long officeId, Integer state) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Point> pointSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> pointSelectByMemberId(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point pointSelectById(Long pointId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pointInsert(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pointUpdate(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pointChangeState(Long pointId, Integer state) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Point> pointSelectUnusedPoint(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> pointSelectUsedPoint(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
