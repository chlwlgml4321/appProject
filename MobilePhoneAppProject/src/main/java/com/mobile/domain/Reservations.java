package com.mobile.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reservations {

	
	Date reservationDate;
	String userName;
	String deviceName;
	Integer reservationState;
	
}
