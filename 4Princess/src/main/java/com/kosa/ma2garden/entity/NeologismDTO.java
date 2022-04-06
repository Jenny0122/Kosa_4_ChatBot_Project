package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class NeologismDTO {
	private long no;
	private String neologism;
	private String meaning;
	
	
	@Builder
	public NeologismDTO(long no, String neologism, String meaning) {
		super();
		this.no = no;
		this.neologism = neologism;
		this.meaning = meaning;
	}
	
	

}
