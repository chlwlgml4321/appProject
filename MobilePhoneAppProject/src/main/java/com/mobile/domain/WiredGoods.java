package com.mobile.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WiredGoods {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_wiredgoods")
	@SequenceGenerator(sequenceName = "seq_wiredgoods", name="seq_wiredgoods", allocationSize = 1 )
	Long wiredGoodsId;
	
	String wiredGoodsName;
	
	Integer discount;
	
	String cardImg;
	
	Integer state;
	
	
}