package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.MBTIDTO;
import com.kosa.ma2garden.service.MBTIService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MBTIController {

	@Autowired
	MBTIService mbtiService;

	@ApiOperation(value = "MBTI 전체 정보 가져오기", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/mbti")
	public ResponseEntity<List<MBTIDTO>> getMBTI() {

		List<MBTIDTO> list = mbtiService.getAllMBTI();

		return new ResponseEntity<List<MBTIDTO>>(list, HttpStatus.OK);
	}
}
