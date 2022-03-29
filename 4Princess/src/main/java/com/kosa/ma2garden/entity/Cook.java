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
@Table(name = "cook")
public class Cook {

	@Id
	@Column(name = "no")
	long no;

	@Column(name = "crop")
	String crop;

	@Column(name = "menu")
	String menu;

	@Column(name = "photo")
	String photo;
	
	@Column(name = "ingredient")
	String ingredient;

	@Column(name = "cooking_order")
	String cooking_order;

}
