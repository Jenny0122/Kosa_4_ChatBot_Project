package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class InsidePlantDTO {
	private long no;
	private String plant_name;
	private String lef_stle_info;
	private String prpgt_era_info;
	private String frtlzr_info;
	private String soil_info;
	private String fnclty_info;
	
	@Builder
	public InsidePlantDTO(long no, String plant_name, String lef_stle_info,
			String prpgt_era_info, String frtlzr_info, String soil_info, String fnclty_info) {
		super();
		this.no = no;
		this.plant_name = plant_name;
		this.lef_stle_info = lef_stle_info;
		this.prpgt_era_info = prpgt_era_info;
		this.frtlzr_info = frtlzr_info;
		this.soil_info = soil_info;
		this.fnclty_info = fnclty_info;
	}
}
