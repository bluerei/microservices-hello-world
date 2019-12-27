package com.bluerei.helloworld.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Client of 'getname-service'. It retrieves the second part (name) of 'Hello World' message from
 * the service.
 */

@Component
@Slf4j
public class GetNameClient {
    private static final String SERVICE_NAME = "getname-service";
    private static final String CIRCUIT_BREAKER_NAME = "CIRCUIT BREAKER";

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private EurekaClient discoveryClient;

    /**
     * Calls 'getname-service' and gets the  second part of the 'Hello World' message. It is using
     * Hystrix circuit breaker, so if the 'getname-service' is not available, it gets the name from
     * getNameFallback() method.
     *
     * @return name
     */
    @HystrixCommand(fallbackMethod = "getNameFallback")
    public String getName() {
        return restTemplate.getForObject(getUrl(), String.class);
    }

    /**
     * Circuit beaker fallback method. It returns CIRCUIT_BREAKER_NAME if the getname-service is not
     * available.
     */
    public String getNameFallback() {
        log.info("Service {} is down. Using default name.", SERVICE_NAME);
        return CIRCUIT_BREAKER_NAME;
    }

    /**
     * Retreives URL of the next available 'getname-service' microservice via Eureka discovery
     * service
     *
     * @return URL
     */
    private String getUrl() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka(SERVICE_NAME, false);
        return instanceInfo.getHomePageUrl();
    }
}
