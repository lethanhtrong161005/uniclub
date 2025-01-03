package com.cybersoft.uniclub.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServices {
    void copyFile(MultipartFile multipartFile);
    Resource loadFile(String fileName);
}
