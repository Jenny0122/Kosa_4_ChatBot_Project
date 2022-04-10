package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.CommentDTO;
import com.kosa.ma2garden.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comment")
	public ResponseEntity<List<CommentDTO>> getComment() {
		List<CommentDTO> list = commentService.getAllComment();
		list.forEach(System.out::println);
		
		return new ResponseEntity<List<CommentDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<String> createBoardContent(@RequestBody CommentDTO commentDTO){
		
		commentService.createBoardData(commentDTO);
		
		return new ResponseEntity<String>("데이터가 저장되었습니다.", HttpStatus.OK);
	}

}
