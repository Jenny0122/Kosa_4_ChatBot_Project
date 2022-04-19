package com.kosa.ma2garden.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.MetricCounter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatBotService {

	@Value("${python.commander}")
	String command;

	@Value("${python.api1}")
	String api1;

	@Value("${python.api2}")
	String api2;
	
	@Autowired
	MetricCounter metricCounter;

	public String getAnswer(String query) throws InterruptedException, IOException {

		int exitVal = 0;
		String answer = "";
		String api = "";
		String flag = "(btn)";
		ProcessBuilder builder = null;

		if (!query.contains(flag)) {
			api = api1;
			query = "\"" + query.trim() + "\"";
		} else {
			api = api2;
			query = query.trim();
		}
		builder = new ProcessBuilder(command, api, query);

		Process process = builder.start();
		exitVal = process.waitFor();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));

		String line;

		while ((line = br.readLine()) != null)
			answer += line;

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
