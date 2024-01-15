package com.kosmos.bootscord.controller;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/createUser")
    BootscordUser createUser(@RequestBody BootscordUser request) {
        System.out.println("InsideCreateUser!!!!");
        System.out.println(request);
        return service.registerUser(request);
    }
}
