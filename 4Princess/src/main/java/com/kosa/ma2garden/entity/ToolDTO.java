package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ToolDTO {

	private long no;
	private String name;
	private String description;

	@Builder
	public ToolDTO(long no, String name, String description) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
	}

}
