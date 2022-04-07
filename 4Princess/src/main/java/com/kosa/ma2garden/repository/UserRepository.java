package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.ma2garden.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
