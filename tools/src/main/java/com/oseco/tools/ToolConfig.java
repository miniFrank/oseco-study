package com.oseco.tools;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "tools")
@Data
@Component
@NoArgsConstructor
public class ToolConfig {
    private String key;
}
