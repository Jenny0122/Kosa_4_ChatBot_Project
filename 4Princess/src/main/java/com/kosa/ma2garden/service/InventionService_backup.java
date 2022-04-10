package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Invention_backup;
import com.kosa.ma2garden.entity.InventionDTO_backup;
import com.kosa.ma2garden.repository.InventionRepository_backup;

@Service
public class InventionService_backup {
	@Autowired
	InventionRepository_backup inventionrepository;

	public List<InventionDTO_backup> getAllInvention() {

		List<InventionDTO_backup> list = new ArrayList<InventionDTO_backup>();
		
		for (Invention_backup invention : inventionrepository.findAll()) {
			InventionDTO_backup inventionDTO = InventionDTO_backup.builder()
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
