//package com.kosa.ma2garden.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kosa.ma2garden.entity.IntroVideo;
//import com.kosa.ma2garden.entity.IntroVideoDTO;
//import com.kosa.ma2garden.repository.IntroVideoRepository;
//
//@Service
//public class IntroVideoService {
//
//	@Autowired
//	IntroVideoRepository introvideorepository;
//	
//	public List<IntroVideoDTO> getAllIntroVideo() {
//		
//		List<IntroVideoDTO> list = new ArrayList<IntroVideoDTO>();
//		
//		for (IntroVideo introvideo : introvideorepository.findAll()) {
//			IntroVideoDTO introVideoDTO = IntroVideoDTO.builder()
//					.gardening(introvideo.getGardening())
//					.farming(introvideo.getFarming())
//					.build();
//			list.add(introVideoDTO);
//		}
//		
//		return list;
//	}
//
//}
