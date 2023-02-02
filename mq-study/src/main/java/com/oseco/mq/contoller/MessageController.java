package com.oseco.mq.contoller;

import com.oseco.mq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panguanghua
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public void createOrder() {
        orderService.createOrder();
    }
}
