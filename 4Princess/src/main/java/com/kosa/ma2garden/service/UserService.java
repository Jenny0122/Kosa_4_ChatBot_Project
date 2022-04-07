package com.kosa.ma2garden.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.entity.UserDTO;
import com.kosa.ma2garden.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

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

	public boolean createUser(UserDTO userDTO) {

		User user = User.builder().id(userDTO.getId()).password(userDTO.getPassword())
				.email(userDTO.getEmail()).created_at(LocalDateTime.now()).updated_at(LocalDateTime.now()).build();

		userRepository.save(user);

		return true;
	}

}
