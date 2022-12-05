package com.oseco.spring.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@ConditionalOnProperty(prefix = "main")
@ConfigurationProperties(prefix = "main")
@Data
@Component
@NoArgsConstructor
public class MainConfig {
    private String tool;
}
