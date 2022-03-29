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
@Table(name = "grow_method")
public class GrowMethod {
	
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "kind")
	private String kind;
	
	@Column(name = "nutrient") //영양성분
	private String nutrient;
	
	@Column(name = "growing_season") //자라는 시기
	private String growing_season;
	
	@Column(name = "eat") //먹는 방법
	private String eat;
	
	@Column(name = "level") //난이도
	private int level;
	
	@Column(name = "sunlight") //햇빛량
	private int sunlight;
	
	@Column(name = "grow_temperature") //자라는 시기
	private String grow_temperature;
	
	@Column(name = "flowerpot_size") //화분 크기
	private String flowerpot_size;
	
	@Column(name = "pest") //병해충
	private String pest;
	
	@Column(name = "term") //수확하는 기간
	private String term;
	
	@Column(name = "infomation") //일반정보
	private String infomation; 
	
	@Column(name = "feature") //특징
	private String feature;
	
	@Column(name = "materials") //준비물
	private String materials;
	
	@Column(name = "cultivation_process") //재배과정
	private String cultivation_process;
	
}
