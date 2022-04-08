package com.basakozdemir.earthquakeconsumer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    // Create bean constructor since RestTemplate has no injection point
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
