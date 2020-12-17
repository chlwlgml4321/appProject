package com.mobile.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Installment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_installment")
	@SequenceGenerator(sequenceName = "seq_installment", name="seq_installment", allocationSize = 1 )
	Long seq_installmentId;
	
	
	Integer installmentValue;
	
	Integer state;
	
	
}