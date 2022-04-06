package com.kosa.ma2garden.entity;
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
	private String board_no;
	private String user_no;
	
	@Builder
	public CommentDTO(long co_no, String comment, String day, String board_no, String user_no) {
		super();
		this.co_no = co_no;
		this.comment = comment;
		this.day = day;
		this.board_no = board_no;
		this.user_no = user_no;
	}

}
