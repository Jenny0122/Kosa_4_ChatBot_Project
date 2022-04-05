package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Tool;
import com.kosa.ma2garden.entity.ToolDTO;
import com.kosa.ma2garden.repository.ToolRepository;


@Service
public class ToolService {
	
	@Autowired
	ToolRepository toolkRepository;

	public List<ToolDTO> getAllTool() {

		List<ToolDTO> list = new ArrayList<ToolDTO>();

		for (Tool tool : toolkRepository.findAll()) {
			ToolDTO toolDTO = ToolDTO.builder()
					.no(tool.getNo())
					.name(tool.getName())
					.description(tool.getDescription())
					.img_url(tool.getImg_url())
					.build();
			list.add(toolDTO);
			System.out.println(toolDTO);
		}

		return list;
	}
}
