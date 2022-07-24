package com.thorouci.service.authentication.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("service.user")
public class UserServiceProperties {
        private String schema;
        private String host;
        private Integer port;
        private String path;
        private String username;
        private String password;
}
