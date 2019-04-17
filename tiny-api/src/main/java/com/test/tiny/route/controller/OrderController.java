package com.test.tiny.route.controller;

import com.test.bean.Order;
import com.test.tiny.route.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: van0512
 * @Date: 2019/4/16 14:14
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/confirm")
    public void confirmOrder(@RequestBody Order order) {
        orderProducer.sendMessage(order);
    }
}
