package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.entities.UserEntity;
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

    public boolean insertUser(RegisterRequest registerRequest) {
        boolean result = false;
        try{ // grpc => binary giao tiếp giữa server với server
            String encryptedPass = passwordEncoder.encode(registerRequest.getPassword());

            UserEntity user = new UserEntity();
            user.setPassword(encryptedPass);
            user.setFullName(registerRequest.getFullname());
            user.setEmail(registerRequest.getEmail());

            userRepository.save(user);
            result = true;
        }catch (Exception e){
            System.out.println("Kiem Tra" + e.getMessage());
        }
        return result;
    }

}
