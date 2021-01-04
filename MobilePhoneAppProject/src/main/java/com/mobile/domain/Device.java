package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicInsert
@DynamicUpdate
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_device")
	@SequenceGenerator(sequenceName = "seq_device", name="seq_device", allocationSize = 1 )
	Long deviceId;
	
	String deviceName;
	//String modelNo;
	
	//원가
	Integer price;
	
	//s3 url
	String image;
	
	Integer state;
}
