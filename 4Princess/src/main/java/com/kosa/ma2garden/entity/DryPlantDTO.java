package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class DryPlantDTO {
	private long no;
	private String plant_name;
	private String chartr_info;
	private String flwr_info;
	private String light_info;
	private String grwt_info;
	private String water_cycle_info;
	private String batchPlaceInfo;

	@Builder
	public DryPlantDTO(long no, String plant_name, String chartr_info, String flwr_info, String light_info,
			String grwt_info, String water_cycle_info, String batchPlaceInfo) {
		super();
		this.no = no;
		this.plant_name = plant_name;
		this.chartr_info = chartr_info;
		this.flwr_info = flwr_info;
		this.light_info = light_info;
		this.grwt_info = grwt_info;
		this.water_cycle_info = water_cycle_info;
		this.batchPlaceInfo = batchPlaceInfo;
	}
}
