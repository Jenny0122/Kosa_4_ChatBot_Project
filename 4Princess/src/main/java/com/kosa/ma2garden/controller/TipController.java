package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.TipDTO;
import com.kosa.ma2garden.service.TipService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TipController {
	
	@Autowired
	TipService tipService;
	
	@GetMapping("/tip")
	public ResponseEntity<List<TipDTO>> getTip() {
		List<TipDTO> list = tipService.getAllTip();
		return new ResponseEntity<List<TipDTO>>(list, HttpStatus.OK);
	}
}
