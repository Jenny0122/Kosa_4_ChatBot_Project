package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class GrowMethodDTO {
	
	private long no;
	private String name;
	private String kind;
	private String nutrient;
	private String growing_season;
	private String eat;
	private int level;
	private int sunlight;
	private String grow_temperature;
	private String flowerpot_size;
	private String pest;
	private String term;
	private String infomation;
	private String feature;
	private String materials;
	private String cultivation_process;
	private String img_url;
	
	@Builder
	public GrowMethodDTO(long no, String name, String kind, String nutrient, String growing_season, String eat, int level, int sunlight, String grow_temperature, String flowerpot_size, String pest, String term, String infomation, String feature, String materials, String cultivation_process, String img_url) {
		super();
		this.no = no;
		this.name = name;
		this.kind = kind;
		this.nutrient = nutrient;
		this.growing_season = growing_season;
		this.eat = eat;
		this.level = level;
		this.sunlight = sunlight;
		this.grow_temperature = grow_temperature;
		this.flowerpot_size = flowerpot_size;
		this.pest = pest;
		this.term = term;
		this.infomation = infomation;
		this.feature = feature;
		this.materials = materials;
		this.cultivation_process = cultivation_process;
		this.img_url = img_url;
	}
}
