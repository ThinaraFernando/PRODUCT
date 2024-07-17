package com.ijse.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.product.entity.product;
import com.ijse.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository; 

    @Override
    public product createproduct(product product) { 
        return productRepository.save(product);
    }

    @Override
    public List<product> getAllpProducts() { 
        return productRepository.findAll();
    }

    @Override
    public product getproductById(Long id) { 
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public product updateProduct(Long id,product product) { 
        product existingProduct = productRepository.findById(id).orElse(null);

        if(existingProduct == null) {
            return null;
        } else {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }
    }

    
    
}
