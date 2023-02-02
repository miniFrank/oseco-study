package com.oseco.mq;

import com.oseco.mq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSendSyncMessage() {
        orderService.sendSyncMessage();
    }

    @Test
    public void testSendOrderlyMessage() throws InterruptedException {
        orderService.sendOrderlyMessage();
    }
}
