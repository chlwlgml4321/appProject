package com.mobile.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResults {

	Long productId;
	Long deviceId;
	Long carrierId;
	Long callingPlanId;
	
	String deviceName;	
	String deviceImg;
	String carrierName;
	String callingPlanName;
	Integer price;
	
	
}
