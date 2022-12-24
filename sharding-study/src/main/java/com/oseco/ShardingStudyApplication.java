package com.oseco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author panguanghua
 */
@MapperScan("com.oseco.sharding.mapper")
@SpringBootApplication
public class ShardingStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingStudyApplication.class, args);
    }
}