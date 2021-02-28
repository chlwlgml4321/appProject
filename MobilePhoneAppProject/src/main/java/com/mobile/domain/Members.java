package com.mobile.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Members {
	
	public Members(Long memberId, String name, String phone, String regions, String profileImg, String memberCode,
			String password, Integer isVisitor, Integer state, Date regDate, Office office) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.phone = phone;
		this.regions = regions;
		this.profileImg = profileImg;
		this.memberCode = memberCode;
		this.password = password;
		this.isVisitor = isVisitor;
		this.state = state;
		this.regDate = regDate;
		this.office = office;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_members")
	@SequenceGenerator(sequenceName = "seq_members", name="seq_members", allocationSize = 1 )
	Long memberId;

	String name;
	String phone;
	String regions;
	String profileImg;
	String memberCode;
	String password;
	
	@JsonIgnore
	String blakcList = "";
	/**
	 * 방문 지점이 있는지 체크
	 * 0 - 방문 x
	 * 1 - 방문 o
	 */
	Integer isVisitor;
	
	/**
	 * 탈퇴 - 0
	 * 정상 - 1
	 * */
	Integer state;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date regDate;
	
	@OneToOne
	@JoinColumn(name="officeId")
	Office office;
	
	
}