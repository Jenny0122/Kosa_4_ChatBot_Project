package com.kosa.ma2garden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.FAQDTO;
import com.kosa.ma2garden.service.FAQService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FAQController {
	@Autowired
	FAQService faqService;
	
	@GetMapping("/faq")
	public ResponseEntity<List<FAQDTO>> getFAQ() {
		List<FAQDTO> list = faqService.getAllFAQ();
		list.forEach(System.out::println);
		return new ResponseEntity<List<FAQDTO>>(list, HttpStatus.OK);
	}
}
