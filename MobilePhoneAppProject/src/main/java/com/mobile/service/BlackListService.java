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
//초기 블랙리스트를 DB에서 가져옵니다.

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
	
	//key 값(전화번호)를 통하여 블랙리스트를 가져옵니다.
	public String getByKey(String key) {
		String str = blackListMap.get(key);	
		if(str!=null) {
			String result = "이름 : " + str + "  전화번호 : " + key + "\n";
		return result;
		}
		return null;
	}
	
	//서버 실행 시 초기 블랙리스트 세팅
	@PostConstruct
	public void setBlackList() {
		blackListMap = new HashMap<String, String>();
		
		List<Blacklist> list = blacklistRepository.findAll();
		
		for(Blacklist bl : list) {
			
			if(blackListMap.containsKey(bl.getTel())) {
				String value = blackListMap.get(bl.getTel());
				
				blackListMap.put(bl.getTel(),value + "," +  bl.getName());
			}
			
			if(StringUtils.isEmpty(bl.getName())) {
				blackListMap.put(bl.getTel(), "");

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
	
	//블랙리스트 맵에 블랙리스트 추가
	public void insertblackListMap(String key, String value) {
		
		blackListMap.put(key, value);
	}
	
	

	
	
	
}

