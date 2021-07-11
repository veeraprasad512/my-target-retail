package com.vpc.rest.api.mytargetretail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class MyTargetRetailConfig {

    private static final Logger log = LoggerFactory.getLogger(MyTargetRetailConfig.class);

    @Value("${restTemplateConnectionTimeout:50000}")
    private int connectionTimeout;

    @Value("${restTemplateReadTimeout:50000}")
    private int readTimeout;

    @Bean
    public RestTemplate restTemplate(){
        return (new RestTemplateBuilder(new RestTemplateCustomizer[0])).setConnectTimeout(Duration.ofMillis((long)this.connectionTimeout)).setReadTimeout(Duration.ofMillis((long)this.readTimeout)).errorHandler(new RestClientErrorHandler()).build();
    }
}
