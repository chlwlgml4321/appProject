package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 게스트만 볼 수 있는 상품
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class GuestProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_guest_product")
	@SequenceGenerator(sequenceName = "seq_guest_product", name="seq_guest_product", allocationSize = 1 )
	Long guestProductId;
	
	
	@ManyToOne
	@JoinColumn(name="carrierId")
	Carrier carrier;
	
	@ManyToOne
	@JoinColumn(name="callingPlanId")
	CallingPlan callingPlan;
	
	@ManyToOne
	@JoinColumn(name="officeId")
	Office office;
	
	@ManyToOne
	@JoinColumn(name="deviceId")
	Device device;
	
	
	/* activation_type :
	* 0 – 번호이동
	* 1 – 기기변경
	*/
	Integer activationType;
	
	//공시지원금
	Integer mainSupportFund;
	
	
	/*isReccomendationProduct : 
	* 0 - 추천 상품 아님(디폴트)
	* 1 - 추천 상품임
	*/
	Integer isReccomendationProducts;
	
	
}

	
