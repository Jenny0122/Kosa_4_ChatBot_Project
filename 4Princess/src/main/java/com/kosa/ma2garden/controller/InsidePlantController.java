package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.InsidePlantDTO;
import com.kosa.ma2garden.service.InsidePlantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InsidePlantController {
	
	@Autowired
	InsidePlantService insidePlantService;
	
	@GetMapping("/insideplant")
	public ResponseEntity<List<InsidePlantDTO>> getInsidePlant() {
		List<InsidePlantDTO> list = insidePlantService.getAllInsidePlant();
		return new ResponseEntity<List<InsidePlantDTO>>(list, HttpStatus.OK);
	}
}
