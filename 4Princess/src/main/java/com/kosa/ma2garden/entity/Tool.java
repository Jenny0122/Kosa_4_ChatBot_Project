package com.kosa.ma2garden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Tool")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "tool")
public class Tool {

	
	@Id
	@Column(name = "no")
	long no;

	@Column(name = "name")
	String name;

	@Column(name = "description")
	String description;

}
