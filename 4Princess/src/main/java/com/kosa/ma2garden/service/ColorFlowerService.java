package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.dto.ColorFlowerDTO;
import com.kosa.ma2garden.entity.ColorFlower;
import com.kosa.ma2garden.repository.ColorFlowerRepository;

@Service
public class ColorFlowerService {
	
	@Autowired
	ColorFlowerRepository colorflowerRepository;

	public List<ColorFlowerDTO> getAllColorFlower() {

		List<ColorFlowerDTO> list =  new ArrayList<ColorFlowerDTO>();
		for (ColorFlower colorflower : colorflowerRepository.findAll()) {
			ColorFlowerDTO colorflowerDTO = ColorFlowerDTO.builder()
					.no(colorflower.getNo())
					.color_info(colorflower.getColor_info())
					.color_eng_name(colorflower.getColor_eng_name())
					.effect_info(colorflower.getEffect_info())
					.space_info(colorflower.getSpace_info())
					.img_url(colorflower.getImg_url())
					.build();

			list.add(colorflowerDTO);
		}

		return list;
	}

}
