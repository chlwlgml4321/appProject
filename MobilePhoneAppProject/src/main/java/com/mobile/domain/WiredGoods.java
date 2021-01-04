package com.mobile.domain;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class WiredGoods {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_wiredgoods")
	@SequenceGenerator(sequenceName = "seq_wiredgoods", name="seq_wiredgoods", allocationSize = 1 )
	Long wiredGoodsId;
	
	String wiredGoodsName;
	
	Integer discount;
	
	Integer circuit;
	
	Integer capacity;
	
	Integer fee;
	
	String wiredGoodsImg;
	
	@ManyToOne
	@JoinColumn(name="carrierId")
	Carrier carrier;
	
	Integer state;
	
	
}