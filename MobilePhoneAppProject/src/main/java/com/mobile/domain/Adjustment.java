package com.mobile.domain;

import java.util.Date;

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
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Adjustment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_adjustment")
	@SequenceGenerator(sequenceName = "seq_adjustment", name="seq_adjustment", allocationSize = 1 )
	Long adjustmentId;
	
	Date regDate;
	
	@ManyToOne
	@JoinColumn(name="officeId")
	Office office;
	
	Integer amount;
	
}
