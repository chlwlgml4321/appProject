package com.mobile.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Replies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_replyNo")
	@SequenceGenerator(sequenceName = "seq_replyNo", name = "seq_replyNo", allocationSize = 1)
	private Long replyNo;
	
	@ManyToOne
	@JoinColumn(name = "office_board_id")
	private OfficeBoard officeBoard;
	
	private String reply;
	
	@ManyToOne
	@JoinColumn(name = "officeId")
	private Office office;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date regDate;
	
	@ManyToOne 
	@JoinColumn(name = "ref_reply")
	private Replies parentReply;
	
//	@Transient
	//one to many 설정 해야함
	
	@OneToMany(mappedBy = "parentReply", fetch = FetchType.LAZY)
	private List<Replies> childReplies;
	
}
