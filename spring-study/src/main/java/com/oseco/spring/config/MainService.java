package com.oseco.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.oseco.tools.ToolConfig;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Service
public class MainService {
    @Resource
    private MainConfig mainConfig;

    @Resource
    private ToolConfig toolConfig;

    @PostConstruct
    private void init() {
        log.info("mainConfig", this.mainConfig);
        log.info("toolConfig", this.toolConfig);
    }
}
