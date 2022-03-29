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
@Table(name = "plant_disease")
public class PlantDisease {
	
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "crop_name")
	private String crop_name;
	
	@Column(name = "sick_name_kor")
	private String sick_name_kor;
	
	@Column(name = "symptoms")
	private String symptoms;
	
	@Column(name = "prevention_method")
	private String prevention_method;
	
	@Column(name = "ori_img")
	private String ori_img;
}
