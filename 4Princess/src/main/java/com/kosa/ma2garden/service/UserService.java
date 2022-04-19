package com.kosa.ma2garden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.JwtTokenProvider;
import com.kosa.ma2garden.config.MetricCounter;
import com.kosa.ma2garden.dto.UserDTO;
import com.kosa.ma2garden.dto.UserLoginResponseDTO;
import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MetricCounter metricCounter;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(this);

	public String idVaild(String id) {
		String message = id + "는 이미 사용 중입니다";
		User check = null;
		try {
			check = userRepository.findById(id)
					.orElseThrow(() -> new UsernameNotFoundException(id + "는 사용 가능합니다"));
			return message;
		} catch (UsernameNotFoundException e) {
			return e.getMessage();
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

	public UserLoginResponseDTO loginUser(UserDTO userDTO) {
		log.info("로그인 시도");
		// ID기 기준으로 우선 조회 => ID는 Unique이기 때문에 가능
		User user = null;

		user = userRepository.findById(userDTO.getId())
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

		// PasswordEncoder가 사용자입력 password와 암호화저장된 password의 일치여부를 확인
		if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("잘못된 비밀번호입니다.");
		}

		log.info("login 성공");
		// jwtTokenProvider = new JwtTokenProvider(this);
		UserLoginResponseDTO userLoginResponseDTO = UserLoginResponseDTO.builder()
				.no(user.getNo())
				.id(user.getId())
				// .jwtToken(jwtTokenProvider.createToken(user.getId(), new
				// ArrayList<String>(user.getRoles())))
				.build();
		return userLoginResponseDTO;

	}

	@Override
	public User loadUserByUsername(String id) throws UsernameNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
	}
}