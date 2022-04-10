package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.InventionDTO;
import com.kosa.ma2garden.service.InventionService;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
public class InventionController {
	@Autowired
	InventionService inventionService;
	
	@GetMapping("/invention")
	public ResponseEntity<List<InventionDTO>> getInvention() {
		List<InventionDTO> list = inventionService.getAllInvention();
		list.forEach(System.out::println);
		return new ResponseEntity<List<InventionDTO>>(list, HttpStatus.OK);
	}	
}
