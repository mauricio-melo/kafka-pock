package com.mmelo.kafka.service;


import com.mmelo.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class KafkaServiceSender {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(final User user) {
        kafkaTemplate.send("USER_TO_CREATE", user)
                .addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
                    @Override
                    public void onSuccess(SendResult<String, User> result) {
                        System.out.println("Sent message=[" + user.toString());
                    }
                    @Override
                    public void onFailure(Throwable ex) {
                        System.out.println("Unable to send message=[" + user.toString());
                    }
        });
    }


}
