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
@Table(name = "dry_plant")
public class DryPlant {

	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "plant_name")
	private String plant_name;

	@Column(name = "chartr_info")
	private String chartr_info;

	@Column(name = "flwr_info")
	private String flwr_info;

	@Column(name = "light_info")
	private String light_info;

	@Column(name = "grwt_info")
	private String grwt_info;

	@Column(name = "water_cycle_info")
	private String water_cycle_info;

	@Column(name = "batchPlaceInfo")
	private String batchPlaceInfo;
}
