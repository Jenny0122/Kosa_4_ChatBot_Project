package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.NeologismDTO;
import com.kosa.ma2garden.service.NeologismService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class NeologismController {
	@Autowired
	NeologismService neologismService;
	
	@GetMapping("/neologism")
	public ResponseEntity<List<NeologismDTO>> getNeologism() {
		List<NeologismDTO> list = neologismService.getAllNeologism();
		return new ResponseEntity<List<NeologismDTO>>(list, HttpStatus.OK);
	}
}
