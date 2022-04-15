package com.kosa.ma2garden.entity;

import lombok.Builder;
import lombok.Data;

//DTO, Entity차이점
//DTO : front에서 데이터를 받아올때 사용하는 객체 (ex. 회원가입때는 모든 입력정보를 받아야 함, 로그인시는 아이디 비밀번호만 받아야함)
//Entity : DB와 매핑된 객체 (모든입력정보 + 객체기본정보)

@Data
public class UserLoginResponseDTO {

	private long no;

	private String id;

	String jwtToken;

	@Builder
	public UserLoginResponseDTO(long no, String id, String jwtToken) {
		super();
		this.no = no;
		this.id = id;
		this.jwtToken = jwtToken;
	}
}
