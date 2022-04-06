package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BoardDTO {
	private long no;
	private String counts;
	private String title;
	private String contents;
	private String day;
	private String user_no;
	
	@Builder
	public BoardDTO(long no, String counts, String title, String contents, String day, String user_no) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.day = day;
		this.user_no = user_no;
		
	}	
}
