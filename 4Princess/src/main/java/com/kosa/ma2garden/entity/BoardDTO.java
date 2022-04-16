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
	private Integer counts;
	private String title;
	private String contents;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private String user_id;
	private List<CommentDTO> comment;

	@Builder
	public BoardDTO(long no, Integer counts, String title, String contents, LocalDateTime created_at,
			LocalDateTime updated_at, String user_id, List<CommentDTO> comment) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user_id = user_id;
		this.comment = comment;
	}
}
