package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.response.BaseResponse;
import com.cybersoft.uniclub.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login") // lỗi cor
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        String token = loginService.login(email, password);
        BaseResponse response = new BaseResponse();
        response.setData(token);
        response.setCode(200);
        return ResponseEntity.ok(response);
    }

}
