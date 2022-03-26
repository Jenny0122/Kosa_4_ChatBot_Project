package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.BookResponseDTO;
import com.kosa.ma2garden.entity.UserJoinDTO;
import com.kosa.ma2garden.service.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DataController {

	@Autowired
	BookService bookService;

	// test
	@ApiOperation(value = "책 정보 생성", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping("/books")
	public ResponseEntity<List<BookResponseDTO>> test(@RequestBody UserJoinDTO data) {
		System.out.println("post");

		List<BookResponseDTO> list = bookService.getAllBooks();

		return new ResponseEntity<List<BookResponseDTO>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "책 전체 정보 가져오기", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/books")
	public ResponseEntity<List<BookResponseDTO>> test2() {
		System.out.println("get");

		List<BookResponseDTO> list = bookService.getAllBooks();

		return new ResponseEntity<List<BookResponseDTO>>(list, HttpStatus.OK);
	}
}
