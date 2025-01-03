package com.cybersoft.uniclub.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertException extends RuntimeException {
    private String message;
//    public InsertException(String message) {
//        super(message);
//        this.message = message;
//    }
}
