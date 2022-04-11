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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@ApiOperation(value = "Board", notes = "Board 전체 정보 가져오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/board")
	public ResponseEntity<List<BoardDTO>> getBoard() {
		List<BoardDTO> list = boardService.getAllBoard();
		
		return new ResponseEntity<List<BoardDTO>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create Board", notes = "Board에 새 정보 생성")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping("/board")
	public ResponseEntity<String> createBoardContent(@RequestBody BoardDTO boardDTO){
		
		boardService.createBoardData(boardDTO);
		
		return new ResponseEntity<String>("데이터가 저장되었습니다.", HttpStatus.OK);
		
	}
	
}