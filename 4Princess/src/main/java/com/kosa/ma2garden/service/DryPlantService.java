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

	public List<DryPlantDTO> getAllDryplants() {

		List<DryPlantDTO> list = new ArrayList<DryPlantDTO>();

		for (DryPlant dryplant : dryplantrepository.findAll()) {
			DryPlantDTO dryplantDTO = new DryPlantDTO(dryplant.getNo(), dryplant.getPlanttName(),
					dryplant.getChartrInfo(), dryplant.getFlwrInfo(), dryplant.getLightInfo(), dryplant.getGrwtInfo(),
					dryplant.getWaterCycleInfo(), dryplant.getBatchPlaceInfo());

			list.add(dryplantDTO);
		}

		return list;
	}
}
