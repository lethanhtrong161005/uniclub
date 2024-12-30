package com.cybersoft.uniclub.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterRequest {
    private String fullname;

    @NotBlank(message = "Password can't blank")
    // @Pattern(regexp = "định dạng mật khẩu")
    private String password;


    @Email(message = "Wrong email format")
    private String email;
}
