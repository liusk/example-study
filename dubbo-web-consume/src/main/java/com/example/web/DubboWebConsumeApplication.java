package com.example.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author liusk
 */

@Slf4j
@EnableDubbo
@SpringBootApplication
public class DubboWebConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboWebConsumeApplication.class, args);
    }

    @Value("${dubbo.registry.address}")
    private String address;

    @Bean
    public RegistryConfig registryConfig() {
        log.info("============== address =============:{}", address);
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://127.0.0.1:8848");
        return registryConfig;
    }
}
