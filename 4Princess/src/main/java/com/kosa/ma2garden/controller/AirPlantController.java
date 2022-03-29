package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.AirPlantDTO;
import com.kosa.ma2garden.service.AirPlantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AirPlantController {
	
	@Autowired
	AirPlantService airPlantService;
	
	@GetMapping("airplant")
	public ResponseEntity<List<AirPlantDTO>> getAirPlant() {
		List<AirPlantDTO> list = airPlantService.getAllAirPlant();
		return new ResponseEntity<List<AirPlantDTO>>(list, HttpStatus.OK);
	}
}
