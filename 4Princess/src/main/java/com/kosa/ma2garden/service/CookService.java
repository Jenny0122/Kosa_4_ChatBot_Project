package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.MetricCounter;
import com.kosa.ma2garden.dto.CookDTO;
import com.kosa.ma2garden.entity.Cook;
import com.kosa.ma2garden.repository.CookRepository;

@Service
public class CookService {

	@Autowired
	CookRepository cookRepository;
	
	@Autowired
	MetricCounter metricCounter;

	public List<CookDTO> getAllCook() {

		List<CookDTO> list = new ArrayList<CookDTO>();

		for (Cook cook : cookRepository.findAll()) {
			CookDTO cookDTO = CookDTO.builder()
					.no(cook.getNo())
					.crop(cook.getCrop())
					.menu(cook.getMenu())
					.photo(cook.getPhoto())
					.ingredient(cook.getIngredient())
					.cooking_order(cook.getCooking_order())
					.build();
			
			list.add(cookDTO);
		}

		return list;
	}
}
