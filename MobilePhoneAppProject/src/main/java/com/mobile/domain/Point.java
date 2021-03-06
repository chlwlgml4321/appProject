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
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_point")
	@SequenceGenerator(sequenceName = "seq_point", name="seq_point", allocationSize = 1 )
	Long pointId;
	
	String pointName;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date regDate;
	
	Integer point;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	Members member;
}
