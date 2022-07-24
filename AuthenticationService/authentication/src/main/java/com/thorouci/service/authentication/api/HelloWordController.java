package com.thorouci.service.authentication.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloWordController {
    
    @GetMapping
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
