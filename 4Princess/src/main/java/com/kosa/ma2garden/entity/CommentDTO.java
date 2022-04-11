package com.kosa.ma2garden.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CommentDTO {
	private long co_no;
	private String comment;
	private String day;
	private long board_no;
	private long user_no;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	@Builder
	public CommentDTO(long co_no, String comment, String day, long board_no, long user_no, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.co_no = co_no;
		this.comment = comment;
		this.day = day;
		this.board_no = board_no;
		this.user_no = user_no;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
}
