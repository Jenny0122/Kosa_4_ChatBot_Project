package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class InventionDTO_backup {
	private long no;
	private String idea;
	private String prize;
	private String prized_year;
	private String description;
	private String photo;
	private String url;
	
	@Builder
	public InventionDTO_backup(long no, String idea, String prize, String prized_year, String description, String photo, String url) {
		super();
		this.no = no;
		this.idea = idea;
		this.prize = prize;
		this.prized_year = prized_year;
		this.description = description;
		this.photo = photo;
		this.url = url;
	}

}
