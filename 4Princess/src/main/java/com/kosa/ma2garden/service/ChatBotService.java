package com.kosa.ma2garden.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

	public String getAnswer(String query) throws InterruptedException, IOException {
		String command = "/Users/easy/anaconda3/envs/md/bin/python";
		String arg1 = "/Users/easy/wisenut/4princess/chatbotAPI/ChatBotAPI.py";

		ProcessBuilder builder = new ProcessBuilder(command, arg1, query);
		Process process = builder.start();
		int exitVal = process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));

		String line;
		String answer = "{\"answer\":\"";

		while ((line = br.readLine()) != null) {
			answer += line;
		}

		if (exitVal != 0) {
			return null;
		} else {
			answer += "\"}";
			return answer;
		}
	}
}
