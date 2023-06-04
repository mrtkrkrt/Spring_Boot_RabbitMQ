package com.mrtkrkrt.rabbitmq.controller;

import com.mrtkrkrt.rabbitmq.dto.User;
import com.mrtkrkrt.rabbitmq.publisher.RabbitMQJsonProducer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rabbitmq/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer producer;

    public MessageJsonController(RabbitMQJsonProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMq...");
    }
}
