package com.example.springboot.kafka;

import com.example.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.json.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        logger.info("Consumed payload: {}", user);
    }
}
