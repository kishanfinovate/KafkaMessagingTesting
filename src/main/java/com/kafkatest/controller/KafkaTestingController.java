package com.kafkatest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkatest.service.KafkaProducerService;

@RestController
public class KafkaTestingController {
	
	@Autowired
	KafkaProducerService kafkaProducerService;
	
	@GetMapping("/ping")
	public String ping(HttpServletRequest request) throws Exception {
		System.out.println("Entry in ping api");
		kafkaProducerService.produceMessageTesting();
		return "Success";
	}

}
