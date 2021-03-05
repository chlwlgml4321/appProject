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
public class OfficeNotice {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_office_notice")
	@SequenceGenerator(sequenceName = "seq_office_notice", name="seq_office_notice", allocationSize = 1 )
	Long officeNoticeId;
	
	@ManyToOne
	@JoinColumn(name="officeId")
	Office office;
	
	String content;
	
	String title;
	
	Date regDate;
}
