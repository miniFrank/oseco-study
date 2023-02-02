package com.oseco.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Service;

/**
 * @author panguanghua
 */
@Slf4j
@Service
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}",
        topic = "${mq.topic.logistics-topic}",
        consumerGroup = "mq-study")
public class OrderDeliveryConsumer implements RocketMQReplyListener<String, String> {
    @Override
    public String onMessage(String message) {
        log.info("receive message {}", message);

        return "ok";
    }
}
