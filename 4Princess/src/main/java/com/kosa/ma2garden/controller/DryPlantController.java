package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.DryPlantDTO;
import com.kosa.ma2garden.service.DryPlantService;

@RestController
public class DryPlantController {

	@Autowired
	DryPlantService dryplantService;

	@GetMapping("/dry_plants")
	public ResponseEntity<List<DryPlantDTO>> getAllDryPlants() { // this
		List<DryPlantDTO> list = dryplantService.getAllDryplants();

		System.out.println("/dry_plants");

		return new ResponseEntity<List<DryPlantDTO>>(list, HttpStatus.OK);
	}
}
