package com.kafkatest.controller;

// import javax.servlet.http.HttpServletRequest;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkatest.producer.RabbitMqProducer;
// import com.kafkatest.service.KafkaProducerService;

@RestController
public class KafkaTestingController {
	
	// @Autowired
	// KafkaProducerService kafkaProducerService;
	
	private RabbitMqProducer producer;

    public KafkaTestingController(RabbitMqProducer producer){
        this.producer=producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		System.out.println(message+"----------------------");
        producer.sendMessage(message);
        return ResponseEntity.ok("Message send to RabbitMq ...");
    }

	// @GetMapping("/ping")
	// public String ping(HttpServletRequest request) throws Exception {
	// 	System.out.println("Entry in ping api");
	// 	kafkaProducerService.produceMessageTesting();
	// 	return "Success";
	// }

}
