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
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_card")
	@SequenceGenerator(sequenceName = "seq_card", name="seq_card", allocationSize = 1 )
	Long cardId;
	
	String cardName;
	
	Integer discount;
	
	String cardImg;
	
	Integer minCardFee;
	
	@ManyToOne
	@JoinColumn(name="carrierId")
	Carrier carrier;
	
	Integer state;
}
