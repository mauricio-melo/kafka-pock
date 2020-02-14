package com.mmelo.kafka.service;

import com.mmelo.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceReceiver {

    @KafkaListener(topics = "USER_TO_CREATE", containerFactory = "kafkaListenerContainerFactory")
    public void receive(final User user) {
        System.out.println("Received Message in group: " + user.toString());
    }
}
