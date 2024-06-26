// package com.kafkatest.config;

// import java.util.HashMap;
// import java.util.Map;

// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.core.ProducerFactory;
// import org.springframework.kafka.support.serializer.JsonSerializer;

// import com.kafkatest.constant.KafkaConstant;

// @Configuration
// @EnableKafka
// public class KafkaProducerConfig {
	

// 	@Bean
// 	public ProducerFactory<String, Object> producerFactory() {
// 		Map<String, Object> configMap = new HashMap<>();
// 		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_LOCAL_SERVER_CONFIG);
// 		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
// 		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
// 		return new DefaultKafkaProducerFactory<String, Object>(configMap);
// 	}
	
// 	@Bean
// 	public KafkaTemplate<String, Object> kafkaTemplate() {
// 		return new KafkaTemplate<>(producerFactory());
// 	}
	
// }