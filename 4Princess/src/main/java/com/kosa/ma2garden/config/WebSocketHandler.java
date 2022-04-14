package com.kosa.ma2garden.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler{@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload : {}", payload);
		
		TextMessage initialGreeting = new TextMessage("Welcome to Ma2Garden Chat Server!");
		session.sendMessage(initialGreeting);
	}

	
}
