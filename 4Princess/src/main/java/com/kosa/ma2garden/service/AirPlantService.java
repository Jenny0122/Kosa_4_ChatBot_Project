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
	
	public List<AirPlantDTO> getAllAirplants(){  
		List<AirPlantDTO> list = new ArrayList<AirPlantDTO>();
		
		for (AirPlant airplant : airplantrepository.findAll()) {
			AirPlantDTO airplantDTO = new AirPlantDTO(
					airplant.getNo(),
					airplant.getName(),
					airplant.getDescription(),
					airplant.getBatchrecomm(),
				    airplant.getManagement()
					);

		    list.add(airplantDTO);
		}

		return list;
	}
}