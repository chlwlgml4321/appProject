package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 요금제
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CallingPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_calling_plan")
	@SequenceGenerator(sequenceName = "seq_calling_plan", name="seq_calling_plan", allocationSize = 1 )
	Long callingPlanId;
	
	String planName;
	
	//기본 요금
	Integer basicFee;
	
	//선택 약정 할인
	Integer bondDiscount;
	
	/**
	 * 5G or LTE
	 * LTE - 0
	 * 5g - 1
	 * */
	Integer networkType;
	
	@ManyToOne
	@JoinColumn(name="carrierId")
	Carrier carrier;
	
	/**
	 * 0 - 비활성화
	 * 1 - 활성화
	 * */
	Integer state;
	
}
