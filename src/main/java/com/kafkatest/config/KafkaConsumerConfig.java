package com.kafkatest.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafkatest.constant.KafkaConstant;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	// Consumer with Single Threading
	/*
	@Bean
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_LOCAL_SERVER_CONFIG);
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID_STRING);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		configMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "50");
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(true);
        factory.setBatchErrorHandler(new BatchLoggingErrorHandler());
		return factory;
	}
	*/
	
	// Consumer with multithreading
	
	@Bean
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_LOCAL_SERVER_CONFIG);
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID_STRING);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		
		configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		configMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
		factory.setConsumerFactory(consumerFactory());
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
	}
	
}