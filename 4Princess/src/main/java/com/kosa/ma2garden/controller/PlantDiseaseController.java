package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.dto.PlantDiseaseDTO;
import com.kosa.ma2garden.service.PlantDiseaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PlantDiseaseController {

	@Autowired
	PlantDiseaseService plantDiseaseService;

	@GetMapping("/plantdisease")
	public ResponseEntity<List<PlantDiseaseDTO>> getPlantDisease() {
		List<PlantDiseaseDTO> list = plantDiseaseService.getAllPlantDisease();
		return new ResponseEntity<List<PlantDiseaseDTO>>(list, HttpStatus.OK);
	}
}
