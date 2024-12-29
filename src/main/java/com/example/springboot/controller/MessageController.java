package com.example.springboot.controller;

import com.example.springboot.payload.User;
import com.example.springboot.kafka.JsonKafkaProducer;
import com.example.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody String message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.send(user);
        return ResponseEntity.ok("Message sent successfully");
    }
}
