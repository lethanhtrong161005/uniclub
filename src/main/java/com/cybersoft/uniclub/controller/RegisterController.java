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
        boolean isSuccess = registerService.insertUser(registerRequest);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(isSuccess ? 200 : 400);
        baseResponse.setMessage(isSuccess ? "Success" : "Fail");
        baseResponse.setData(isSuccess);

        return ResponseEntity.ok(baseResponse);
    }

}
