package com.oseco.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author panguanghua
 */
@Slf4j
@Service
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}",
        topic = "${mq.topic.printable-receipt-topic}",
        consumerGroup = "mq-study")
public class PrintOrderlyConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("receive orderly message {}", message);
    }
}
