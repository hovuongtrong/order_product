package com.thorouci.service.authentication.authen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.thorouci.service.authentication.connector.UserConnector;

@Component
public class UserAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserConnector connector;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var user = connector.getUserByUserName(authentication.getName());
        if (user == null) {
            throw new UsernameNotFoundException("User name not found");
        }
        if (encoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
            return authentication;
        }
        throw new BadCredentialsException("User name or password was wrong");
    }
    
}
