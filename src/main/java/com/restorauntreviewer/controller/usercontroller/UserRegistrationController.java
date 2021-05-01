package com.restorauntreviewer.controller.usercontroller;

import com.restorauntreviewer.model.User;
import com.restorauntreviewer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = UserRegistrationController.REST_URL)

public class UserRegistrationController {
    public static final String REST_URL = "/api/v1/auth/register";

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerUserAccount(@RequestBody User user) {
        userService.register(user);
        return user;
    }
}