package com.kosa.ma2garden.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ma2garden.service.ChatBotService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ChatBotController {
	
	@Autowired
	ChatBotService chatBotService;
	
	@PostMapping("chatbot")
	public Map<String, String> getAnswer(@RequestBody String chatBot) throws InterruptedException, IOException{
		String answer = "{\"answer\":\"";
		answer += chatBotService.getAnswer(chatBot);
		answer += "\"}";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Map<String, String> map = mapper.readValue(answer, Map.class);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
