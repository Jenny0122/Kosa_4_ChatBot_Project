//package com.kosa.ma2garden.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kosa.ma2garden.entity.IntroVideoDTO;
//import com.kosa.ma2garden.service.IntroVideoService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//public class IntroVideoController {
//	
//	@Autowired
//	IntroVideoService introVideoService;
//	
//	@GetMapping("/introvideo")
//	public ResponseEntity<List<IntroVideoDTO>> getIntroVideo() {
//		List<IntroVideoDTO> list = introVideoService.getAllIntroVideo();
//		return new ResponseEntity<List<IntroVideoDTO>>(list, HttpStatus.OK);
//	}
//}
