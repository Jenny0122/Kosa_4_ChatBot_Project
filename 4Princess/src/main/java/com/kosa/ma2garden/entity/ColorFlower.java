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
@Table(name = "color_flower")
public class ColorFlower {
	
	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "color_info")
	private String color_info;

	@Column(name = "color_eng_name")
	private String color_eng_name;

	@Column(name = "effect_info")
	private String effect_info;

	@Column(name = "space_info")
	private String space_info;

	@Column(name = "img_url")
	private String img_url;

}
