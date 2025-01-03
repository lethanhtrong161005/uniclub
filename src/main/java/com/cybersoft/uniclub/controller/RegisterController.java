package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.request.RegisterRequest;
import com.cybersoft.uniclub.response.BaseResponse;
import com.cybersoft.uniclub.services.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    //fullname, email, password
    @Autowired
    private RegisterService registerService;
    @PostMapping
    public ResponseEntity<?> registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        registerService.insertUser(registerRequest);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("Success");
        baseResponse.setData(true);

        return ResponseEntity.ok(baseResponse);
    }

}
