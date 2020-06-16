package com.catservice.WebSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling //该注解是开启定时任务的支持
public class WebsocketApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebsocketApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);


    }
}
