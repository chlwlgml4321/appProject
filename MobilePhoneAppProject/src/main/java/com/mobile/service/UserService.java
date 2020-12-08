package com.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobile.domain.Blacklist;
import com.mobile.domain.Members;

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
	 * 회원 조회
	 * */
	public Members memberSelectById(Long memberId);
	

	/**
	 * 회원 가입하기
	 * */
	public void memberInsert(Members member);
	
	/**
	 * 회원 정보 수정하기
	 * */
	public void memberUpdate(Members member);
	
	/**
	 * 회원 상태 변경하기
	 * */
	void memberChangeState(Long memberId);
	
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
	void blacklistChangeState(Long blacklistId);
	
	//Notice table
	
	//Review table
	
	//Region table
	
	//Office table
	
	//Point table
	
	
	
	
	
	
}
