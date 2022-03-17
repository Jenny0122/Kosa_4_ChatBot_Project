package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DB table명은 모두 소문자로 생성 (대문자 인식 못함)

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
	}
	
	//master
}
