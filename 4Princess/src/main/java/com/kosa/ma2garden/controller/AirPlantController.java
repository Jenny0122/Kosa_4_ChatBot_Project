package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.AirPlantDTO;
import com.kosa.ma2garden.service.AirPlantService;

@RestController
public class AirPlantController {

	@Autowired
	AirPlantService airplantService;

	@GetMapping("/air_plants")
	public ResponseEntity<List<AirPlantDTO>> getAllAirPlants() {
		List<AirPlantDTO> list = airplantService.getAllAirplants();

		return new ResponseEntity<List<AirPlantDTO>>(list, HttpStatus.OK);
	}
}
