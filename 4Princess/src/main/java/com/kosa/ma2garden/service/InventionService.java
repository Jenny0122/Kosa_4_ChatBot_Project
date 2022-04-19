package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.MetricCounter;
import com.kosa.ma2garden.dto.InventionDTO;
import com.kosa.ma2garden.entity.Invention;
import com.kosa.ma2garden.repository.InventionRepository;

@Service
public class InventionService {
	
	@Autowired
	InventionRepository inventionrepository;
	
	@Autowired
	MetricCounter metricCounter;

	public List<InventionDTO> getAllInvention() {

		List<InventionDTO> list = new ArrayList<InventionDTO>();

		for (Invention invention : inventionrepository.findAll()) {
			InventionDTO inventionDTO = InventionDTO.builder()
					.no(invention.getNo())
					.idea(invention.getIdea())
					.prize(invention.getPrize())
					.prized_year(invention.getPrized_year())
					.description(invention.getDescription())
					.photo(invention.getPhoto())
					.url(invention.getUrl())
					.build();
			list.add(inventionDTO);
		}

		return list;
	}

}
