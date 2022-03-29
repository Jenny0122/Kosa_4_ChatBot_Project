package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.InsidePlant;
import com.kosa.ma2garden.entity.InsidePlantDTO;
import com.kosa.ma2garden.repository.InsidePlantRepository;

@Service
public class InsidePlantService {
	
	@Autowired
	InsidePlantRepository insideplantrepository;

	public List<InsidePlantDTO> getAllInsidePlant() {
		
		List<InsidePlantDTO> list = new ArrayList<InsidePlantDTO>();
		
		for (InsidePlant insidePlant : insideplantrepository.findAll()) {
			InsidePlantDTO insidePlantDTO = InsidePlantDTO.builder()
					.no(insidePlant.getNo())
					.plant_name(insidePlant.getPlant_name())
					.lef_stle_info(insidePlant.getLef_stle_info())
					.prpgt_era_info(insidePlant.getPrpgt_era_info())
					.frtlzr_info(insidePlant.getFrtlzr_info())
					.soil_info(insidePlant.getSoil_info())
					.fnclty_info(insidePlant.getFnclty_info())
					.build();
			list.add(insidePlantDTO);
		}
		return list;
	}
	
	
}
