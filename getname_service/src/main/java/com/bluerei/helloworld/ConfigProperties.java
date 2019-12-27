package com.bluerei.helloworld;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "helloworld")
public class ConfigProperties {
    private String name;

    public String getName() {
        return name;
    }

      public void setName(String name) {
        this.name = name;
    }
}
