package com.ijse.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.product.entity.product;

@Service
public interface ProductService {
    product createproduct(product product);
    List<product> getAllpProducts();
    product getproductById(Long id);
    product updateProduct(Long id, product product);
    
}
