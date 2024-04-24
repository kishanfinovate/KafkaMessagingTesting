// package com.kafkatest.service;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.stereotype.Component;

// import com.kafkatest.constant.KafkaConstant;

// @Component
// public class KafkaConsumerService {
	
// 	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
	
// 	/*
// 	@KafkaListener(groupId = KafkaConstant.GROUP_ID_STRING,
// 			topics = KafkaConstant.TEST_TOPIC)
// 	public void receive(@Payload List<String> messages,
// 			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
// 			@Header(KafkaHeaders.OFFSET) List<Long> offsets) {

// 		for (int i = 0; i < messages.size(); i++) {
// 			logger.info("Received message='{}' with partition-offset='{}'", messages.get(i),
// 					partitions.get(i) + "-" + offsets.get(i));
// 		}
// 		logger.info("All batch messages received");
// 	}
// 	*/
	
// 	@KafkaListener(topics=KafkaConstant.TEST_TOPIC, concurrency = "2",
// 			groupId = KafkaConstant.GROUP_ID_STRING) 
// 	public void emailSubscribeTopicListner(String message) {
// 		logger.info("TEST_TOPIC Received message={}", message);
// 	}
	 

// }
