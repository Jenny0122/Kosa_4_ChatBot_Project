package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.IndoorPlant;
import com.kosa.ma2garden.entity.IndoorPlantDTO;
import com.kosa.ma2garden.service.IndoorPlantService;

@RestController
public class IndoorPlantController {
	
	@Autowired
	IndoorPlantService indoorplantService;

	@GetMapping("/indoor_plants")
	public ResponseEntity<List<IndoorPlantDTO>> getAllIndoorPlants(){
		List<IndoorPlantDTO> list = indoorplantService.getAllIndoorplants();
		
		
		return new ResponseEntity<List<IndoorPlantDTO>>(list, HttpStatus.OK);
	}
}