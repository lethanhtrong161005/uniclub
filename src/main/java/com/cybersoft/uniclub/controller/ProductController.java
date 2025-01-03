package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.request.InsertProductRequest;
import com.cybersoft.uniclub.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping
    public ResponseEntity<?> insertProduct(InsertProductRequest request){
        productServices.insertProduct(request);
        return ResponseEntity.ok("Insert product");
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productServices.getAllProducts());
    }

}
