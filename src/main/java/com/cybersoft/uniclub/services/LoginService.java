package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.entities.UserEntity;
import com.cybersoft.uniclub.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.key}")
    private String keyJWT;

    public String login(String email, String password) {
        String token = "";
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            //Có giá trị
            //Huỷ optional đi
            UserEntity userEntity = user.get();
            if(passwordEncoder.matches(password,userEntity.getPassword())){
                //Tạo token
                SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keyJWT));

                String jws = Jwts.builder().subject(userEntity.getRole().getName()).signWith(key).compact();
                token = jws;
            }
        }
        return token;
    }

}
