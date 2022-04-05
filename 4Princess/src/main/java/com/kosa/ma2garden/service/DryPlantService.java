package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.DryPlant;
import com.kosa.ma2garden.entity.DryPlantDTO;
import com.kosa.ma2garden.repository.DryPlantRepository;

@Service
public class DryPlantService {
	
	@Autowired
	DryPlantRepository dryplantrepository;

	public List<DryPlantDTO> getAllDryPlant() {
		
		List<DryPlantDTO> list = new ArrayList<DryPlantDTO>();
		
		for (DryPlant dryPlant : dryplantrepository.findAll()) {
			DryPlantDTO dryPlantDTO = DryPlantDTO.builder()
					.no(dryPlant.getNo())
					.plant_name(dryPlant.getPlant_name())
					.chartr_info(dryPlant.getChartr_info())
					.flwr_info(dryPlant.getFlwr_info())
					.light_info(dryPlant.getLight_info())
					.grwt_info(dryPlant.getGrwt_info())
					.water_cycle_info(dryPlant.getWater_cycle_info())
					.batchPlaceInfo(dryPlant.getBatchPlaceInfo())
					.build();
			list.add(dryPlantDTO);
		}
		
		return list;
	}
	
	
}
