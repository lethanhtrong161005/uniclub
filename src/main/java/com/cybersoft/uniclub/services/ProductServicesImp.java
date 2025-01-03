package com.cybersoft.uniclub.services;

import com.cybersoft.uniclub.dto.ProductDTO;
import com.cybersoft.uniclub.entities.*;
import com.cybersoft.uniclub.exception.InsertException;
import com.cybersoft.uniclub.repository.ProductRepository;
import com.cybersoft.uniclub.repository.VariantRepository;
import com.cybersoft.uniclub.request.InsertProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServicesImp implements ProductServices {
    @Autowired
    private FileServices fileServices;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Transactional // tạo transactional khi 1 luồn dữ liệu bị lỗi thì nó sẽ tự đông huỷ tất cả.
    @Override     // nhược điểm nặng -> nên dùng từ 2 bảng trở lên
    public void insertProduct(InsertProductRequest request){
        try{
            fileServices.copyFile(request.getFile());

            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(request.getName());
            productEntity.setPrice(request.getPrice());

            BrandEntity brandEntity = new BrandEntity();
            brandEntity.setId(request.getIdBrand());
            productEntity.setBrand(brandEntity);

            ProductEntity productInserted = productRepository.save(productEntity);

            VariantEntity variantEntity = new VariantEntity();
            variantEntity.setProduct(productInserted);

            ColorEntity colorEntity = new ColorEntity();
            colorEntity.setId(request.getIdColor());
            variantEntity.setColor(colorEntity);

            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity.setId(request.getIdSize());
            variantEntity.setSize(sizeEntity);

            variantEntity.setImages(request.getFile().getOriginalFilename());
            variantEntity.setQuantity(request.getQuantity());
            variantEntity.setPrice(request.getPrice());
            variantRepository.save(variantEntity);

        }catch (Exception e){
            throw new InsertException(e.getMessage());
        }
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(data ->{
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(data.getId());
            productDTO.setName(data.getName());
            productDTO.setPrice(data.getPrice());
            productDTO.setImages("http://localhost:8080/download/" + (!data.getVariants().isEmpty() ? data.getVariants().get(0).getImages() : ""));
            return productDTO;
        }).toList();
    }

}
