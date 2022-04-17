package com.kosa.ma2garden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User loadUserByUsername(String id) throws UsernameNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
	}
}
