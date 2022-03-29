package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ColorFlowerDTO {

	private long no;
	private String color_info;
	private String effect_info;
	private String space_info;
	private String img_url;

	@Builder
	public ColorFlowerDTO(long no, String color_info, String effect_info, String space_info, String img_url) {
		super();
		this.no = no;
		this.color_info = color_info;
		this.effect_info = effect_info;
		this.space_info = space_info;
		this.img_url = img_url;
	}

}
