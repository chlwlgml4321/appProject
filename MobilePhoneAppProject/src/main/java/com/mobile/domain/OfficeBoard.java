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
public class OfficeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_office_board")
	@SequenceGenerator(sequenceName = "seq_office_board", name="seq_office_board", allocationSize = 1 )
	Long officeBoardId;

	String content;

	String title;

	Date regDate;

	Integer readNum;

	@ManyToOne
	@JoinColumn(name="officeId")
	Office office;

	@OneToMany(mappedBy = "officeBoard")
	private List<Replies> replies;


}
