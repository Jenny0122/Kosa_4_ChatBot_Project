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
@Table(name = "inside_plant")
public class InsidePlant {

	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "plant_name")
	private String plant_name;
	
	@Column(name = "lef_stle_info")
	private String lef_stle_info;
	
	@Column(name = "prpgt_era_info")
	private String prpgt_era_info;
	
	@Column(name = "frtlzr_info")
	private String frtlzr_info;
	
	@Column(name = "soil_info")
	private String soil_info;
	
	@Column(name = "fnclty_info")
	private String fnclty_info;
	
}
