package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Book;
import com.kosa.ma2garden.entity.BookDTO;
import com.kosa.ma2garden.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<BookDTO> getAllBooks() {

		List<BookDTO> list = new ArrayList<BookDTO>();

		for (Book book : bookRepository.findAll()) {
			BookDTO bookDTO = BookDTO.builder()
					.no(book.getNo())
					.title(book.getTitle())
					.author(book.getAuthor())
					.publisher(book.getPublisher())
					.thumbnail(book.getThumbnail())
					.url(book.getUrl())
					.build();
			
			list.add(bookDTO);
		}

		return list;
	}
}
