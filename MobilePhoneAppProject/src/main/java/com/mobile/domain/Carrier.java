package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 통신사 
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carrier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_carrier")
	@SequenceGenerator(sequenceName = "seq_carrier", name="seq_carrier", allocationSize = 1 )
	Long carrierId;
	
	String carrierName;
}
