package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.dto.ProductDTO;
import com.cybersoft.uniclub.request.InsertProductRequest;

import java.util.List;


public interface ProductServices {
    void insertProduct(InsertProductRequest request);
    List<ProductDTO> getAllProducts();
}
