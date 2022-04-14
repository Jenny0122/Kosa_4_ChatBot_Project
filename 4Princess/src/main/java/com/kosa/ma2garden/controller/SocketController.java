package com.kosa.ma2garden.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.kosa.ma2garden.entity.SocketVO;
import com.kosa.ma2garden.service.ChatBotService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SocketController {

	@Autowired
	ChatBotService chatBotService;

	// /receive를 메시지를 받을 endpoint로 설정합니다.
	@MessageMapping("/receive")

	// /send로 메시지를 반환합니다.
	@SendTo("/send")
	// SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
	// 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
	public String SocketHandler(SocketVO socketVO) {
		// vo에서 getter로 userName을 가져옵니다.
		String userName = socketVO.getUserName();
		// vo에서 setter로 content를 가져옵니다.
		String content = socketVO.getContent();

		log.info("질문 : " + content);

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