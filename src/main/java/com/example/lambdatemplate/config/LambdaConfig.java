package com.example.lambdatemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.example.lambdatemplate.api.interceptor.ApiKeyInterceptor;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;


@Configuration
@ComponentScan(basePackages = "com.example.lambdatemplate") //Since its lambda, we need to Manually tell spring to scan all required dependencies for injection
public class LambdaConfig {

    @Value("${api.key}")
    private String apikey;

    @Bean
    public ApiKeyInterceptor apiKeyInterceptor(){
        return new ApiKeyInterceptor(apikey);
    }
    
    @Bean
    public RestTemplate restTemplate(ApiKeyInterceptor apiKeyInterceptor){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(apiKeyInterceptor));
        return restTemplate;
    }
}
