package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);

    }

    // LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestBody Map<String, String> loginData
    ) {

        String email = loginData.get("email");

        String password = loginData.get("password");

        User user = userService.login(email, password);

        // Generate JWT Token
        String token =
                jwtUtil.generateToken(user.getEmail());

        // Response Map
        Map<String, Object> response =
                new HashMap<>();

        response.put("token", token);

        response.put("user", user);

        return response;
    }

}