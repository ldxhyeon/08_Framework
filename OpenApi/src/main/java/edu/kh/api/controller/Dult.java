package edu.kh.api.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dult {
	@GetMapping("air")

	public String airPollution(@RequestParam("cityName") String cityName) throws IOException, URISyntaxException{

		// API 개인 인증키
	
		String serviceKey = "개인 인코딩된 인증키를 작성하세요(문제 원인 X)";
	
		 
	
		String requestUrl = "";
	
		 
	
	
		StringBuilder urlBuilder = new StringBuilder(requestUrl);
	
		urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode(cityName, "UTF-8"));
	
		urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
	
		 
	
		// 공공데이터 요청 및 응답
	
		URI uri = new URI(urlBuilder.toString());
	
		URL url = uri.toURL();
	
		 
	
		 
	
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
		conn.setRequestMethod("GET");
	
		conn.setRequestProperty("Content-type", "application/json");
	
		 
	
		BufferedReader rd;
	
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	
		} else {
	
		rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	
		}
	
		 
	
		StringBuilder sb = new StringBuilder();
	
		String line;
	
		while ((line = rd.readLine()) != null) {
	
		sb.append(line);
	
		}
	
		 
	
		rd.close();
	
		conn.disconnect();
	
		 
	
		// 응답 받은 데이터(JSON)를 로그에 출력
		String response = sb.toString();
		log.debug(response);

	 

	return "air";

	}
}
