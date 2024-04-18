package com.kafkatest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.kafkatest.constant.KafkaConstant;

@Configuration
public class KafkaTopicConfig {

	
	/*@Bean
	public NewTopic topic1() {
		return TopicBuilder.name(KafkaConstant.EA_SUCCESSFUL_REGISTRATION_TOPIC).partitions(2).replicas(1).build();
	}*/
	
	/*@Bean
	public NewTopic topic2() {
		return TopicBuilder.name(KafkaConstant.EA_POSITION_UPDATE_TOPIC).partitions(2).replicas(1).build();
	}*/
	
	@Bean
	public NewTopic topic3() {
		return TopicBuilder.name(KafkaConstant.TEST_TOPIC).partitions(2).replicas(1).build();
	}
	
}