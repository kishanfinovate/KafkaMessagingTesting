package com.kafkatest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
	
	
	public void produceMessageTesting() {
		logger.info("Entry in produceMessageTesting");
		for(int i=0; i<=100 ; i++) {
			kafkaTemplate.send(com.kafkatest.constant.KafkaConstant.TEST_TOPIC, "i :"+i);
		}
		logger.info("Exit from produceMessageTesting");
	}
	
}
