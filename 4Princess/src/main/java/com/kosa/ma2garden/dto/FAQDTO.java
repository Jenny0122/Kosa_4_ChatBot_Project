package com.kosa.ma2garden.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class FAQDTO {
	private long no;
	private String question;
	private String answer;
	
	@Builder
	public FAQDTO(long no, String question, String answer) {
		super();
		this.no = no;
		this.question = question;
		this.answer = answer;
	}
	
}
