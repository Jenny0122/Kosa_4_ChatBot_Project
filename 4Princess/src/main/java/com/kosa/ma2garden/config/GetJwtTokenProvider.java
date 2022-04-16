package com.kosa.ma2garden.config;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetJwtTokenProvider {

	final JwtTokenProvider jwtTokenProvider;
	
	
	public JwtTokenProvider getProvider() {
		return jwtTokenProvider;
	}
}
