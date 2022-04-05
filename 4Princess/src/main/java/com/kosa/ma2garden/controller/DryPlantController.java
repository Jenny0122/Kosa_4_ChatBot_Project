package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.DryPlantDTO;
import com.kosa.ma2garden.service.DryPlantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DryPlantController {
	
	@Autowired
	DryPlantService dryPlantService;
	
	@GetMapping("/dryplant")
	public ResponseEntity<List<DryPlantDTO>> getDryPlant() {
		List<DryPlantDTO> list = dryPlantService.getAllDryPlant();
		return new ResponseEntity<List<DryPlantDTO>>(list, HttpStatus.OK);
	}
}
