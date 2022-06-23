package com.example.web;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author liusk
 */
@EnableDubbo
@DubboComponentScan("com.example.service.**")
@SpringBootApplication
public class DubboWebOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboWebOrderProviderApplication.class, args);
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://127.0.0.1:8848");
        return registryConfig;
    }
}
