package com.thorouci.service.authentication.connector;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.thorouci.service.authentication.config.UserServiceProperties;

@Component
public class UserConnector {
    
    private UserServiceProperties userServiceProperties;
    private RestTemplate restTemplate;

    public UserConnector(UserServiceProperties properties) {
        this.userServiceProperties = properties;
        this.restTemplate = new RestTemplateBuilder().basicAuthentication(userServiceProperties.getUsername(), userServiceProperties.getPassword()).build();
    }

    public User getUserByUserName(String username) {
        //serviceProperties
        URI url = UriComponentsBuilder.newInstance()
            .scheme(userServiceProperties.getSchema())
            .host(userServiceProperties.getHost())
            .port(String.valueOf(userServiceProperties.getPort()))
            .path(userServiceProperties.getPath())
            .pathSegment(username).build().toUri();
        var user = restTemplate.getForObject(url, com.thorouci.service.model.User.class);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
