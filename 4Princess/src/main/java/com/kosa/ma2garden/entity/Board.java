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
	private String day;
	
	@Column(name = "user_no")
	private String user_no;

	@Builder
	public Board(String counts, String title, String contents, String day, String user_no) {
		super();
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.day = day;
		this.user_no = user_no;
	}
	
	

}
