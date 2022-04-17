package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.dto.TipDTO;
import com.kosa.ma2garden.entity.Tip;
import com.kosa.ma2garden.repository.TipRepository;

@Service
public class TipService {

	@Autowired
	TipRepository tiprepository;
	
	public List<TipDTO> getAllTip() {
		
		List<TipDTO> list = new ArrayList<TipDTO>();
		
		for (Tip tip : tiprepository.findAll()) {
			TipDTO tipDTO = TipDTO.builder()
					.no(tip.getNo())
					.title(tip.getTitle())
					.content(tip.getContent())
					.build();
			list.add(tipDTO);
		}
		
		return list;
	}

}
