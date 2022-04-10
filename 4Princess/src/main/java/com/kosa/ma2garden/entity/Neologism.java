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
@Table(name = "neologism")
public class Neologism {
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "neologism")
	private String neologism;
	
	@Column(name = "meaning")
	private String meaning;

	


}
