package com.kosa.ma2garden.entity;

import java.time.LocalDateTime;
import java.util.List;

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
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private User user_no;
	private List<Comment> comment;

	@Builder
	public BoardDTO(long no, String counts, String title, String contents, LocalDateTime created_at,
			LocalDateTime updated_at, User user_no, List<Comment> comment) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user_no = user_no;
		this.comment = comment;
	}
}
