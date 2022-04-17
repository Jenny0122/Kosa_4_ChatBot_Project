package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.dto.FAQDTO;
import com.kosa.ma2garden.entity.FAQ;
import com.kosa.ma2garden.repository.FAQRepository;

@Service
public class FAQService {
	@Autowired
	FAQRepository faqrepository;

	public List<FAQDTO> getAllFAQ() {

		List<FAQDTO> list = new ArrayList<FAQDTO>();

		for (FAQ faq : faqrepository.findAll()) {
			FAQDTO faqDTO = FAQDTO.builder()
					.no(faq.getNo())
					.question(faq.getQuestion())
					.answer(faq.getAnswer())
					.build();
			list.add(faqDTO);
		}

		return list;
	}

}
