package com.example.productfinal.confige;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


// RestTemplate ek Spring ka HTTP client hai jo external APIs ko call karne ke kaam aata hai.
// Isse hum GET, POST, PUT, DELETE jaise HTTP requests easily bhej sakte hain.
// Ye basically backend se doosre server, microservice ya third-party API ko hit karne ke liye use hota hai.
// RestTemplate synchronous hota hai — yani request bhejoge, response aane tak wait karega.
// REST API calls ko simplify karne ke liye Spring Boot me ye bahut commonly use hota hai.

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
