package com.mmelo.kafka;

import com.mmelo.kafka.domain.User;
import com.mmelo.kafka.service.KafkaServiceSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaApplicationTests {

	@Autowired
	private KafkaServiceSender kafkaServiceSender;

	@Test
	void contextLoads() {
		kafkaServiceSender.sendMessage(User.builder().name("Mauricio").lastName("55").build());
	}

}
