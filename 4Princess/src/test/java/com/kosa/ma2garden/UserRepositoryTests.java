package com.kosa.ma2garden;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosa.ma2garden.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void insert() {
		userRepository.findAll()
				.stream()
				.forEach(System.out::println);
		;
	}
}
