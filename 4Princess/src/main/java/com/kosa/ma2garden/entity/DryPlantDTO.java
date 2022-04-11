package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class DryPlantDTO {

	private long no;
	private String plant_name;
	private String chartr_info;
	private String flwr_info;
	private String light_info;
	private String grwt_info;
	private String water_cycle_info;
	private String batch_place_info;

	@Builder // 생성자를 만든 후 그 위에 @Builder 애노테이션 적용
	public DryPlantDTO(long no, String plant_name, String chartr_info, String flwr_info, String light_info,
			String grwt_info, String water_cycle_info, String batch_place_info) {
		super();
		this.no = no;
		this.plant_name = plant_name;
		this.chartr_info = chartr_info;
		this.flwr_info = flwr_info;
		this.light_info = light_info;
		this.grwt_info = grwt_info;
		this.water_cycle_info = water_cycle_info;
		this.batch_place_info = batch_place_info;

	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getChartr_info() {
		return chartr_info;
	}

	public void setChartr_info(String chartr_info) {
		this.chartr_info = chartr_info;
	}

	public String getFlwr_info() {
		return flwr_info;
	}

	public void setFlwr_info(String flwr_info) {
		this.flwr_info = flwr_info;
	}

	public String getLight_info() {
		return light_info;
	}

	public void setLight_info(String light_info) {
		this.light_info = light_info;
	}

	public String getGrwt_info() {
		return grwt_info;
	}

	public void setGrwt_info(String grwt_info) {
		this.grwt_info = grwt_info;
	}

	public String getWater_cycle_info() {
		return water_cycle_info;
	}

	public void setWater_cycle_info(String water_cycle_info) {
		this.water_cycle_info = water_cycle_info;
	}

	public String getBatch_place_info() {
		return batch_place_info;
	}

	public void setBatch_place_info(String batch_place_info) {
		this.batch_place_info = batch_place_info;
	}
}
