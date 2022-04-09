package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.BoardDTO;
import com.kosa.ma2garden.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<List<BoardDTO>> getBoard() {
		List<BoardDTO> list = boardService.getAllBoard();
		
		return new ResponseEntity<List<BoardDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/board")
	public ResponseEntity<String> createBoardContent(@RequestBody BoardDTO boardDTO){
		
		boardService.createBoardData(boardDTO);
		
		return new ResponseEntity<String>("데이터가 저장되었습니다.", HttpStatus.OK);
		
	}

}
