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

	/*
	 * public List<UserDTO> getAllUsers() {
	 * 
	 * List<UserDTO> list = new ArrayList<UserDTO>(); for (User user :
	 * userRepository.findAll()) { UserDTO userDTO =
	 * UserDTO.builder().no(user.getNo()).id(user.getId()).password(user.getPassword
	 * ()) .email(user.getEmail()).created_at(user.getCreated_at()).updated_at(user.
	 * getUpdated_at()).build();
	 * 
	 * list.add(userDTO); }
	 * 
	 * return list; }
	 */

	public boolean idVaild(String id) {
		User check = userRepository.findAllById(id);

		if (check != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean createUser(UserDTO userDTO) {
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

		userDTO.setPassword(encodedPassword);

		User user = User.builder()
				.id(userDTO.getId())
				.password(userDTO.getPassword())
				.email(userDTO.getEmail())
				.build();

		userRepository.save(user);

		return true;
	}

	public User loginUser(UserDTO userDTO) {

		User user = User.builder()
				.id(userDTO.getId())
				.password(userDTO.getPassword())
				.build();

		user = userRepository.findAllByIdAndPassword(user.getId(), user.getPassword());

		if (user != null) {
			return user;
		}

		return null;
	}

}