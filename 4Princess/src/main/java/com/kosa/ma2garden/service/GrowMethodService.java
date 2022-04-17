package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.dto.GrowMethodDTO;
import com.kosa.ma2garden.entity.GrowMethod;
import com.kosa.ma2garden.repository.GrowMethodRepository;

@Service
public class GrowMethodService {
	
	@Autowired
	GrowMethodRepository growmethodrepository;

	public List<GrowMethodDTO> getAllGrowMethod() {
		
		List<GrowMethodDTO> list = new ArrayList<GrowMethodDTO>();
		
		for (GrowMethod growmethod : growmethodrepository.findByNoLessThan(51)) {
			GrowMethodDTO growMethodDTO = GrowMethodDTO.builder()
					.no(growmethod.getNo())
					.name(growmethod.getName())
					.kind(growmethod.getKind())
					.nutrient(growmethod.getNutrient())
					.growing_season(growmethod.getGrowing_season())
					.eat(growmethod.getEat())
					.level(growmethod.getLevel())
					.sunlight(growmethod.getSunlight())
					.grow_temperature(growmethod.getGrow_temperature())
					.flowerpot_size(growmethod.getFlowerpot_size())
					.pest(growmethod.getPest())
					.term(growmethod.getTerm())
					.infomation(growmethod.getInfomation())
					.feature(growmethod.getFeature())
					.materials(growmethod.getMaterials())
					.cultivation_process(growmethod.getCultivation_process())
					.img_url(growmethod.getImg_url())
					.build();
			list.add(growMethodDTO);
		}
		
		return list;
	}


}
