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

	@Builder // 생성자를 만든 후 그 위에 @Builder 애노테이션 적용
	public AirPlantDTO(long no, String name, String description, String batchrecomm, String management) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
		this.batchrecomm = batchrecomm;
		this.management = management;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBatchrecomm() {
		return batchrecomm;
	}

	public void setBatchrecomm(String batchrecomm) {
		this.batchrecomm = batchrecomm;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}
}
