package com.bluerei.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class GetNameServiceApplication {
    private static final String UNKNOWN_NAME = "unknown";

    @Autowired
    private ConfigProperties properties;

    @RequestMapping("/")
    public String getName() {
        String name =  properties.getName();
        if(StringUtils.isEmpty(name)) {
            log.debug("'name' is not defined in the property file.");
            return UNKNOWN_NAME;
        }

        log.debug("retreived 'name' value from the property file. Name={}", name);
        return name;
    }

    public static void main(String[] args) {
        SpringApplication.run(GetNameServiceApplication.class, args);
        log.info("GetNameServiceApplication is started.");
    }
}