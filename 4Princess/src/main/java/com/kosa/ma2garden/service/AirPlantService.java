package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.AirPlant;
import com.kosa.ma2garden.entity.AirPlantDTO;
import com.kosa.ma2garden.repository.AirPlantRepository;

@Service
public class AirPlantService {
	@Autowired
	AirPlantRepository airplantrepository;

	public List<AirPlantDTO> getAllAirPlant() {
		
		List<AirPlantDTO> list = new ArrayList<AirPlantDTO>();
		
		for (AirPlant airPlant : airplantrepository.findAll()) {
			AirPlantDTO airPlantDTO = AirPlantDTO.builder()
					.no(airPlant.getNo())
					.name(airPlant.getName())
					.description(airPlant.getDescription())
					.batchrecomm(airPlant.getBatchrecomm())
					.management(airPlant.getManagement())
					.build();
			list.add(airPlantDTO);
		}
		return list;
	}
}
