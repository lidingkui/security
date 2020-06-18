package com.websoket.websoket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebsoketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsoketApplication.class, args);
    }

}
