package com.kosa.ma2garden.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDTO {
	private String id;
	private String password;
	private String email;
	
	@Builder
	public UserDTO(String id, String password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	

}
