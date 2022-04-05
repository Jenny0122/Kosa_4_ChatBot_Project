package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.MBTI;
import com.kosa.ma2garden.entity.MBTIDTO;
import com.kosa.ma2garden.repository.MBTIRepository;


@Service
public class MBTIService {

	@Autowired
	MBTIRepository mbtiRepository;

	public List<MBTIDTO> getAllMBTI() {

		List<MBTIDTO> list = new ArrayList<MBTIDTO>();
		
		for (MBTI mbti : mbtiRepository.findAll()) {
			MBTIDTO mbtiDTO = MBTIDTO.builder()
					.no(mbti.getNo())
					.mbti(mbti.getMbti())
					.flower_name(mbti.getFlower_name())
					.description(mbti.getDescription())
					.image_url(mbti.getImage_url())
					.build();
			list.add(mbtiDTO);
		}

		return list;
	}
}
