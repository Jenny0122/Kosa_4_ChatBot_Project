package com.kosa.ma2garden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.entity.UserDTO;
import com.kosa.ma2garden.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean idVaild(String id) {
		User check = userRepository.findAllById(id);

		if (check != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean createUser(UserDTO userDTO) {

		User user = User.builder()
				.id(userDTO.getId())
				.password(passwordEncoder.encode(userDTO.getPassword()))
				.email(userDTO.getEmail())
				.build();

		userRepository.save(user);

		return true;
	}

	public User loginUser(UserDTO userDTO) {

		// ID기 기준으로 우선 조회 => ID는 Unique이기 때문에 가능
		User user = userRepository.findAllById(userDTO.getId());

		// PasswordEncoder가 사용자입력 password와 암호화저장된 password의 일치여부를 확인
		if (passwordEncoder.matches(userDTO.getPassword(), user.getPassword()))
			return user;
		else
			return null;
	}

}