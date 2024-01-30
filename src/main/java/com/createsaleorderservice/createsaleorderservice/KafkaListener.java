package com.createsaleorderservice.createsaleorderservice;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "kafkatopic", groupId = "groupId")
    void listener(String message) {
        System.out.println(message);
    }
    
}
