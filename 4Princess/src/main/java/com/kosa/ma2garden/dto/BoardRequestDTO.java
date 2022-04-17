package com.kosa.ma2garden.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.kosa.ma2garden.entity.Comment;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BoardRequestDTO {
	private long no;
	private String counts;
	private String title;
	private String contents;
	private LocalDateTime day;
	private String user_no;
	private List<Comment> comment;

	@Builder
	public BoardRequestDTO(long no, String counts, String title, String contents, LocalDateTime day, String user_no,
			List<Comment> comment) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.day = day;
		this.user_no = user_no;
		this.comment = comment;
	}

}
