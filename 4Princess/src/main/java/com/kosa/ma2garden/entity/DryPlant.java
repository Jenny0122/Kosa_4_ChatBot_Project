package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

	@Column(name = "grwt_info")
	private String grwt_info;

	@Column(name = "light_info")
	private String light_info;

	@Column(name = "water_cycle_info")
	private String water_cycle_info;

	@Column(name = "batch_place_info")
	private String batch_place_info;

	public long getNo() {
		return no;
	}

	public String getPlanttName() {
		return plant_name;
	}

	public String getChartrInfo() {
		return chartr_info;
	}

	public String getFlwrInfo() {
		return flwr_info;
	}

	public String getGrwtInfo() {
		return grwt_info;
	}

	public String getLightInfo() {
		return light_info;
	}

	public String getWaterCycleInfo() {
		return water_cycle_info;
	}

	public String getBatchPlaceInfo() {
		return batch_place_info;
	}

	@Override
	public String toString() {
		return "DryPlant [no=" + no + ", plant_name=" + plant_name + ", chartr_info=" + chartr_info + ", flwr_info="
				+ flwr_info + ", grwt_info=" + grwt_info + ", water_cycle_info=" + water_cycle_info
				+ ", batch_place_info=" + batch_place_info + "]";
	}
}
