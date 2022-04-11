package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name="indoor_plant")
public class IndoorPlant {
	
	@Id
	@Column(name="no")
	private long no;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lef_stle_info")
	private String lef_stle_info;

	@Column(name="prpgt_era_info")
	private String prpgt_era_info;

	@Column(name="frtlzr_info")
	private String frtlzr_info;
	
	@Column(name="soil_info")
	private String soil_info;
	
	@Column(name="fnclty_info")
	private String fnclty_info;
	
	
	public long getNo() {
		return no;
	}



	public void setNo(long no) {
		this.no = no;
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



	@Override
	public String toString() {
		return "IndoorPlant [no=" + no + ", name=" + name + ", lef_stle_info=" + lef_stle_info + ", prpgt_era_info=" + prpgt_era_info + ", frtlzr_info=" + frtlzr_info + ", soil_info=" + soil_info + ", fnclty_info=" +fnclty_info + "]";
	}
}
	
