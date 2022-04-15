package com.kosa.ma2garden.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatBotService {

	@Value("${python.commander}")
	String command;

	@Value("${python.api}")
	String api;

	public String getAnswer(String query) throws InterruptedException, IOException {

		log.info("command : {}", command);
		log.info("api : {}", api);

		query = "\"" + query + "\"";
		ProcessBuilder builder = new ProcessBuilder(command, api, query);
		Process process = builder.start();
		int exitVal = process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));

		String line;
		String answer = "";

		while ((line = br.readLine()) != null) {
			answer += line;
		}
		log.info("exitVal : {}", exitVal);
		System.out.println("답변 : " + answer);
		if (exitVal != 0) {
			return null;
		} else { // exitVal == 0
			if (answer.trim()
					.contentEquals("")) {
				answer = "답변을 찾지 못했습니다";
			}
			return answer;
		}
	}
}
