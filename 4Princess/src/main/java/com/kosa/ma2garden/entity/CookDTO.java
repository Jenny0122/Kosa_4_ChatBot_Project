package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CookDTO {

	private long no;
	private String crop;
	private String menu;
	private String photo;
	private String ingredient;
	private String cooking_order;

	@Builder
	public CookDTO(long no, String crop, String menu, String photo, String ingredient, String cooking_order) {
		super();
		this.no = no;
		this.crop = crop;
		this.menu = menu;
		this.photo = photo;
		this.ingredient = ingredient;
		this.cooking_order = cooking_order;
	}

}
