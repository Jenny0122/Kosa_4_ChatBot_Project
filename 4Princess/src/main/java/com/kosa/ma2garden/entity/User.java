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
@Table(name = "user")
public class User extends BaseTimeEntity {

	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "id")
	private String id;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Builder
	public User(long no, String id, String password, String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
	}
}
