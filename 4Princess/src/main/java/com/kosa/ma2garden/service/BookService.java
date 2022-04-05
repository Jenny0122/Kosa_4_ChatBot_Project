package com.kosa.ma2garden.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	/*@Autowired
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
	}*/
}
