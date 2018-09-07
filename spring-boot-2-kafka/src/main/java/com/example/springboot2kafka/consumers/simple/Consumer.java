package com.example.springboot2kafka.consumers.simple;

import static com.example.springboot2kafka.config.Topics.TOPIC_STRING;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = TOPIC_STRING)
    public void stringMessage(@Payload String message) {

        LOG.info("received message='{}'", message);
    }
}
