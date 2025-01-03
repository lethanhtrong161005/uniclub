package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.entities.UserEntity;
import com.cybersoft.uniclub.exception.InsertException;
import com.cybersoft.uniclub.repository.UserRepository;
import com.cybersoft.uniclub.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void insertUser(RegisterRequest registerRequest) {
        try{ // grpc => binary giao tiếp giữa server với server
            String encryptedPass = passwordEncoder.encode(registerRequest.getPassword());

            UserEntity user = new UserEntity();
            user.setPassword(encryptedPass);
            user.setFullName(registerRequest.getFullname());
            user.setEmail(registerRequest.getEmail());

            userRepository.save(user);
        }catch (Exception e){
            throw new InsertException(e.getMessage());
        }
    }

}
