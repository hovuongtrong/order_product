package com.thorouci.service.authentication.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserServiceProperties.class)
public class PropertyConfiguration {
    
}
