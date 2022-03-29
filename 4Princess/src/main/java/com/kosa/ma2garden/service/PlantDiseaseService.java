package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.PlantDisease;
import com.kosa.ma2garden.entity.PlantDiseaseDTO;
import com.kosa.ma2garden.repository.PlantDiseaseRepository;

@Service
public class PlantDiseaseService {
	
	@Autowired
	PlantDiseaseRepository plantdiseaserepository;
	
	public List<PlantDiseaseDTO> getAllPlantDisease() {
		
		List<PlantDiseaseDTO> list = new ArrayList<PlantDiseaseDTO>();
		
		for (PlantDisease plantDisease : plantdiseaserepository.findAll()) {
			PlantDiseaseDTO plantDiseaseDTO = PlantDiseaseDTO.builder()
					.no(plantDisease.getNo())
					.crop_name(plantDisease.getCrop_name())
					.sick_name_kor(plantDisease.getSick_name_kor())
					.symptoms(plantDisease.getSymptoms())
					.prevention_method(plantDisease.getPrevention_method())
					.ori_img(plantDisease.getOri_img())
					.build();
				list.add(plantDiseaseDTO);
		}
		
		return list;
	}

}
