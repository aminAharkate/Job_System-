package com.amineaharkate.job_api.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class appConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new  RestTemplate();
    }
}
