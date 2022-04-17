package com.kosa.ma2garden.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PlantDiseaseDTO {
	
	private long no;
	private String crop_name;
	private String sick_name_kor;
	private String symptoms;
	private String prevention_method;
	private String ori_img;
	
	@Builder
	public PlantDiseaseDTO(long no, String crop_name, String sick_name_kor, String symptoms,
			String prevention_method, String ori_img) {
		super();
		this.no = no;
		this.crop_name = crop_name;
		this.sick_name_kor = sick_name_kor;
		this.symptoms = symptoms;
		this.prevention_method = prevention_method;
		this.ori_img = ori_img;
	}
}
