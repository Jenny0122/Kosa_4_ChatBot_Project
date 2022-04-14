package com.kosa.ma2garden.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

	@Value("${python.commander")
	String command;

	@Value("${python.api")
	String api;

	public String getAnswer(String query) throws InterruptedException, IOException {

		ProcessBuilder builder = new ProcessBuilder(command, api, query);
		Process process = builder.start();
		int exitVal = process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));

		String line;
		String answer = "";

		while ((line = br.readLine()) != null) {
			answer += line;
		}

		if (exitVal != 0) {
			return null;
		} else {
			return answer;
		}
	}
}
