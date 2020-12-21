package com.mobile.domain;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Office {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_office")
	@SequenceGenerator(sequenceName = "seq_office", name="seq_office", allocationSize = 1 )
	Long officeId;
	
	String officeName;
	
	String address;
	
	String tel;
	
	String code;
	
	@ManyToOne
	@JoinColumn(name = "regionId")
	Region region;

	Integer state;
	
}
