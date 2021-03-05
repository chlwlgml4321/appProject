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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicInsert
@DynamicUpdate
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
	
	Integer cash;
	
	/* activation_type :
	* 0 – 번호이동
	* 1 – 기기변경
	*/
	Integer activationType;
	
	//마켓지원금
	Integer marketSupportFund;
	
	//공시지원금
	Integer mainSupportFund;
	
	
	/*isReccomendationProduct : 
	* 0 - 추천 상품 아님(디폴트)
	* 1 - 추천 상품임
	*/
	Integer isReccomendationProducts;
	
	/**
	 * 0 - 비활성화
	 * 1 - 활성화
	 * */
	Integer state;
	
	
	/**
	 * 할부 수수료
	 * */
	Integer installmentFee;
	
	/**
	 * 재고
	 * */
	Integer stock;
	
	
	
}
