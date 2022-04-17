package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.dto.GrowMethodDTO;
import com.kosa.ma2garden.service.GrowMethodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GrowMethodController {
	
	@Autowired
	GrowMethodService growMethodService;
	
	@GetMapping("/growmethod")
	public ResponseEntity<List<GrowMethodDTO>> getGrowMethod() {
		List<GrowMethodDTO> list = growMethodService.getAllGrowMethod();
		return new ResponseEntity<List<GrowMethodDTO>>(list, HttpStatus.OK);
	}
}
