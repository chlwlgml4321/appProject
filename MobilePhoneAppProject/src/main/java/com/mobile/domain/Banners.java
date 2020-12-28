package com.mobile.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Banners {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_banner")
	@SequenceGenerator(sequenceName = "seq_banner", name="seq_banner", allocationSize = 1 )
	Long bannerId;
	
	String bannerImg;

	
	String title;
	
	String contents;
}
