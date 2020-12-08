package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 기기 
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_device")
	@SequenceGenerator(sequenceName = "seq_device", name="seq_device", allocationSize = 1 )
	Long deviceId;
	
	String deviceName;
	String modelNo;
	
	//원가
	Integer price;
}
