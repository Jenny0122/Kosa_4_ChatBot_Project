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
	
	public boolean idVaild(UserDTO userDTO) {
		System.out.println("!!!" + userDTO.getId() + "!!!");
		User check = userRepository.findAllById(userDTO.getId());
		System.out.println(check);
		if (check != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean createUser(UserDTO userDTO) {

		User user = User.builder().id(userDTO.getId()).password(userDTO.getPassword())
				.email(userDTO.getEmail()).created_at(LocalDateTime.now()).updated_at(LocalDateTime.now()).build();

		userRepository.save(user);

		return true;
	}

	public List<UserDTO> loginUser(UserDTO userDTO) {
		
		List<UserDTO> list = new ArrayList<UserDTO>();

		User user = User.builder().id(userDTO.getId()).password(userDTO.getPassword()).build();

		user = userRepository.findAllByIdAndPassword(user.getId(), user.getPassword());
		
		if (user != null) {
			UserDTO uDTO = UserDTO.builder()
					.id(user.getId())
					.email(user.getEmail())
					.build();
			list.add(uDTO);
			
			return list;
		}

		return list;
	}


}
