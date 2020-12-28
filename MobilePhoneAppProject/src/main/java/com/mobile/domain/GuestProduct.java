package com.mobile.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 게스트만 볼 수 있는 상품
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GuestProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_guest_product")
	@SequenceGenerator(sequenceName = "seq_guest_product", name="seq_guest_product", allocationSize = 1 )
	Long guestProductId;
	
	
	@ManyToOne
	@JoinColumn(name="productsId")
	Products product;
	

}
