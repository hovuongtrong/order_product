package com.service.user.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.service.user.mapper.UserMapper;
import com.service.user.model.User;
import com.service.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    /**
     * @return list of users
     */
    public List<User> getListUsers() {
        return repository.findAll().stream().map(mapper::mapToModel).collect(Collectors.toList());
    }

    public User getUserByUserName(String userName) {
        return repository.findByLogin(userName).map(mapper::mapToModel).orElseThrow(() -> new IllegalStateException("The user name is exised"));
    }

    public User addUser(User user) {
        if (repository.findByLogin(user.getUsername()).isPresent()) {
            throw new IllegalStateException("The user name is exised");
        }

        repository.save(mapper.mapToEntity(user));
        return user;
    }

    public void deleteUserByUserName(String userName) {
        // do not implemented
    }
}