package com.test.tiny.route.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: van0512
 * @Date: 2019/4/16 14:43
 */

@Component
public class OrderConsumer {

    @KafkaListener(topics = "my-test-topic", groupId = "test-group")
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("---->"+record);
            System.out.println("---->"+message);
        }

    }
}
