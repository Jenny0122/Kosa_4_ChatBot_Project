package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "invention")
public class Invention_backup {
	@Id
	@Column(name = "no")
	private long no;
	
	@Column(name = "idea")
	private String idea;
	
	@Column(name = "prize")
	private String prize;
	
	@Column(name = "prized_year")
	private String prized_year;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "url")
	private String url;
}
