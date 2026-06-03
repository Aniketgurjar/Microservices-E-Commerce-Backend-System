package com.example.productfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableElasticsearchRepositories
public class ProductFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductFinalApplication.class, args);
    }

}
