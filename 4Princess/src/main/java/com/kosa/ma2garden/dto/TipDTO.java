package com.kosa.ma2garden.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TipDTO {
	private long no;
	private String title;
	private String content;
	
	@Builder
	public TipDTO(long no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
}
