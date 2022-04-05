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
	private String img_url;
	
	@Builder
	public ToolDTO(long no, String name, String description, String img_url) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
		this.img_url = img_url;
	}
}
