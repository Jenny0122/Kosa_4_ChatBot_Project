package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "comment")
public class Comment extends BaseTimeEntity {

	@Id
	@Column(name = "co_no")
	private long co_no;

	@Column(name = "comment")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonManagedReference
	@JoinColumn(name = "board_no")
	private Board board_no;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_no")
	private User user_no;

	@Builder
	public Comment(long co_no, String comment, Board board_no, User user_no) {
		super();
		this.co_no = co_no;
		this.comment = comment;
		this.board_no = board_no;
		this.user_no = user_no;
	}

}
