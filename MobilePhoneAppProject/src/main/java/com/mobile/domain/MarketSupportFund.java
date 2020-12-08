package com.mobile.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class MarketSupportFund {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_market_support_fund")
	@SequenceGenerator(sequenceName = "seq_market_support_fund", name="seq_market_support_fund", allocationSize = 1 )
	Long marketSupportFundId;
	
	Integer price;
	
}
