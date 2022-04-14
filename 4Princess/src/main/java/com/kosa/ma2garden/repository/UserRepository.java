package com.kosa.ma2garden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.ma2garden.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findAllByIdAndPassword(String id, String password);

	Optional<User> findById(String id);
}