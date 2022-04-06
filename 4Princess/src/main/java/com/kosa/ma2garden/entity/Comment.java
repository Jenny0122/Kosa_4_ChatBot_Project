package com.kosa.ma2garden.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "comment")

public class Comment {
	@Id
	@Column(name = "co_no")
	private long co_no;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "board_no")
	private String board_no;
	
	@Column(name = "user_no")
	private String user_no;

	@Builder
	public Comment(long co_no, String comment, String day, String board_no, String user_no) {
		super();
		this.co_no = co_no;
		this.comment = comment;
		this.day = day;
		this.board_no = board_no;
		this.user_no = user_no;
	}

	
	


}
