package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BookResponseDTO {

	private long no;
	private String title;
	private String author;
	private String publisher;
	private String thumbnail;
	private String url;

	@Builder
	public BookResponseDTO(long no, String title, String author, String publisher, String thumbnail, String url) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.url = url;
	}

}
