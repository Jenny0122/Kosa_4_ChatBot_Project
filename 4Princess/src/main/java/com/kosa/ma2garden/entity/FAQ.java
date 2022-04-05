package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "faq")
public class FAQ {
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "answer")
	private String answer;

}
