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
 * 추천 특가 상품
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_recommendation")
	@SequenceGenerator(sequenceName = "seq_recommendation", name="seq_recommendation", allocationSize = 1 )
	Long recommendationId;
	
	@ManyToOne
	@JoinColumn(name="productsId")
	Products product;
	

}
