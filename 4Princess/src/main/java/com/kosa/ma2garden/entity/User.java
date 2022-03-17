package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DB table紐낆� 紐⑤몢 �냼臾몄옄濡� �깮�꽦 (��臾몄옄 �씤�떇 紐삵븿)

@Table(name = "user")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@Column(name = "id")
	private long id;

	@Builder
	public User(long id) {
		super();
		this.id = id;
//	안녕하세요
	}
	
	//master
}
