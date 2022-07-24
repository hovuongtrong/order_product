package com.service.user.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.service.user.entity.UserEntity;
import com.service.user.entity.UserRole;
import com.service.user.model.User;
import com.service.user.model.UserStatus;

@Component
public class UserMapper {
    
    @Autowired
    private PasswordEncoder encoder;
    
    public UserEntity mapToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setLogin(user.getUsername());
        entity.setPassword(encoder.encode(user.getPassword()));
        entity.setFullname(user.getFullname());
        entity.setAddress(user.getAddress());
        entity.setName(user.getName());
        entity.setPhone(user.getPhonenumber());
        entity.setRole(UserRole.valueOf(user.getRole()));
        entity.setStatus(UserStatus.DEACTIVATED);
        return entity;
    }

    public User mapToModel(UserEntity entity) {
        User user = new User();
        user.setAddress(entity.getAddress());
        user.setFullname(entity.getFullname());
        user.setName(entity.getName());
        user.setPhonenumber(entity.getPhone());
        user.setRole(entity.getRole().toString());
        user.setStatus(entity.getStatus().toString());
        user.setUsername(entity.getLogin());
        user.setPassword(entity.getPassword());
        return user;
    }
}
