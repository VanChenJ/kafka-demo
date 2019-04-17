package com.test.tiny.route.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * @Author: van0512
 * @Date: 2019/4/16 14:03
 */
@Component
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static Gson gson = new GsonBuilder().create();

    public void sendMessage(Order order) {
        String uuid = UUID.randomUUID().toString();
        ListenableFuture sendResult = kafkaTemplate.send("my-test-topic",1, uuid, gson.toJson(order));
        sendResult.addCallback(s -> System.out.println("send message success"),
                f -> System.out.println("send message failed"));
    }


 }
