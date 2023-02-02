package com.oseco.mq.config;

import com.oseco.mq.domain.Logistics;
import com.oseco.mq.domain.Pay;
import com.oseco.mq.domain.PrintableReceipt;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panguanghua
 */
@Configuration
@EnableAutoConfiguration
public class KafkaConfig {

    @Bean
    public NewTopic logistics() {
        return new NewTopic("logistics", 1, (short) 1);
    }

    @Bean
    public NewTopic pay() {
        return new NewTopic("pay", 1, (short) 1);
    }

    @Bean
    public NewTopic printableReceipt() {
        return new NewTopic("printableReceipt", 1, (short) 1);
    }

    @Bean
    public RecordMessageConverter converter() {
        JsonMessageConverter converter = new JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("com.oseco.mq.domain");
        Map<String, Class<?>> mappings = new HashMap<>();
        mappings.put("logistics", Logistics.class);
        mappings.put("pay", Pay.class);
        mappings.put("printableReceipt", PrintableReceipt.class);
        typeMapper.setIdClassMapping(mappings);
        converter.setTypeMapper(typeMapper);
        return converter;
    }

    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<Object, Object> kafkaOperations) {
        return new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(kafkaOperations),
                new FixedBackOff(1000L, 2));
    }
}
