package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "air_plant")
public class AirPlant {

	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "batchrecomm")
	private String batchrecomm;

	@Column(name = "management")
	private String management;

	public long getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getBatchrecomm() {
		return batchrecomm;
	}

	public String getManagement() {
		return management;
	}

	@Override
	public String toString() {
		return "AirPlant [no=" + no + ", name=" + name + ", description=" + description + ", batchrecomm=" + batchrecomm
				+ ", management=" + management + "]";
	}

}
