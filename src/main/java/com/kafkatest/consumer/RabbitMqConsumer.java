package com.kafkatest.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    private static final String QUEUE_NAME = "${rabbitmq.queue.name}";

    @RabbitListener(queues = QUEUE_NAME)
    public void consumeMessage(String message) {
        System.out.println("Received message-------------------: " + message);
    }
}
