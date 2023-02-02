package com.oseco.mq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author panguanghua
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mq.topic")
public class MqTopicConfig {
    private String payTopic;
    private String logisticsTopic;
    private String printableReceiptTopic;
}
