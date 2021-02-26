package com.mobile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mobile.domain.Blacklist;
import com.mobile.repository.BlacklistRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class BlackListService {
	
	@Autowired
	private BlacklistRepository blacklistRepository;
		
	private static BlackListService blackListService = null;
	static Map<String,String> blackListMap 	= null;
		
	public void printByKey(String key) {
		String str = blackListMap.get(key);
		System.out.println("print ...");
		System.out.println(str);
	}
	
	public String getByKey(String key) {
		String str = blackListMap.get(key);	
		String result = "이름 : " + str + "전화번호 : " + key + "\n";
		return result;
	}
	
	@PostConstruct
	public void setBlackList() {
		blackListMap = new HashMap<String, String>();
		
		List<Blacklist> list = blacklistRepository.findAll();
		
		for(Blacklist bl : list) {
			System.out.println("tel : " + bl.getTel());
			
			System.out.println("name : " + bl.getName());
			if(StringUtils.isEmpty(bl.getName())) {
				blackListMap.put(bl.getTel(), "이름 확인 불가");

			} else {
				blackListMap.put(bl.getTel(), bl.getName());
			}
		}
		
	}
	
	public static BlackListService getInstance() {
		if(blackListService == null) {
			blackListService = new BlackListService();
		}
		return blackListService;
	}
	
	public Map<String,String> getblackListMap(){
		
		return blackListMap;
	}
	
	public void insertblackListMap(String key, String value) {
		
		blackListMap.put(key, value);
	}
	
	

	
	
	
}

