package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.MetricCounter;
import com.kosa.ma2garden.dto.NeologismDTO;
import com.kosa.ma2garden.entity.Neologism;
import com.kosa.ma2garden.repository.NeologismRepository;

@Service
public class NeologismService {
	
	@Autowired
	NeologismRepository neologismrepository;
	
	@Autowired
	MetricCounter metricCounter;

	public List<NeologismDTO> getAllNeologism() {

		List<NeologismDTO> list = new ArrayList<NeologismDTO>();
		
		for (Neologism neologism : neologismrepository.findAll()) {
			NeologismDTO neologismDTO = NeologismDTO.builder()
					.no(neologism.getNo())
					.neologism(neologism.getNeologism())
					.meaning(neologism.getMeaning())
					.build();
			list.add(neologismDTO);
		}

		return list;
	}

}
