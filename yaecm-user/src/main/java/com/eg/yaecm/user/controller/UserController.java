package com.eg.yaecm.user.controller;

import com.eg.yaecm.user.config.JwtUtil;
import com.eg.yaecm.user.req.AuthReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthReq authReq) {
        // Validate the user credentials here (username and password)
        if ("user".equals(authReq.username) && "password".equals(authReq.password)) {
            return jwtUtil.generateToken(authReq.username);
        }
        return "Invalid credentials!";
    }
}
