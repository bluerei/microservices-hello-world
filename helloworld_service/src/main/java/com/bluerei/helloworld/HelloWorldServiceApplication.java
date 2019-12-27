package com.bluerei.helloworld;

import com.bluerei.helloworld.api.Response;
import com.bluerei.helloworld.client.GetNameClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@Slf4j
public class HelloWorldServiceApplication {
    @Autowired
    private GetNameClient nameClient;

    @RequestMapping("/")
    public Response getResponse() {
        String name = nameClient.getName();
        String greeting = "Hello " + name + "!";
        return new Response(greeting);
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldServiceApplication.class, args);
        log.info("HelloWorldServiceApplication is started.");
    }



}
