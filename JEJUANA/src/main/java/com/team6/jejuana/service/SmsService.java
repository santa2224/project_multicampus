package com.team6.jejuana.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.hc.client5.http.utils.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team6.jejuana.dto.MessageDTO;
import com.team6.jejuana.dto.SmsRequestDTO;
import com.team6.jejuana.dto.SmsResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor 
@Service
public class SmsService {
	
	@Value("a3VMsXObDVx0V08YnFnh")
	private String accessKey;
	
	@Value("BxETzuoEKcq0irnPG1EFSF7FxIh8qmywLeYYQfGm")
	private String secretKey;
	
	@Value("ncp:sms:kr:306707184711:multicampus_team")
	private String serviceId;
 
	@Value("01051186094")
	private String phone;
	
	public String makeSignature(Long time) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		String space = " ";
        String newLine = "\n";
        String method = "POST";
        String url = "/sms/v2/services/"+ this.serviceId+"/messages";
        String timestamp = time.toString();
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;
 
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();
 
        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
 
        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        String encodeBase64String = Base64.encodeBase64String(rawHmac);
 
        return encodeBase64String;
	}
	
	public SmsResponseDTO sendSms(MessageDTO messageDto) throws  JsonProcessingException,RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Long time = System.currentTimeMillis();
		//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(time);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-ncp-apigw-timestamp", time.toString());
		headers.set("x-ncp-iam-access-key", accessKey);
		headers.set("x-ncp-apigw-signature-v2", makeSignature(time));
		
		List<MessageDTO> messages = new ArrayList<>();
		messages.add(messageDto);
		
		SmsRequestDTO request = SmsRequestDTO.builder()
				.type("SMS")
				.contentType("COMM")
				.countryCode("82")
				.from(phone)
				.content(messageDto.getContent())
				.messages(messages)
				.build();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String body = objectMapper.writeValueAsString(request);
		HttpEntity<String> httpBody = new HttpEntity<>(body, headers);
		
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	    SmsResponseDTO response = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/"+ serviceId +"/messages"), httpBody, SmsResponseDTO.class);
  
	    return response;	
	}
}


