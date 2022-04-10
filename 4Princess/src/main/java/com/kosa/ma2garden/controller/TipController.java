package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.TipDTO;
import com.kosa.ma2garden.service.TipService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TipController {
	
	@Autowired
	TipService tipService;
	
	@ApiOperation(value = "Tip", notes = "Tip 관련 정보")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/tip")
	public ResponseEntity<List<TipDTO>> getTip() {
		List<TipDTO> list = tipService.getAllTip();
		
		///123
		
		return new ResponseEntity<List<TipDTO>>(list, HttpStatus.OK);
	}
}
