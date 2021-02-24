package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blacklist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_black")
	@SequenceGenerator(sequenceName = "seq_black", name="seq_black", allocationSize = 1 )
	Long blacklistId;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date regDate;
	
	String name;
	
	String tel;
	
	String title;
	
	String memo;
	
	
	
}
