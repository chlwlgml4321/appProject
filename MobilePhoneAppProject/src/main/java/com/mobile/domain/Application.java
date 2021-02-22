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
import lombok.ToString;

/**
 * 신청서
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_application")
	@SequenceGenerator(sequenceName = "seq_application", name="seq_application", allocationSize = 1 )
	Long applicationId;
	
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	Members member;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	Products product;
	
	Integer activationType;
	
	Integer purchaseType;
	
	Integer addtionalDiscount;
	
	Integer supportFundType;
	
	Integer isconnectWiredGoods;
	
	Date regDate;
	
	Integer state;
	
	Integer installmentFee;
	
	Integer installmentPrincipal;
	
	Integer cash;
	
	Integer monthlyInstallment;
	
	Integer monthlyCallingFee;
	
	Integer finalFee;
	
	@ManyToOne
	@JoinColumn(name="installmentId")
	Installment installment;
	
	@ManyToOne
	@JoinColumn(name="wiredGoodsId")
	WiredGoods wiredGoods;
	
	@ManyToOne
	@JoinColumn(name="carrierId")
	Card card;
	
	
}
