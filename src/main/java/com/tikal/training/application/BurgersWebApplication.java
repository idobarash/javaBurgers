package com.tikal.training.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.tikal.training")
public class BurgersWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BurgersWebApplication.class, args);
    }
}
