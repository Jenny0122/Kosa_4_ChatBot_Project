package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MBTIDTO {
	
	private long no;
	private String mbti;
	private String flower_name;
	private String description;
	private String image_url;
	
	@Builder
	public MBTIDTO(long no, String mbti, String flower_name, String description, String image_url) {
		super();
		this.no = no;
		this.mbti = mbti;
		this.flower_name = flower_name;
		this.description = description;
		this.image_url = image_url;
	}
	
}
