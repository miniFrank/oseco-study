package com.oseco.mq.consumer;

import com.oseco.mq.domain.Logistics;
import com.oseco.mq.domain.Pay;
import com.oseco.mq.domain.PrintableReceipt;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author panguanghua
 */
@Component
@KafkaListener(id = "consumerGroup", topics =
        {"pay-topic", "logistics-topic", "printable-receipt-topic"})
public class KafkaConsumerGroup {
    @KafkaHandler
    public String payHandler(Pay pay) {
        System.out.println("Received: " + pay);
        return "ok";
    }

    @KafkaHandler
    public String logisticsHandler(Logistics logistics) {
        System.out.println("Received: " + logistics);

        return "ok";
    }

    @KafkaHandler
    public void printableReceiptHandler(PrintableReceipt printableReceipt) {
        System.out.println("Received: " + printableReceipt);
    }
}
