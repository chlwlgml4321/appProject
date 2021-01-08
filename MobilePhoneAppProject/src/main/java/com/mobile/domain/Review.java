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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 신청서
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_review")
	@SequenceGenerator(sequenceName = "seq_review", name="seq_review", allocationSize = 1 )
	Long reviewId;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	Members member;
	
	@ManyToOne
	@JoinColumn(name = "officeId")
	Office office;
	
	@ManyToOne
	@JoinColumn(name = "deviceId")
	Device device;
	
	@ManyToOne
	@JoinColumn(name = "carrierId")
	Carrier carrier;
	
	String reviewImg1;
	String reviewImg2;
	String reviewImg3;
	
	Integer activationType;
	
	Float rate;
	
	String content;
	
	Date regDate;
	
	
	
}
