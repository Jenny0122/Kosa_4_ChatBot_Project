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
@Table(name = "mbti")
public class MBTI {
	
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "mbti")
	private String mbti;
	
	@Column(name = "flower_name")
	private String flower_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image_url")
	private String image_url;
	

}
