package com.kosa.ma2garden.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@ToString
public class IndoorPlantDTO {
	
	private long no;
	private String name;
	private String lef_stle_info;
	private String prpgt_era_info;
	private String frtlzr_info;
	private String soil_info;
	private String fnclty_info;
	
	
	@Builder   // 생성자를 만든 후 그 위에 @Builder 애노테이션 적용
	public IndoorPlantDTO(long no, String name, String lef_stle_info, String prpgt_era_info, String frtlzr_info, String soil_info, String fnclty_info) {
		super();
		this.no = no;
		this.name = name;
		this.lef_stle_info = lef_stle_info;
		this.prpgt_era_info = prpgt_era_info;
		this.frtlzr_info = frtlzr_info;
		this.soil_info = soil_info;
		this.fnclty_info = fnclty_info;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLef_stle_info() {
		return lef_stle_info;
	}


	public void setLef_stle_info(String lef_stle_info) {
		this.lef_stle_info = lef_stle_info;
	}


	public String getPrpgt_era_info() {
		return prpgt_era_info;
	}


	public void setPrpgt_era_info(String prpgt_era_info) {
		this.prpgt_era_info = prpgt_era_info;
	}


	public String getFrtlzr_info() {
		return frtlzr_info;
	}


	public void setFrtlzr_info(String frtlzr_info) {
		this.frtlzr_info = frtlzr_info;
	}


	public String getSoil_info() {
		return soil_info;
	}


	public void setSoil_info(String soil_info) {
		this.soil_info = soil_info;
	}


	public String getFnclty_info() {
		return fnclty_info;
	}


	public void setFnclty_info(String fnclty_info) {
		this.fnclty_info = fnclty_info;
	}


	public long getNo() {
		return no;
	}


	public void setNo(long no) {
		this.no = no;
	}

	

}
