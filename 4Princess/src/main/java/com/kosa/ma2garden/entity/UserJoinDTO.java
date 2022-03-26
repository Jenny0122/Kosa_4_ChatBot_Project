package com.kosa.ma2garden.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// DTO, Entity차이점
// DTO : front에서 데이터를 받아올때 사용하는 객체 (ex. 회원가입때는 모든 입력정보를 받아야 함, 로그인시는 아이디 비밀번호만 받아야함)
// Entity : DB와 매핑된 객체 (모든입력정보 + 객체기본정보)

// 회원가입정보를 전달받는 객체
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserJoinDTO {

	private int id;
	private String value;
}
