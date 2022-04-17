package com.kosa.ma2garden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.dto.CommentDTO;
import com.kosa.ma2garden.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/comment")
	public ResponseEntity<String> createBoardContent(@RequestBody CommentDTO commentDTO) {

		commentService.createCommentData(commentDTO);

		return new ResponseEntity<String>("데이터가 저장되었습니다.", HttpStatus.OK);
	}

	@DeleteMapping("/comment/{no}")
	public ResponseEntity<String> deleteBoardByNo(@PathVariable long no) {

		commentService.deleteCommentdByNo(no);
		return ResponseEntity.ok("삭제 성공");
	}
}
