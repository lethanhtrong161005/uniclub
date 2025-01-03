package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.exception.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServicesImp implements FileServices {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void copyFile(MultipartFile multipartFile) {
        try {
            Path root = Paths.get(uploadPath);
            if(!Files.exists(root)) {
                Files.createDirectory(root);
            }
            // resolve đấu sẹch đường dẫn của file
            Path pathFile = root.resolve(multipartFile.getOriginalFilename());
            Files.copy(multipartFile.getInputStream(), pathFile, StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            throw new FileUploadException("Error occured while uploading file" + e.getMessage());
        }
    }

    @Override
    public Resource loadFile(String fileName) {
        try{
            Path root = Paths.get(uploadPath).resolve(fileName);
            Resource resource = new UrlResource(root.toUri());
            if(resource.exists()){
                return resource;
            }
            throw new FileNotFoundException("File not found: " + fileName);
        }catch (Exception e){
            throw new FileUploadException("Error occured while uploading file" + e.getMessage());
        }
    }

}
