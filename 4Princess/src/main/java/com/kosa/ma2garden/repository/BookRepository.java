package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosa.ma2garden.entity.Book;
import com.kosa.ma2garden.entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public User findById(long id);
}
