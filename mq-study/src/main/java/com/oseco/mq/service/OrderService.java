package com.oseco.mq.service;

import com.oseco.mq.config.MqTopicConfig;
import com.oseco.mq.domain.Logistics;
import com.oseco.mq.domain.Pay;
import com.oseco.mq.domain.PrintableReceipt;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author panguanghua
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private MqTopicConfig mqTopicConfig;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void createOrder() {
        String orderNo = UUID.randomUUID().toString().replaceAll("-", "");
        BigDecimal orderAmount = BigDecimal.valueOf(2400);

        Logistics logistics =
                Logistics.builder()
                        .orderNo(orderNo)
                        .deliveryVendor("EMS")
                        .weight(BigDecimal.valueOf(12.01))
                        .deliveryAmount(BigDecimal.valueOf(1200))
                        .build();
        Pay pay =
                Pay.builder()
                        .orderNo(orderNo)
                        .channel("alipay")
                        .payAmount(orderAmount)
                        .build();

        PrintableReceipt printableReceipt =
                PrintableReceipt.builder()
                        .orderNo(orderNo)
                        .orderAmount(orderAmount)
                        .build();

        String printableReceiptTopic = mqTopicConfig.getPrintableReceiptTopic();
        String logisticsTopic = mqTopicConfig.getLogisticsTopic();
        String payTopic = mqTopicConfig.getPayTopic();
        org.springframework.kafka.support.SendResult<Object, Object> sendResult;
        try {
            CompletableFuture<org.springframework.kafka.support.SendResult<Object, Object>>
                    printableReceiptFuture = kafkaTemplate.send(printableReceiptTopic, printableReceipt);
            sendResult = printableReceiptFuture.get();
            log.info("get KAFKA result {} of topic {}", sendResult, printableReceiptTopic);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        rocketMQTemplate.asyncSend(printableReceiptTopic,
                MessageBuilder.withPayload(printableReceipt), new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        log.info("get ROCKETMQ result {} of topic {}", sendResult, printableReceiptTopic);
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.error("get ROCKETMQ exception {} of topic {}", e, printableReceiptTopic);
                    }
                });


        try {
            CompletableFuture<org.springframework.kafka.support.SendResult<Object, Object>>
                    payFuture = kafkaTemplate.send(payTopic, pay);
            sendResult = payFuture.get();
            log.info("get KAFKA result {} of topic {}", sendResult, payTopic);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        SendResult rocketMQSendResult = rocketMQTemplate
                .syncSend(payTopic, MessageBuilder.withPayload(pay).build());
        log.info("get ROCKETMQ result {} of topic {}", rocketMQSendResult, payTopic);

        try {
            CompletableFuture<org.springframework.kafka.support.SendResult<Object, Object>>
                    logisticsFuture = kafkaTemplate.send(logisticsTopic, logistics);
            sendResult = logisticsFuture.get();
            log.info("get KAFKA result {} of topic {}", sendResult, logisticsTopic);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        rocketMQTemplate.sendAndReceive(logisticsTopic, logistics, new RocketMQLocalRequestCallback() {
            @Override
            public void onSuccess(Object message) {
                log.info("get ROCKETMQ result {} of topic {}", message, logisticsTopic);
            }

            @Override
            public void onException(Throwable e) {
                log.error("get ROCKETMQ exception {} of topic {}", e, logisticsTopic);
            }
        });
    }

    public void sendSyncMessage() {
        // 同步投递消息，不需要consumer进行回复
        SendResult sendResult = rocketMQTemplate.syncSend("",
                "[sync-test-topic]hello world1");
        log.info("get sync send result {}", sendResult);
        // 异步投递消息
        rocketMQTemplate.asyncSend("",
                MessageBuilder.withPayload("[sync-test-topic]async-reply-topic").build(), new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        log.info("get async send result {}", sendResult);
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.error("get error message {}", e.getMessage());
                        e.printStackTrace();
                    }
                });
        // 发送回复消息
        String replyString = rocketMQTemplate.sendAndReceive("",
                MessageBuilder.withPayload("reply-topic").build(),
                String.class);
        log.info("get reply string {}", replyString);
    }

    public void sendOrderlyMessage() throws InterruptedException {
        this.testSendBatchMessageOrderly();
    }

    private void testSendBatchMessageOrderly() throws InterruptedException {
        for (int q = 0; q < 1; q++) {
            // send to 4 queues
            List<Message> msgs = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int msgIndex = q * 10 + i;
                String msg = String.format("Hello RocketMQ Batch Msg#%d to queue: %d", msgIndex, q);
                msgs.add(MessageBuilder.withPayload(msg).
                        setHeader(RocketMQHeaders.KEYS, "KEY_" + msgIndex).build());
            }
            SendResult sr = rocketMQTemplate.syncSendOrderly("", msgs, q + "", 60000);
            System.out.println("--- Batch messages orderly to queue :" + sr.getMessageQueue().getQueueId() + " send result :" + sr);
            TimeUnit.SECONDS.sleep(10);
        }
    }
}
