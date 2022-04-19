package com.kosa.ma2garden.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.kosa.ma2garden.dto.SocketVO;
import com.kosa.ma2garden.service.ChatBotService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatBotController {

	@Autowired
	ChatBotService chatBotService;

	// /receive를 메시지를 받을 endpoint로 설정합니다.
	@MessageMapping("/receive/{id}")
	// /send로 메시지를 반환합니다.
	@SendTo("/send/{id}")
	// SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
	public String SocketHandler(SocketVO socketVO) {

		String userName = socketVO.getUserName();
		String content = socketVO.getContent();

		log.info("질문 : " + content);
		// log.info("id : " + id);

		String answer = "";
		try {
			answer = chatBotService.getAnswer(content);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 반환
		return answer;
	}
}