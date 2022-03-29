package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.CookDTO;
import com.kosa.ma2garden.service.CookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CookControlloer {

	@Autowired
	CookService cookService;

	@ApiOperation(value = "레시피 전체 정보 가져오기", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/cook")
	public ResponseEntity<List<CookDTO>> getCook() {
		List<CookDTO> list = cookService.getAllCook();
		
		return new ResponseEntity<List<CookDTO>>(list, HttpStatus.OK);
	}

}
