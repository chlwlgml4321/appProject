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
public class MainSupportFund {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_main_support_fund")
	@SequenceGenerator(sequenceName = "seq_main_support_fund", name="seq_main_support_fund", allocationSize = 1 )
	Long marketSupportFundId;
	
	Integer price;
	
}
