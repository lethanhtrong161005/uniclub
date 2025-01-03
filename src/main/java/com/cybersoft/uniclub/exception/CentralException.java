package com.cybersoft.uniclub.exception;

import com.cybersoft.uniclub.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralException {

    @ExceptionHandler({InsertException.class})
    public ResponseEntity<?> centrallog(InsertException e){
        BaseResponse response = new BaseResponse();
        response.setMessage("Error" + e.getMessage());

        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<?> centralLogFileUpload(FileUploadException e){
        BaseResponse response = new BaseResponse();
        response.setMessage("Error" + e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

}
