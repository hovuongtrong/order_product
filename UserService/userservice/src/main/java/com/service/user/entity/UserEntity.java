package com.service.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.service.user.model.UserStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USERS")
public class UserEntity {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;
  
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullname;
  
    @Column(name = "phone_number")
    private Long phone;
  
    @Column(name = "address")
    private String address;
  
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;
}
