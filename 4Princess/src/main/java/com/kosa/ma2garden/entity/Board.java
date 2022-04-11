package com.kosa.ma2garden.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board")
public class Board {
	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "counts")
	private String counts;

	@Column(name = "title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@Column(name = "day")
	private LocalDateTime day;

	@Column(name = "user_no")
	private String user_no;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "board_no")
	private List<Comment> comments = new ArrayList<Comment>();

	@Builder
	public Board(long no, String counts, String title, String contents, LocalDateTime day, String user_no,
			List<Comment> comments) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.day = day;
		this.user_no = user_no;
		this.comments = comments;
	}
}
