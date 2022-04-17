package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.dto.IndoorPlantDTO;
import com.kosa.ma2garden.entity.IndoorPlant;
import com.kosa.ma2garden.repository.IndoorPlantRepository;



@Service
public class IndoorPlantService {

	
	@Autowired
	IndoorPlantRepository indoorplantrepository;
	
	public List<IndoorPlantDTO> getAllIndoorplants(){  
		
		
		List<IndoorPlantDTO> list = new ArrayList<IndoorPlantDTO>();
		
		for (IndoorPlant indoorplant : indoorplantrepository.findAll()) {
			IndoorPlantDTO indoorplantDTO = new IndoorPlantDTO(
					indoorplant.getNo(),
					indoorplant.getName(),
					indoorplant.getLef_stle_info(),
					indoorplant.getPrpgt_era_info(),
					indoorplant.getFrtlzr_info(),
					indoorplant.getSoil_info(),
					indoorplant.getFnclty_info()
					);

		    list.add(indoorplantDTO);
		}

		return list;
	}
}