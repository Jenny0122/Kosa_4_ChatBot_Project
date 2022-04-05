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
@Table(name = "tip")
public class Tip {
	
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
}
