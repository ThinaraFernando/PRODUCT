package com.ijse.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.product.entity.product;
import com.ijse.product.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody product product) { 

        if(product.getProductName() == null || product.getProductName().isEmpty()) { 
            return ResponseEntity.status(400).body("Please enter a valid product name");
        }

        if(product.getDescription() == null) { 
            return ResponseEntity.status(400).body("Please enter a valid description");
        }

        try {
            product createdProduct = productService.createproduct(product); 
            return ResponseEntity.status(201).body(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<product>> getAllProducts() {
        List<product> products = productService.getAllpProducts();
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<product> getProductById(@PathVariable Long productId) {
        product product = productService.getproductById(productId); 
        if(product == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<product> updateProduct(@PathVariable Long productId, @RequestBody product product) { 
        product updatedProduct = productService.updateProduct(productId, product); 

        if(updatedProduct == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updatedProduct);
        }
    }
}
