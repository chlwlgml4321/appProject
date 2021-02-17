package com.mobile.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

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
public class Office {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_office")
	@SequenceGenerator(sequenceName = "seq_office", name="seq_office", allocationSize = 1 )
	Long officeId;
	
	String officeName;
	
	String address;
	
	String tel;
	
	String code;
	
	String password;
	
	@ManyToOne
	@JoinColumn(name = "regionId")
	Region region;

	Integer state;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="officeId")
	private List<Authority> roles;
	
}
