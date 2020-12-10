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
 * 특가 상품
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_products")
	@SequenceGenerator(sequenceName = "seq_products", name="seq_products", allocationSize = 1 )
	Long productsId;
	
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
	
	Integer activationType;
	
//	@OneToOne
//	@JoinColumn(name="marketSupportFundId")
//	MarketSupportFund marketSupportFund;
	
	Integer marketSupportFund;
	
//	@OneToOne
//	@JoinColumn(name="mainSupportFundId")
//	MainSupportFund mainSupportFund;
	
	Integer mainSupportFund;
	
	Integer isReccomendationProducts;
	
	/**
	 * 0 - 비활성화
	 * 1 - 활성화
	 * */
	Integer state;
}
