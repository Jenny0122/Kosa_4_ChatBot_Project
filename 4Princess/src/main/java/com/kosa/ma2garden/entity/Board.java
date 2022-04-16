package com.kosa.ma2garden.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicInsert
@Table(name = "board")
public class Board extends BaseTimeEntity {

	@Id
	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	@Column(name = "counts")
	private Integer counts;

	@Column(name = "title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@ManyToOne
	@JoinColumn(name = "user_no")
	private User user_no;

	@OneToMany(mappedBy = "board_no", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	//@JoinColumn(name = "board_no")
	private List<Comment> comments = new ArrayList<Comment>();

	@Builder
	public Board(long no, Integer counts, String title, String contents, User user_no, List<Comment> comments) {
		super();
		this.no = no;
		this.counts = counts;
		this.title = title;
		this.contents = contents;
		this.user_no = user_no;
		this.comments = comments;
	}

	@PrePersist
	public void prePersist() {
		this.counts = this.counts == null ? 0 : this.counts;
	}
}
