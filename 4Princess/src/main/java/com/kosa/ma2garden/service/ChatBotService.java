package com.kosa.ma2garden.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatBotService {

	public String getAnswer(String query) throws InterruptedException, IOException {
		String command = "C:\\Users\\asj44\\.conda\\envs\\lab\\python";
		String arg1 = "C:\\Users\\asj44\\Desktop\\chatbotAPI\\chatbotAPI\\ChatBotAPI.py";
		
		System.out.println(new File(command).exists());
		System.out.println(new File(arg1).exists());

		ProcessBuilder builder = new ProcessBuilder(command, arg1, query);
		Process process = builder.start();
		int exitVal = process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));

		String line;
		String answer = "";

		while ((line = br.readLine()) != null) {
			answer += line;
		}
		log.info("답변 : " + answer);

		if (exitVal != 0) {
			return null;
		} else {
			return answer;
		}
	}
}
