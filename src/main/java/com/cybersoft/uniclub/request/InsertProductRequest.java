package com.cybersoft.uniclub.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InsertProductRequest {
    private MultipartFile file;
    private String name;
    private double price;
    private int idBrand;
    private int idColor;
    private int idSize;
    private int quantity;
}
