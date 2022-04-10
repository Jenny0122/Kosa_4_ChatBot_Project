package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AirPlantDTO {
	private long no;
	private String name;
	private String description;
	private String batchrecomm;
	private String management;
	
	@Builder
	public AirPlantDTO(long no, String name, String description, String batchrecomm, String management) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
		this.batchrecomm = batchrecomm;
		this.management = management;
	}
}
