package com.service.user.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.service.user.model.User;
import com.service.user.service.UserService;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-10T10:41:55.316283+07:00[Asia/Ho_Chi_Minh]")
@Controller
@RequestMapping("/users")
public class UsersApiController implements UsersApi {

    private Logger logger = LoggerFactory.getLogger(UsersApiController.class);
    
    private final UserService userService;
    private final NativeWebRequest request;

    public UsersApiController(NativeWebRequest request, UserService service) {
        this.request = request;
        this.userService = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public User doAddUser(@Valid User user) {
        logger.info("doAddUser: user {}", user);
        return userService.addUser(user);
    }

    @Override
    public User doGetUserByUserName(String userName) {
        return userService.getUserByUserName(userName);
    }

    @Override
    public List<User> doListUsers() {
        return userService.getListUsers();
    }

}
