package com.kosa.ma2garden.entity;

import java.time.LocalDateTime;

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
public class User {
	
	@Id
	@Column(name = "no")
	private long no;

	@Column(name = "id")
	private String id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "created_at")
	private LocalDateTime created_at;
	
	@Column(name = "updated_at")
	private LocalDateTime updated_at;

	@Builder
	public User(long no, String id, String password, String email, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
}
